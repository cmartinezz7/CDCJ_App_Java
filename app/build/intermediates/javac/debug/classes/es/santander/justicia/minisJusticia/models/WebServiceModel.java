package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import android.database.Cursor;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.utils.MinJusticeDBHelper;
import net.sqlcipher.database.SQLiteDatabase;

public class WebServiceModel {
   public static final String TABLE_NAME = "web_service";
   public static final String ID_COLUMN = "_id";
   public static final String NAME_COLUMN = "name";

   public static String getCreateTableQuery() {
      String query = "CREATE TABLE web_service (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
      return query;
   }

   public static String getDropTableQuery() {
      String query = "DROP TABLE IF EXISTS web_service";
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
      long newId = db.insert("web_service", (String)null, values);
      return newId;
   }

   public static void deleteAllData() {
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
      db.delete("web_service", (String)null, (String[])null);
      db.close();
   }

   public static void deleteAllData(SQLiteDatabase db) {
      db.delete("web_service", (String)null, (String[])null);
   }

   public static WebServiceSettingsDTO getWebServiceSettings(String webServiceName, String environment) {
      WebServiceSettingsDTO wsSettings = null;
      SQLiteDatabase db = null;
      MinJusticeDBHelper.getInstance();
      db = MinJusticeDBHelper.getReadableDatabase();
      String query = "SELECT wss.web_service_id, wss.url, wss.urlCertificate, wss.connection_timeout, wss.receive_timeout FROM web_service ws\nINNER JOIN web_service_settings wss ON wss.web_service_id = ws._id\nwhere ws.name = \"" + webServiceName + "\" AND wss." + "environment" + " = \"" + environment + "\"";
      Cursor cursor = db.rawQuery(query, (String[])null);
      if (cursor.moveToFirst()) {
         wsSettings = new WebServiceSettingsDTO();
         wsSettings.setWebServiceId((long)cursor.getInt(cursor.getColumnIndexOrThrow("web_service_id")));
         wsSettings.setUrl(cursor.getString(cursor.getColumnIndexOrThrow("url")));
         if (MainApplication.ENV_DEFAULT == "PROD") {
            wsSettings.setUrlCertificate(cursor.getString(cursor.getColumnIndexOrThrow("urlCertificate")));
         }

         wsSettings.setConnectionTimeout(cursor.getInt(cursor.getColumnIndexOrThrow("connection_timeout")));
         wsSettings.setReadTimeout(cursor.getInt(cursor.getColumnIndexOrThrow("receive_timeout")));
         wsSettings.setEnvironment(environment);
      }

      cursor.close();
      db.close();
      return wsSettings;
   }
}
