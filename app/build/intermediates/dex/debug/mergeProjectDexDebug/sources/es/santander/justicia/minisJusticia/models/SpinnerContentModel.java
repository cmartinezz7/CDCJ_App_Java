package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import android.database.Cursor;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

public class SpinnerContentModel {
    public static final String CODE_COLUMN = "code";
    public static final String ENG_VALUE_COLUMN = "eng_value";
    public static final String ESP_VALUE_COLUMN = "esp_value";
    public static final String ID_COLUMN = "_id";
    public static final String NAME_COLUMN = "name";
    public static final String POSITION_COLUMN = "position";
    public static final String SPINNER_CONTENT_ID_COLUMN = "spinner_content_id";
    public static final String TABLE_NAME = "spinner_content";
    public static final String TABLE_NAME_VALUES = "spinner_values";
    private static Map<String, ArrayList<SpinnerValuesDTO>> cacheValores = new HashMap();

    public static String getCreateTableQuery() {
        return "CREATE TABLE spinner_content (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
    }

    public static String getDropTableQuery() {
        return "DROP TABLE IF EXISTS spinner_content";
    }

    public static String getCreateTableValuesQuery() {
        return "CREATE TABLE spinner_values (_id INTEGER PRIMARY KEY AUTOINCREMENT, spinner_content_id INTEGER, position INTEGER DEFAULT -1, code TEXT, esp_value TEXT, eng_value TEXT)";
    }

    public static String getDropTableValuesQuery() {
        return "DROP TABLE IF EXISTS spinner_values";
    }

    public static long insert(String name) {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        long newId = insert(db, name);
        db.close();
        return newId;
    }

    public static long insert(SQLiteDatabase db, String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        return db.insert(TABLE_NAME, (String) null, values);
    }

    public static boolean insertSpinnerValues(SQLiteDatabase db, String name, ArrayList<SpinnerValuesDTO> spinnerValues) {
        cacheValores.put(name, spinnerValues);
        try {
            db.beginTransaction();
            Iterator<SpinnerValuesDTO> it = spinnerValues.iterator();
            while (it.hasNext()) {
                SpinnerValuesDTO spnValues = it.next();
                ContentValues values = new ContentValues();
                values.put(SPINNER_CONTENT_ID_COLUMN, Long.valueOf(spnValues.getSpinnerContentId()));
                values.put(POSITION_COLUMN, Integer.valueOf(spnValues.getPosition()));
                values.put("code", spnValues.getCode());
                values.put(ESP_VALUE_COLUMN, spnValues.getEspValue());
                values.put(ENG_VALUE_COLUMN, spnValues.getEngValue());
                db.insert(TABLE_NAME_VALUES, (String) null, values);
            }
            db.setTransactionSuccessful();
            return true;
        } finally {
            db.endTransaction();
        }
    }

    public static void deleteAllData() {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        db.delete(TABLE_NAME, (String) null, (String[]) null);
        db.delete(TABLE_NAME_VALUES, (String) null, (String[]) null);
        db.close();
    }

    public static void deleteAllData(SQLiteDatabase db) {
        db.delete(TABLE_NAME, (String) null, (String[]) null);
        db.delete(TABLE_NAME_VALUES, (String) null, (String[]) null);
    }

    public static ArrayList<SpinnerValuesDTO> getSpinnerValues(String spinnerName) {
        ArrayList<SpinnerValuesDTO> spinnerValuesList = cacheValores.get(spinnerName);
        if (spinnerValuesList == null) {
            MinJusticeDBHelper.getInstance();
            SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
            spinnerValuesList = new ArrayList<>();
            Cursor cursor = db.rawQuery("SELECT sv.code, sv.esp_value, sv.eng_valueFROM spinner_content sc\nINNER JOIN spinner_values sv ON sv.spinner_content_id = sc._id \nWHERE sc.name = \"" + spinnerName + "\" ORDER BY sv." + POSITION_COLUMN + " ASC", (String[]) null);
            if (cursor.moveToFirst()) {
                do {
                    SpinnerValuesDTO spnValues = new SpinnerValuesDTO();
                    spnValues.setCode(cursor.getString(cursor.getColumnIndexOrThrow("code")));
                    spnValues.setEspValue(cursor.getString(cursor.getColumnIndexOrThrow(ESP_VALUE_COLUMN)));
                    spnValues.setEngValue(cursor.getString(cursor.getColumnIndexOrThrow(ENG_VALUE_COLUMN)));
                    spinnerValuesList.add(spnValues);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            cacheValores.put(spinnerName, spinnerValuesList);
        } else {
            Iterator<SpinnerValuesDTO> it = spinnerValuesList.iterator();
            while (it.hasNext()) {
                SpinnerValuesDTO spinnerValuesDTO = it.next();
                spinnerValuesDTO.setValueToShow(spinnerValuesDTO.getEspValue());
            }
        }
        if (spinnerValuesList != null && !spinnerValuesList.isEmpty()) {
            Iterator<SpinnerValuesDTO> it2 = spinnerValuesList.iterator();
            while (it2.hasNext()) {
                SpinnerValuesDTO spinnerValuesDTO2 = it2.next();
                spinnerValuesDTO2.setValueToShow(spinnerValuesDTO2.getEspValue());
            }
        }
        return spinnerValuesList;
    }
}
