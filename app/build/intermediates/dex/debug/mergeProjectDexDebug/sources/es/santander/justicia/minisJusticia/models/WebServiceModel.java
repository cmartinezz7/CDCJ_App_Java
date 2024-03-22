package es.santander.justicia.minisJusticia.models;

import android.content.ContentValues;
import android.database.Cursor;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.utils.MinJusticeDBHelper;
import net.sqlcipher.database.SQLiteDatabase;

public class WebServiceModel {
    public static final String ID_COLUMN = "_id";
    public static final String NAME_COLUMN = "name";
    public static final String TABLE_NAME = "web_service";

    public static String getCreateTableQuery() {
        return "CREATE TABLE web_service (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
    }

    public static String getDropTableQuery() {
        return "DROP TABLE IF EXISTS web_service";
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

    public static void deleteAllData() {
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getWritableDatabase();
        db.delete(TABLE_NAME, (String) null, (String[]) null);
        db.close();
    }

    public static void deleteAllData(SQLiteDatabase db) {
        db.delete(TABLE_NAME, (String) null, (String[]) null);
    }

    public static WebServiceSettingsDTO getWebServiceSettings(String webServiceName, String environment) {
        WebServiceSettingsDTO wsSettings = null;
        MinJusticeDBHelper.getInstance();
        SQLiteDatabase db = MinJusticeDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT wss.web_service_id, wss.url, wss.urlCertificate, wss.connection_timeout, wss.receive_timeout FROM web_service ws\nINNER JOIN web_service_settings wss ON wss.web_service_id = ws._id\nwhere ws.name = \"" + webServiceName + "\" AND wss." + WebServiceSettingsModel.ENVIRONMENT_COLUMN + " = \"" + environment + "\"", (String[]) null);
        if (cursor.moveToFirst()) {
            wsSettings = new WebServiceSettingsDTO();
            wsSettings.setWebServiceId((long) cursor.getInt(cursor.getColumnIndexOrThrow(WebServiceSettingsModel.WEB_SERVICE_ID_COLUMN)));
            wsSettings.setUrl(cursor.getString(cursor.getColumnIndexOrThrow(WebServiceSettingsModel.URL_COLUMN)));
            if (MainApplication.ENV_DEFAULT == MainApplication.ENV_PROD) {
                wsSettings.setUrlCertificate(cursor.getString(cursor.getColumnIndexOrThrow(WebServiceSettingsModel.URL_CERTIFICATE_COLUMN)));
            }
            wsSettings.setConnectionTimeout(cursor.getInt(cursor.getColumnIndexOrThrow(WebServiceSettingsModel.CONNECTION_TIMEOUT_COLUMN)));
            wsSettings.setReadTimeout(cursor.getInt(cursor.getColumnIndexOrThrow(WebServiceSettingsModel.RECEIVE_TIMEOUT_COLUMN)));
            wsSettings.setEnvironment(environment);
        }
        cursor.close();
        db.close();
        return wsSettings;
    }
}
