package net.sqlcipher.database;

import android.content.Context;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

public abstract class SQLiteOpenHelper {
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, (SQLiteDatabaseHook) null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabaseHook hook) {
        this(context, name, factory, version, hook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (version < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + version);
        } else if (errorHandler != null) {
            this.mContext = context;
            this.mName = name;
            this.mFactory = factory;
            this.mNewVersion = version;
            this.mHook = hook;
            this.mErrorHandler = errorHandler;
        } else {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(String password) {
        return getWritableDatabase(password == null ? null : password.toCharArray());
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00aa, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized net.sqlcipher.database.SQLiteDatabase getWritableDatabase(char[] r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            net.sqlcipher.database.SQLiteDatabase r0 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x0017
            net.sqlcipher.database.SQLiteDatabase r0 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            boolean r0 = r0.isReadOnly()     // Catch:{ all -> 0x00d6 }
            if (r0 != 0) goto L_0x0017
            net.sqlcipher.database.SQLiteDatabase r0 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            monitor-exit(r8)
            return r0
        L_0x0017:
            boolean r0 = r8.mIsInitializing     // Catch:{ all -> 0x00d6 }
            if (r0 != 0) goto L_0x00ce
            r0 = 0
            r1 = 0
            net.sqlcipher.database.SQLiteDatabase r2 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x0024
            r2.lock()     // Catch:{ all -> 0x00d6 }
        L_0x0024:
            r2 = 1
            r3 = 0
            r8.mIsInitializing = r2     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = r8.mName     // Catch:{ all -> 0x00ab }
            if (r2 != 0) goto L_0x0033
            r2 = 0
            net.sqlcipher.database.SQLiteDatabase r2 = net.sqlcipher.database.SQLiteDatabase.create((net.sqlcipher.database.SQLiteDatabase.CursorFactory) r2, (char[]) r9)     // Catch:{ all -> 0x00ab }
            r1 = r2
            goto L_0x005a
        L_0x0033:
            android.content.Context r4 = r8.mContext     // Catch:{ all -> 0x00ab }
            java.io.File r2 = r4.getDatabasePath(r2)     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = r2.getPath()     // Catch:{ all -> 0x00ab }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00ab }
            r4.<init>(r2)     // Catch:{ all -> 0x00ab }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x00ab }
            if (r5 != 0) goto L_0x004f
            java.io.File r5 = r4.getParentFile()     // Catch:{ all -> 0x00ab }
            r5.mkdirs()     // Catch:{ all -> 0x00ab }
        L_0x004f:
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r5 = r8.mFactory     // Catch:{ all -> 0x00ab }
            net.sqlcipher.database.SQLiteDatabaseHook r6 = r8.mHook     // Catch:{ all -> 0x00ab }
            net.sqlcipher.DatabaseErrorHandler r7 = r8.mErrorHandler     // Catch:{ all -> 0x00ab }
            net.sqlcipher.database.SQLiteDatabase r5 = net.sqlcipher.database.SQLiteDatabase.openOrCreateDatabase((java.lang.String) r2, (char[]) r9, (net.sqlcipher.database.SQLiteDatabase.CursorFactory) r5, (net.sqlcipher.database.SQLiteDatabaseHook) r6, (net.sqlcipher.DatabaseErrorHandler) r7)     // Catch:{ all -> 0x00ab }
            r1 = r5
        L_0x005a:
            int r2 = r1.getVersion()     // Catch:{ all -> 0x00ab }
            int r4 = r8.mNewVersion     // Catch:{ all -> 0x00ab }
            if (r2 == r4) goto L_0x0083
            r1.beginTransaction()     // Catch:{ all -> 0x0081 }
            if (r2 != 0) goto L_0x006b
            r8.onCreate(r1)     // Catch:{ all -> 0x007c }
            goto L_0x0070
        L_0x006b:
            int r4 = r8.mNewVersion     // Catch:{ all -> 0x007c }
            r8.onUpgrade(r1, r2, r4)     // Catch:{ all -> 0x007c }
        L_0x0070:
            int r4 = r8.mNewVersion     // Catch:{ all -> 0x007c }
            r1.setVersion(r4)     // Catch:{ all -> 0x007c }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x007c }
            r1.endTransaction()     // Catch:{ all -> 0x00ab }
            goto L_0x0083
        L_0x007c:
            r4 = move-exception
            r1.endTransaction()     // Catch:{ all -> 0x0081 }
            throw r4     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r2 = move-exception
            goto L_0x00ac
        L_0x0083:
            r8.onOpen(r1)     // Catch:{ all -> 0x00ab }
            r0 = 1
            r8.mIsInitializing = r3     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x009d
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r3 == 0) goto L_0x009a
            r3.close()     // Catch:{ Exception -> 0x0094 }
            goto L_0x0095
        L_0x0094:
            r3 = move-exception
        L_0x0095:
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            r3.unlock()     // Catch:{ all -> 0x00d6 }
        L_0x009a:
            r8.mDatabase = r1     // Catch:{ all -> 0x00d6 }
            goto L_0x00a9
        L_0x009d:
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r3 == 0) goto L_0x00a4
            r3.unlock()     // Catch:{ all -> 0x00d6 }
        L_0x00a4:
            if (r1 == 0) goto L_0x00a9
            r1.close()     // Catch:{ all -> 0x00d6 }
        L_0x00a9:
            monitor-exit(r8)
            return r1
        L_0x00ab:
            r2 = move-exception
        L_0x00ac:
            r8.mIsInitializing = r3     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00c1
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r3 == 0) goto L_0x00be
            r3.close()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b9
        L_0x00b8:
            r3 = move-exception
        L_0x00b9:
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            r3.unlock()     // Catch:{ all -> 0x00d6 }
        L_0x00be:
            r8.mDatabase = r1     // Catch:{ all -> 0x00d6 }
            goto L_0x00cd
        L_0x00c1:
            net.sqlcipher.database.SQLiteDatabase r3 = r8.mDatabase     // Catch:{ all -> 0x00d6 }
            if (r3 == 0) goto L_0x00c8
            r3.unlock()     // Catch:{ all -> 0x00d6 }
        L_0x00c8:
            if (r1 == 0) goto L_0x00cd
            r1.close()     // Catch:{ all -> 0x00d6 }
        L_0x00cd:
            throw r2     // Catch:{ all -> 0x00d6 }
        L_0x00ce:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = "getWritableDatabase called recursively"
            r0.<init>(r1)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteOpenHelper.getWritableDatabase(char[]):net.sqlcipher.database.SQLiteDatabase");
    }

    public synchronized SQLiteDatabase getReadableDatabase(String password) {
        return getReadableDatabase(password == null ? null : password.toCharArray());
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    public synchronized SQLiteDatabase getReadableDatabase(char[] password) {
        SQLiteDatabase db;
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            try {
                return getWritableDatabase(password);
            } catch (SQLiteException e) {
                if (this.mName != null) {
                    String str = TAG;
                    Log.e(str, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                    db = null;
                    this.mIsInitializing = true;
                    String path = this.mContext.getDatabasePath(this.mName).getPath();
                    File databasePath = new File(path);
                    File databasesDirectory = new File(this.mContext.getDatabasePath(this.mName).getParent());
                    if (!databasesDirectory.exists()) {
                        databasesDirectory.mkdirs();
                    }
                    if (!databasePath.exists()) {
                        this.mIsInitializing = false;
                        db = getWritableDatabase(password);
                        this.mIsInitializing = true;
                        db.close();
                    }
                    db = SQLiteDatabase.openDatabase(path, password, this.mFactory, 1);
                    if (db.getVersion() == this.mNewVersion) {
                        onOpen(db);
                        Log.w(str, "Opened " + this.mName + " in read-only mode");
                        this.mDatabase = db;
                        this.mIsInitializing = false;
                        if (!(db == null || db == db)) {
                            db.close();
                        }
                        return db;
                    }
                    throw new SQLiteException("Can't upgrade read-only database from version " + db.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                throw e;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
        this.mIsInitializing = false;
        if (!(db == null || db == this.mDatabase)) {
            db.close();
        }
        throw th;
    }

    public synchronized void close() {
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else {
            throw new IllegalStateException("Closed during initialization");
        }
    }

    public void onOpen(SQLiteDatabase db) {
    }
}
