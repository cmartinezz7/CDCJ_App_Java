package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

public class WebServiceSettingsModel {
   public static final String TABLE_NAME = "web_service_settings";
   public static final String ID_COLUMN = "_id";
   public static final String WEB_SERVICE_ID_COLUMN = "web_service_id";
   public static final String ENVIRONMENT_COLUMN = "environment";
   public static final String URL_COLUMN = "url";
   public static final String URL_CERTIFICATE_COLUMN = "urlCertificate";
   public static final String CONNECTION_TIMEOUT_COLUMN = "connection_timeout";
   public static final String RECEIVE_TIMEOUT_COLUMN = "receive_timeout";

   public static String getCreateTableQuery() {
      String query = "CREATE TABLE web_service_settings (_id INTEGER PRIMARY KEY AUTOINCREMENT, web_service_id INTEGER, environment TEXT, url TEXT, urlCertificate TEXT, connection_timeout INTEGER DEFAULT -1, receive_timeout INTEGER DEFAULT -1)";
      return query;
   }

   public static String getDropTableQuery() {
      String query = "DROP TABLE IF EXISTS web_service_settings";
      return query;
   }

   public static boolean insertWebServiceSettings(ArrayList<WebServiceSettingsDTO> webServiceSettings) {
      MinJusticeDBHelper.getInstance();
      SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
      boolean response = insertWebServiceSettings(db, webServiceSettings);
      db.close();
      return response;
   }

   public static boolean insertWebServiceSettings(SQLiteDatabase db, ArrayList<WebServiceSettingsDTO> webServiceSettings) {
      boolean response = false;

      try {
         db.beginTransaction();
         Iterator var3 = webServiceSettings.iterator();

         while(var3.hasNext()) {
            WebServiceSettingsDTO settings = (WebServiceSettingsDTO)var3.next();
            ContentValues values = new ContentValues();
            values.put("web_service_id", settings.getWebServiceId());
            values.put("environment", settings.getEnvironment());
            values.put("url", settings.getUrl());
            values.put("urlCertificate", settings.getUrlCertificate());
            values.put("connection_timeout", settings.getConnectionTimeout());
            values.put("receive_timeout", settings.getReadTimeout());
            db.insert("web_service_settings", (String)null, values);
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
      db.delete("web_service_settings", (String)null, (String[])null);
      db.close();
   }

   public static void deleteAllData(SQLiteDatabase db) {
      db.delete("web_service_settings", (String)null, (String[])null);
   }
}
