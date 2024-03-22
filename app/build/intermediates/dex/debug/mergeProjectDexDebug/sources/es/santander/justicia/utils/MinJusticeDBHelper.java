package es.santander.justicia.utils;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.minisJusticia.models.WebServiceSettingsModel;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class MinJusticeDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "santander_justicia_crypt.db";
    public static final int DATABASE_VERSION = 8;
    private static MinJusticeDBHelper adminBB;

    public MinJusticeDBHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 8);
        try {
            MinJusticeDBHelper minJusticeDBHelper = adminBB;
            if (minJusticeDBHelper != null) {
                minJusticeDBHelper.close();
            }
        } catch (Exception e) {
            Log.i("MinJusticeDBHelper", "Error al cerrar la BBDD");
        }
        adminBB = this;
    }

    public static synchronized MinJusticeDBHelper getInstance() {
        MinJusticeDBHelper minJusticeDBHelper;
        synchronized (MinJusticeDBHelper.class) {
            if (adminBB == null) {
                adminBB = new MinJusticeDBHelper(MainApplication.getAppContext());
            }
            minJusticeDBHelper = adminBB;
        }
        return minJusticeDBHelper;
    }

    public static SQLiteDatabase getWritableDatabase() {
        Log.i("getWritableDatabase", "getWritableDatabase");
        return getInstance().getWritableDatabase("AshgfuE132278LsWPZW");
    }

    public static SQLiteDatabase getReadableDatabase() {
        Log.i("getReadableDatabase", "getReadableDatabase");
        return getInstance().getReadableDatabase("AshgfuE132278LsWPZW");
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SpinnerContentModel.getCreateTableQuery());
        db.execSQL(SpinnerContentModel.getCreateTableValuesQuery());
        db.execSQL(WebServiceModel.getCreateTableQuery());
        db.execSQL(WebServiceSettingsModel.getCreateTableQuery());
        db.execSQL(KeyValueModel.getInstance().getCreateTableQuery());
        db.execSQL(KeyValueModel.getInstancePermanent().getCreateTableQuery());
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SpinnerContentModel.getDropTableQuery());
        db.execSQL(SpinnerContentModel.getCreateTableQuery());
        db.execSQL(SpinnerContentModel.getDropTableValuesQuery());
        db.execSQL(SpinnerContentModel.getCreateTableValuesQuery());
        db.execSQL(WebServiceModel.getDropTableQuery());
        db.execSQL(WebServiceModel.getCreateTableQuery());
        db.execSQL(WebServiceSettingsModel.getDropTableQuery());
        db.execSQL(WebServiceSettingsModel.getCreateTableQuery());
        db.execSQL(KeyValueModel.getInstance().getDropTableQuery());
        db.execSQL(KeyValueModel.getInstance().getCreateTableQuery());
        db.execSQL(KeyValueModel.getInstancePermanent().getDropTableQuery());
        db.execSQL(KeyValueModel.getInstancePermanent().getCreateTableQuery());
    }

    public static void deleteAllData() {
        SQLiteDatabase db = getWritableDatabase();
        SpinnerContentModel.deleteAllData(db);
        WebServiceModel.deleteAllData(db);
        WebServiceSettingsModel.deleteAllData(db);
        KeyValueModel.getInstance().deleteAllData(db);
        db.close();
    }
}
