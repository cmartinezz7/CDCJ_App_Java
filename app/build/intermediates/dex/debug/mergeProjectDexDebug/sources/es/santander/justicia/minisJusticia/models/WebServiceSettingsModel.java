package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.utils.MinJusticeDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

public class WebServiceSettingsModel {
    public static final String CONNECTION_TIMEOUT_COLUMN = "connection_timeout";
    public static final String ENVIRONMENT_COLUMN = "environment";
    public static final String ID_COLUMN = "_id";
    public static final String RECEIVE_TIMEOUT_COLUMN = "receive_timeout";
    public static final String TABLE_NAME = "web_service_settings";
    public static final String URL_CERTIFICATE_COLUMN = "urlCertificate";
    public static final String URL_COLUMN = "url";
    public static final String WEB_SERVICE_ID_COLUMN = "web_service_id";

    public static String getCreateTableQuery() {
        return "CREATE TABLE web_service_settings (_id INTEGER PRIMARY KEY AUTOINCREMENT, web_service_id INTEGER, environment TEXT, url TEXT, urlCertificate TEXT, connection_timeout INTEGER DEFAULT -1, receive_timeout INTEGER DEFAULT -1)";
    }

    public static String getDropTableQuery() {
        return "DROP TABLE IF EXISTS web_service_settings";
    }

    public static boolean insertWebServiceSettings(ArrayList<WebServiceSettingsDTO> webServiceSettings) {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        boolean response = insertWebServiceSettings(db, webServiceSettings);
        db.close();
        return response;
    }

    public static boolean insertWebServiceSettings(SQLiteDatabase db, ArrayList<WebServiceSettingsDTO> webServiceSettings) {
        try {
            db.beginTransaction();
            Iterator<WebServiceSettingsDTO> it = webServiceSettings.iterator();
            while (it.hasNext()) {
                WebServiceSettingsDTO settings = it.next();
                ContentValues values = new ContentValues();
                values.put(WEB_SERVICE_ID_COLUMN, Long.valueOf(settings.getWebServiceId()));
                values.put(ENVIRONMENT_COLUMN, settings.getEnvironment());
                values.put(URL_COLUMN, settings.getUrl());
                values.put(URL_CERTIFICATE_COLUMN, settings.getUrlCertificate());
                values.put(CONNECTION_TIMEOUT_COLUMN, Integer.valueOf(settings.getConnectionTimeout()));
                values.put(RECEIVE_TIMEOUT_COLUMN, Integer.valueOf(settings.getReadTimeout()));
                db.insert(TABLE_NAME, (String) null, values);
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
        db.close();
    }

    public static void deleteAllData(SQLiteDatabase db) {
        db.delete(TABLE_NAME, (String) null, (String[]) null);
    }
}
