package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import android.database.Cursor;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

public class KeyValueModel {
    public static final String AYUDA_INFO = "aInfo.";
    public static final String ESTACIONES_VIDEO = "estacionesVideo.";
    public static final String HORARIOS_SALUDO = "horarioSaludo.";
    public static final String ID_COLUMN = "_id";
    public static final String KEY_COLUMN = "key";
    public static final String PROFESIONAL_LETRADO_SELECCION = "pls";
    public static final String TABLE_NAME = "keyvalue";
    public static final String TABLE_NAME_PERMANENT = "permanentkeyvalue";
    public static final String TEALIUM_ENVIRONMENT = "tealiumProp.environment.";
    public static final String VALUE_COLUMN = "value";
    private static Map<String, String> cacheValores = new HashMap();
    private static KeyValueModel instance;
    private static KeyValueModel instancePermanet;
    private String tableName;

    public static synchronized KeyValueModel getInstance() {
        KeyValueModel keyValueModel;
        synchronized (KeyValueModel.class) {
            if (instance == null) {
                instance = new KeyValueModel(TABLE_NAME);
            }
            keyValueModel = instance;
        }
        return keyValueModel;
    }

    public static synchronized KeyValueModel getInstancePermanent() {
        KeyValueModel keyValueModel;
        synchronized (KeyValueModel.class) {
            if (instancePermanet == null) {
                instancePermanet = new KeyValueModel(TABLE_NAME_PERMANENT);
            }
            keyValueModel = instancePermanet;
        }
        return keyValueModel;
    }

    public KeyValueModel(String tableName2) {
        this.tableName = tableName2;
    }

    public String getCreateTableQuery() {
        return "CREATE TABLE " + this.tableName + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_COLUMN + " TEXT, " + VALUE_COLUMN + " TEXT)";
    }

    public boolean insertValue(String prefix, String key, String value) {
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        boolean response = insertValue(db, prefix + key, value);
        db.close();
        return response;
    }

    public boolean insertValue(SQLiteDatabase db, String prefix, String key, String value) {
        return insertValue(db, prefix + key, value);
    }

    public boolean insertValue(SQLiteDatabase db, String key, String value) {
        cacheValores.put(key, value);
        ContentValues values = new ContentValues();
        values.put(KEY_COLUMN, key);
        values.put(VALUE_COLUMN, value);
        if (db.insert(this.tableName, (String) null, values) != -1) {
            return true;
        }
        return false;
    }

    public String getValue(String prefix, String key) {
        return getValue(prefix + key);
    }

    public String getValue(String key) {
        String value = cacheValores.get(key);
        if (value != null) {
            return value;
        }
        String value2 = getValueMap(key).get(key);
        cacheValores.put(key, value2);
        return value2;
    }

    public Map<String, String> getValueMap(String key) {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
        Map<String, String> valueMap = getValueMap(db, key);
        db.close();
        return valueMap;
    }

    public Map<String, String> getValueMap(SQLiteDatabase db, String key) {
        Map<String, String> valueMap = new HashMap<>();
        SQLiteDatabase sQLiteDatabase = db;
        Cursor cursor = sQLiteDatabase.query(this.tableName, new String[]{KEY_COLUMN, VALUE_COLUMN}, "key like '%" + key + "%'", (String[]) null, (String) null, (String) null, (String) null);
        if (cursor.moveToFirst()) {
            do {
                valueMap.put(cursor.getString(0), cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return valueMap;
    }

    public void deleteAllData() {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        db.delete(this.tableName, (String) null, (String[]) null);
        db.close();
    }

    public void deleteAllData(SQLiteDatabase db) {
        db.delete(this.tableName, (String) null, (String[]) null);
    }

    public String getDropTableQuery() {
        return "DROP TABLE IF EXISTS " + this.tableName;
    }
}
