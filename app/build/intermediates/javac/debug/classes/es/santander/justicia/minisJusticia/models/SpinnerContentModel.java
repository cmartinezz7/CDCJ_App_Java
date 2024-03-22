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
   public static final String TABLE_NAME = "spinner_content";
   public static final String ID_COLUMN = "_id";
   public static final String NAME_COLUMN = "name";
   public static final String TABLE_NAME_VALUES = "spinner_values";
   public static final String SPINNER_CONTENT_ID_COLUMN = "spinner_content_id";
   public static final String POSITION_COLUMN = "position";
   public static final String CODE_COLUMN = "code";
   public static final String ESP_VALUE_COLUMN = "esp_value";
   public static final String ENG_VALUE_COLUMN = "eng_value";
   private static Map<String, ArrayList<SpinnerValuesDTO>> cacheValores = new HashMap();

   public static String getCreateTableQuery() {
      String query = "CREATE TABLE spinner_content (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
      return query;
   }

   public static String getDropTableQuery() {
      String query = "DROP TABLE IF EXISTS spinner_content";
      return query;
   }

   public static String getCreateTableValuesQuery() {
      String query = "CREATE TABLE spinner_values (_id INTEGER PRIMARY KEY AUTOINCREMENT, spinner_content_id INTEGER, position INTEGER DEFAULT -1, code TEXT, esp_value TEXT, eng_value TEXT)";
      return query;
   }

   public static String getDropTableValuesQuery() {
      String query = "DROP TABLE IF EXISTS spinner_values";
      return query;
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
      long newId = db.insert("spinner_content", (String)null, values);
      return newId;
   }

   public static boolean insertSpinnerValues(SQLiteDatabase db, String name, ArrayList<SpinnerValuesDTO> spinnerValues) {
      boolean response = false;
      cacheValores.put(name, spinnerValues);

      try {
         db.beginTransaction();
         Iterator var4 = spinnerValues.iterator();

         while(var4.hasNext()) {
            SpinnerValuesDTO spnValues = (SpinnerValuesDTO)var4.next();
            ContentValues values = new ContentValues();
            values.put("spinner_content_id", spnValues.getSpinnerContentId());
            values.put("position", spnValues.getPosition());
            values.put("code", spnValues.getCode());
            values.put("esp_value", spnValues.getEspValue());
            values.put("eng_value", spnValues.getEngValue());
            db.insert("spinner_values", (String)null, values);
         }

         db.setTransactionSuccessful();
         response = true;
         return response;
      } finally {
         db.endTransaction();
      }
   }

   public static void deleteAllData() {
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
      db.delete("spinner_content", (String)null, (String[])null);
      db.delete("spinner_values", (String)null, (String[])null);
      db.close();
   }

   public static void deleteAllData(SQLiteDatabase db) {
      db.delete("spinner_content", (String)null, (String[])null);
      db.delete("spinner_values", (String)null, (String[])null);
   }

   public static ArrayList<SpinnerValuesDTO> getSpinnerValues(String spinnerName) {
      ArrayList<SpinnerValuesDTO> spinnerValuesList = (ArrayList)cacheValores.get(spinnerName);
      Iterator var6;
      SpinnerValuesDTO spinnerValuesDTO;
      if (spinnerValuesList == null) {
         MinJusticeDBHelper.getInstance();
         SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
         spinnerValuesList = new ArrayList();
         String query = "SELECT sv.code, sv.esp_value, sv.eng_valueFROM spinner_content sc\nINNER JOIN spinner_values sv ON sv.spinner_content_id = sc._id \nWHERE sc.name = \"" + spinnerName + "\" ORDER BY sv." + "position" + " ASC";
         Cursor cursor = db.rawQuery(query, (String[])null);
         if (cursor.moveToFirst()) {
            do {
               SpinnerValuesDTO spnValues = new SpinnerValuesDTO();
               spnValues.setCode(cursor.getString(cursor.getColumnIndexOrThrow("code")));
               spnValues.setEspValue(cursor.getString(cursor.getColumnIndexOrThrow("esp_value")));
               spnValues.setEngValue(cursor.getString(cursor.getColumnIndexOrThrow("eng_value")));
               spinnerValuesList.add(spnValues);
            } while(cursor.moveToNext());
         }

         cursor.close();
         db.close();
         cacheValores.put(spinnerName, spinnerValuesList);
      } else {
         var6 = spinnerValuesList.iterator();

         while(var6.hasNext()) {
            spinnerValuesDTO = (SpinnerValuesDTO)var6.next();
            spinnerValuesDTO.setValueToShow(spinnerValuesDTO.getEspValue());
         }
      }

      if (spinnerValuesList != null && !spinnerValuesList.isEmpty()) {
         var6 = spinnerValuesList.iterator();

         while(var6.hasNext()) {
            spinnerValuesDTO = (SpinnerValuesDTO)var6.next();
            String languageColumn = "esp_value";
            spinnerValuesDTO.setValueToShow(spinnerValuesDTO.getEspValue());
         }
      }

      return spinnerValuesList;
   }
}
