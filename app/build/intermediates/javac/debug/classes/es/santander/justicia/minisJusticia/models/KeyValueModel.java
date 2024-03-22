package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import android.database.Cursor;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

public class KeyValueModel {
   private static KeyValueModel instance;
   private static KeyValueModel instancePermanet;
   public static final String TABLE_NAME = "keyvalue";
   public static final String TABLE_NAME_PERMANENT = "permanentkeyvalue";
   public static final String ID_COLUMN = "_id";
   public static final String KEY_COLUMN = "key";
   public static final String VALUE_COLUMN = "value";
   public static final String HORARIOS_SALUDO = "horarioSaludo.";
   public static final String ESTACIONES_VIDEO = "estacionesVideo.";
   public static final String TEALIUM_ENVIRONMENT = "tealiumProp.environment.";
   public static final String AYUDA_INFO = "aInfo.";
   public static final String PROFESIONAL_LETRADO_SELECCION = "pls";
   private static Map<String, String> cacheValores = new HashMap();
   private String tableName;

   public static synchronized KeyValueModel getInstance() {
      if (instance == null) {
         instance = new KeyValueModel("keyvalue");
      }

      return instance;
   }

   public static synchronized KeyValueModel getInstancePermanent() {
      if (instancePermanet == null) {
         instancePermanet = new KeyValueModel("permanentkeyvalue");
      }

      return instancePermanet;
   }

   public KeyValueModel(String tableName) {
      this.tableName = tableName;
   }

   public String getCreateTableQuery() {
      String query = "CREATE TABLE " + this.tableName + "(" + "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, " + "key" + " TEXT, " + "value" + " TEXT)";
      return query;
   }

   public boolean insertValue(String prefix, String key, String value) {
      SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
      boolean response = this.insertValue(db, prefix + key, value);
      db.close();
      return response;
   }

   public boolean insertValue(SQLiteDatabase db, String prefix, String key, String value) {
      return this.insertValue(db, prefix + key, value);
   }

   public boolean insertValue(SQLiteDatabase db, String key, String value) {
      cacheValores.put(key, value);
      boolean response = false;
      ContentValues values = new ContentValues();
      values.put("key", key);
      values.put("value", value);
      if (db.insert(this.tableName, (String)null, values) != -1L) {
         response = true;
      }

      return response;
   }

   public String getValue(String prefix, String key) {
      return this.getValue(prefix + key);
   }

   public String getValue(String key) {
      String value = (String)cacheValores.get(key);
      if (value == null) {
         Map<String, String> valueMap = this.getValueMap(key);
         value = (String)valueMap.get(key);
         cacheValores.put(key, value);
      }

      return value;
   }

   public Map<String, String> getValueMap(String key) {
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
      Map<String, String> valueMap = this.getValueMap(db, key);
      db.close();
      return valueMap;
   }

   public Map<String, String> getValueMap(SQLiteDatabase db, String key) {
      Map<String, String> valueMap = new HashMap();
      String[] columns = new String[]{"key", "value"};
      String where = "key like '%" + key + "%'";
      Cursor cursor = db.query(this.tableName, columns, where, (String[])null, (String)null, (String)null, (String)null);
      if (cursor.moveToFirst()) {
         do {
            valueMap.put(cursor.getString(0), cursor.getString(1));
         } while(cursor.moveToNext());
      }

      cursor.close();
      return valueMap;
   }

   public void deleteAllData() {
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
      db.delete(this.tableName, (String)null, (String[])null);
      db.close();
   }

   public void deleteAllData(SQLiteDatabase db) {
      db.delete(this.tableName, (String)null, (String[])null);
   }

   public String getDropTableQuery() {
      String query = "DROP TABLE IF EXISTS " + this.tableName;
      return query;
   }
}
