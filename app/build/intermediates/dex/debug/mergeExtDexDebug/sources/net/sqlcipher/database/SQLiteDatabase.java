package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug;
import org.ksoap2.SoapEnvelope;

public class SQLiteDatabase extends SQLiteClosable {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "3.5.9";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static int sQueryLogTimeInMillis = 0;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    /* access modifiers changed from: private */
    public native void key(byte[] bArr) throws SQLException;

    /* access modifiers changed from: private */
    public native void key_mutf8(char[] cArr) throws SQLException;

    private native int native_getDbLookaside();

    private native void native_key(char[] cArr) throws SQLException;

    private native void native_rawExecSQL(String str);

    private native void native_rekey(String str) throws SQLException;

    private native int native_status(int i, boolean z);

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    /* access modifiers changed from: package-private */
    public native int lastChangeCount();

    /* access modifiers changed from: package-private */
    public native long lastInsertRow();

    /* access modifiers changed from: package-private */
    public native void native_execSQL(String str) throws SQLException;

    /* access modifiers changed from: package-private */
    public native void native_setLocale(String str, int i);

    public int status(int operation, boolean reset) {
        return native_status(operation, reset);
    }

    public void changePassword(String password) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (password != null) {
            byte[] keyMaterial = getBytes(password.toCharArray());
            rekey(keyMaterial);
            for (byte b : keyMaterial) {
            }
        }
    }

    public void changePassword(char[] password) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (password != null) {
            byte[] keyMaterial = getBytes(password);
            rekey(keyMaterial);
            for (byte b : keyMaterial) {
            }
        }
    }

    private static void loadICUData(Context context, File workingDir) {
        OutputStream out = null;
        ZipInputStream in = null;
        File icuDir = new File(workingDir, "icu");
        File icuDataFile = new File(icuDir, "icudt46l.dat");
        try {
            if (!icuDir.exists()) {
                icuDir.mkdirs();
            }
            if (!icuDataFile.exists()) {
                in = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                in.getNextEntry();
                out = new FileOutputStream(icuDataFile);
                byte[] buf = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
                while (true) {
                    int read = in.read(buf);
                    int len = read;
                    if (read <= 0) {
                        break;
                    }
                    out.write(buf, 0, len);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", ioe);
                    throw new RuntimeException(ioe);
                }
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        } catch (Exception ex) {
            Log.e(TAG, "Error copying icu dat file", ex);
            if (icuDataFile.exists()) {
                icuDataFile.delete();
            }
            throw new RuntimeException(ex);
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe2) {
                    Log.e(TAG, "Error in closing streams IO streams after expanding ICU dat file", ioe2);
                    throw new RuntimeException(ioe2);
                }
            }
            if (out != null) {
                out.flush();
                out.close();
            }
            throw th;
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File workingDir) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, workingDir, new LibraryLoader() {
                public void loadLibraries(String... libNames) {
                    for (String libName : libNames) {
                        System.loadLibrary(libName);
                    }
                }
            });
        }
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static synchronized void loadLibs(Context context, File workingDir, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    /* access modifiers changed from: package-private */
    public void addSQLiteClosable(SQLiteClosable closable) {
        lock();
        try {
            this.mPrograms.put(closable, (Object) null);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeSQLiteClosable(SQLiteClosable closable) {
        lock();
        try {
            this.mPrograms.remove(closable);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean lockingEnabled) {
        this.mLockingEnabled = lockingEnabled;
    }

    /* access modifiers changed from: package-private */
    public void onCorruption() {
        Log.e(TAG, "Calling error handler for corrupt database (detected) " + this.mPath);
        this.mErrorHandler.onCorruption(this);
    }

    /* access modifiers changed from: package-private */
    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    /* access modifiers changed from: package-private */
    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private void checkLockHoldTime() {
        long elapsedTime = SystemClock.elapsedRealtime();
        long lockedTime = elapsedTime - this.mLockAcquiredWallTime;
        if ((lockedTime >= 2000 || Log.isLoggable(TAG, 2) || elapsedTime - this.mLastLockMessageTime >= 20000) && lockedTime > 300) {
            int threadTime = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadTime > 100 || lockedTime > 2000) {
                this.mLastLockMessageTime = elapsedTime;
                String msg = "lock held on " + this.mPath + " for " + lockedTime + "ms. Thread time was " + threadTime + "ms";
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, msg, new Exception());
                } else {
                    Log.d(TAG, msg);
                }
            }
        }
    }

    public void beginTransaction() {
        beginTransactionWithListener((SQLiteTransactionListener) null);
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    execSQL("BEGIN EXCLUSIVE;");
                    this.mTransactionListener = transactionListener;
                    this.mTransactionIsSuccessful = true;
                    this.mInnerTransactionIsSuccessful = false;
                    if (transactionListener != null) {
                        transactionListener.onBegin();
                    }
                    if (1 == 0) {
                        unlockForced();
                    }
                } else if (this.mInnerTransactionIsSuccessful) {
                    IllegalStateException e = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    Log.e(TAG, "beginTransaction() failed", e);
                    throw e;
                } else if (1 == 0) {
                    unlockForced();
                }
            } catch (RuntimeException e2) {
                execSQL("ROLLBACK;");
                throw e2;
            } catch (Throwable th) {
                if (0 == 0) {
                    unlockForced();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public void endTransaction() {
        RuntimeException savedException;
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (this.mLock.isHeldByCurrentThread()) {
            try {
                if (this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = false;
                } else {
                    this.mTransactionIsSuccessful = false;
                }
                if (this.mLock.getHoldCount() != 1) {
                    this.mTransactionListener = null;
                    unlockForced();
                    return;
                }
                savedException = null;
                SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
                if (sQLiteTransactionListener != null) {
                    if (this.mTransactionIsSuccessful) {
                        sQLiteTransactionListener.onCommit();
                    } else {
                        sQLiteTransactionListener.onRollback();
                    }
                }
                if (this.mTransactionIsSuccessful) {
                    execSQL(COMMIT_SQL);
                } else {
                    try {
                        execSQL("ROLLBACK;");
                        if (savedException != null) {
                            throw savedException;
                        }
                    } catch (SQLException e) {
                        Log.d(TAG, "exception during rollback, maybe the DB previously performed an auto-rollback");
                    }
                }
                this.mTransactionListener = null;
                unlockForced();
            } catch (RuntimeException e2) {
                savedException = e2;
                this.mTransactionIsSuccessful = false;
            } catch (Throwable th) {
                this.mTransactionListener = null;
                unlockForced();
                throw th;
            }
        } else {
            throw new IllegalStateException("no transaction pending");
        }
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        } else if (!this.mInnerTransactionIsSuccessful) {
            this.mInnerTransactionIsSuccessful = true;
        } else {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, -1);
    }

    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, sleepAfterYieldDelay);
    }

    private boolean yieldIfContendedHelper(boolean checkFullyYielded, long sleepAfterYieldDelay) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener transactionListener = this.mTransactionListener;
        endTransaction();
        if (!checkFullyYielded || !isDbLockedByCurrentThread()) {
            if (sleepAfterYieldDelay > 0) {
                long remainingDelay = sleepAfterYieldDelay;
                while (remainingDelay > 0) {
                    try {
                        Thread.sleep(remainingDelay < 1000 ? remainingDelay : 1000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                    remainingDelay -= 1000;
                    if (this.mLock.getQueueLength() == 0) {
                        break;
                    }
                }
            }
            beginTransactionWithListener(transactionListener);
            return true;
        }
        throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
    }

    public Map<String, String> getSyncedTables() {
        HashMap<String, String> tables;
        synchronized (this.mSyncUpdateInfo) {
            tables = new HashMap<>();
            for (String table : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo info = this.mSyncUpdateInfo.get(table);
                if (info.deletedTable != null) {
                    tables.put(table, info.deletedTable);
                }
            }
        }
        return tables;
    }

    private static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String masterTable2, String deletedTable2, String foreignKey2) {
            this.masterTable = masterTable2;
            this.deletedTable = deletedTable2;
            this.foreignKey = foreignKey2;
        }
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags) {
        return openDatabase(path, password, factory, flags, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags) {
        return openDatabase(path, password, factory, flags, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags, SQLiteDatabaseHook hook) {
        return openDatabase(path, password, factory, flags, hook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook hook) {
        return openDatabase(path, password, factory, flags, hook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String path, String password, CursorFactory factory, int flags, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password == null ? null : password.toCharArray(), factory, flags, hook, errorHandler);
    }

    public static SQLiteDatabase openDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook hook, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase sqliteDatabase = null;
        DatabaseErrorHandler myErrorHandler = errorHandler != null ? errorHandler : new DefaultDatabaseErrorHandler();
        try {
            sqliteDatabase = new SQLiteDatabase(path, factory, flags, myErrorHandler);
            sqliteDatabase.openDatabaseInternal(password, hook);
        } catch (SQLiteDatabaseCorruptException e) {
            Log.e(TAG, "Calling error handler for corrupt database " + path, e);
            myErrorHandler.onCorruption(sqliteDatabase);
            sqliteDatabase = new SQLiteDatabase(path, factory, flags, myErrorHandler);
            sqliteDatabase.openDatabaseInternal(password, hook);
        }
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            sqliteDatabase.enableSqlTracing(path);
        }
        if (SQLiteDebug.DEBUG_SQL_TIME) {
            sqliteDatabase.enableSqlProfiling(path);
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(sqliteDatabase, (Object) null);
        }
        return sqliteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openOrCreateDatabase(file, password, factory, databaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openDatabase(path, password, factory, (int) CREATE_IF_NECESSARY, databaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), password, factory, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password == null ? null : password.toCharArray(), factory, (int) CREATE_IF_NECESSARY, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook) {
        return openDatabase(path, password, factory, (int) CREATE_IF_NECESSARY, databaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory, SQLiteDatabaseHook databaseHook, DatabaseErrorHandler errorHandler) {
        return openDatabase(path, password, factory, (int) CREATE_IF_NECESSARY, databaseHook, errorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String password, CursorFactory factory) {
        return openOrCreateDatabase(file, password, factory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, String password, CursorFactory factory) {
        return openDatabase(path, password, factory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String path, char[] password, CursorFactory factory) {
        return openDatabase(path, password, factory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase create(CursorFactory factory, String password) {
        return openDatabase(MEMORY, password == null ? null : password.toCharArray(), factory, (int) CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase create(CursorFactory factory, char[] password) {
        return openDatabase(MEMORY, password, factory, (int) CREATE_IF_NECESSARY);
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Map.Entry<SQLiteClosable, Object> entry : this.mPrograms.entrySet()) {
            SQLiteClosable program = entry.getKey();
            if (program != null) {
                program.onAllReferencesReleasedFromContainer();
            }
        }
    }

    public int getVersion() {
        SQLiteStatement prog = null;
        lock();
        if (isOpen()) {
            try {
                SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA user_version;");
                int simpleQueryForLong = (int) prog2.simpleQueryForLong();
                prog2.close();
                unlock();
                return simpleQueryForLong;
            } catch (Throwable th) {
                if (prog != null) {
                    prog.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void setVersion(int version) {
        execSQL("PRAGMA user_version = " + version);
    }

    public long getMaximumSize() {
        SQLiteStatement prog = null;
        lock();
        if (isOpen()) {
            try {
                SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA max_page_count;");
                long pageSize = getPageSize() * prog2.simpleQueryForLong();
                prog2.close();
                unlock();
                return pageSize;
            } catch (Throwable th) {
                if (prog != null) {
                    prog.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public long setMaximumSize(long numBytes) {
        SQLiteStatement prog = null;
        lock();
        if (isOpen()) {
            try {
                long pageSize = getPageSize();
                long numPages = numBytes / pageSize;
                if (numBytes % pageSize != 0) {
                    numPages++;
                }
                SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA max_page_count = " + numPages);
                long simpleQueryForLong = prog2.simpleQueryForLong() * pageSize;
                prog2.close();
                unlock();
                return simpleQueryForLong;
            } catch (Throwable th) {
                if (prog != null) {
                    prog.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public long getPageSize() {
        SQLiteStatement prog = null;
        lock();
        if (isOpen()) {
            try {
                SQLiteStatement prog2 = new SQLiteStatement(this, "PRAGMA page_size;");
                long size = prog2.simpleQueryForLong();
                prog2.close();
                unlock();
                return size;
            } catch (Throwable th) {
                if (prog != null) {
                    prog.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void setPageSize(long numBytes) {
        execSQL("PRAGMA page_size = " + numBytes);
    }

    public void markTableSyncable(String table, String deletedTable) {
        if (isOpen()) {
            markTableSyncable(table, "_id", table, deletedTable);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void markTableSyncable(String table, String foreignKey, String updateTable) {
        if (isOpen()) {
            markTableSyncable(table, foreignKey, updateTable, (String) null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    /* JADX INFO: finally extract failed */
    private void markTableSyncable(String table, String foreignKey, String updateTable, String deletedTable) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + updateTable + " LIMIT 0");
            native_execSQL("SELECT " + foreignKey + " FROM " + table + " LIMIT 0");
            unlock();
            SyncUpdateInfo info = new SyncUpdateInfo(updateTable, deletedTable, foreignKey);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(table, info);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        execSQL("UPDATE " + r1.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + r1.foreignKey + " FROM " + r4 + " WHERE _id=" + r5 + ")");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rowUpdated(java.lang.String r4, long r5) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteDatabase$SyncUpdateInfo> r0 = r3.mSyncUpdateInfo
            monitor-enter(r0)
            r1 = 0
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteDatabase$SyncUpdateInfo> r2 = r3.mSyncUpdateInfo     // Catch:{ all -> 0x004f }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x004f }
            net.sqlcipher.database.SQLiteDatabase$SyncUpdateInfo r2 = (net.sqlcipher.database.SQLiteDatabase.SyncUpdateInfo) r2     // Catch:{ all -> 0x004f }
            r1 = r2
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x004e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "UPDATE "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r1.masterTable
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = " SET _sync_dirty=1 WHERE _id=(SELECT "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = r1.foreignKey
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = " FROM "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r2 = " WHERE _id="
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.execSQL(r0)
        L_0x004e:
            return
        L_0x004f:
            r2 = move-exception
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r2
        L_0x0052:
            r2 = move-exception
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rowUpdated(java.lang.String, long):void");
    }

    public static String findEditTable(String tables) {
        if (!TextUtils.isEmpty(tables)) {
            int spacepos = tables.indexOf(32);
            int commapos = tables.indexOf(44);
            if (spacepos > 0 && (spacepos < commapos || commapos < 0)) {
                return tables.substring(0, spacepos);
            }
            if (commapos <= 0 || (commapos >= spacepos && spacepos >= 0)) {
                return tables;
            }
            return tables.substring(0, commapos);
        }
        throw new IllegalStateException("Invalid tables");
    }

    public SQLiteStatement compileStatement(String sql) throws SQLException {
        lock();
        if (isOpen()) {
            try {
                return new SQLiteStatement(this, sql);
            } finally {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public Cursor query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return queryWithFactory((CursorFactory) null, distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        if (isOpen()) {
            CursorFactory cursorFactory2 = cursorFactory;
            String[] strArr = selectionArgs;
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(distinct, table, columns, selection, groupBy, having, orderBy, limit), selectionArgs, findEditTable(table));
        }
        CursorFactory cursorFactory3 = cursorFactory;
        String[] strArr2 = selectionArgs;
        throw new IllegalStateException("database not open");
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return query(false, table, columns, selection, selectionArgs, groupBy, having, orderBy, (String) null);
    }

    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return query(false, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return rawQueryWithFactory((CursorFactory) null, sql, selectionArgs, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.sqlcipher.Cursor rawQuery(java.lang.String r18, java.lang.Object[] r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = ", args are <redacted>, count is "
            java.lang.String r3 = " ms): "
            java.lang.String r4 = "query ("
            java.lang.String r5 = "Database"
            boolean r0 = r17.isOpen()
            if (r0 == 0) goto L_0x00ba
            r6 = 0
            int r0 = r1.mSlowQueryThreshold
            r8 = -1
            if (r0 == r8) goto L_0x001b
            long r6 = java.lang.System.currentTimeMillis()
        L_0x001b:
            net.sqlcipher.database.SQLiteDirectCursorDriver r0 = new net.sqlcipher.database.SQLiteDirectCursorDriver
            r9 = 0
            r10 = r18
            r0.<init>(r1, r10, r9)
            r9 = r0
            r11 = 0
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r0 = r1.mFactory     // Catch:{ all -> 0x0074 }
            r12 = r19
            net.sqlcipher.Cursor r0 = r9.query((net.sqlcipher.database.SQLiteDatabase.CursorFactory) r0, (java.lang.Object[]) r12)     // Catch:{ all -> 0x0072 }
            int r11 = r1.mSlowQueryThreshold
            if (r11 == r8) goto L_0x006c
            r8 = -1
            if (r0 == 0) goto L_0x0038
            int r8 = r0.getCount()
        L_0x0038:
            long r13 = java.lang.System.currentTimeMillis()
            long r13 = r13 - r6
            int r11 = r1.mSlowQueryThreshold
            long r10 = (long) r11
            int r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x006c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r4 = r10.append(r4)
            java.lang.StringBuilder r4 = r4.append(r13)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = r9.toString()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x006c:
            net.sqlcipher.CrossProcessCursorWrapper r2 = new net.sqlcipher.CrossProcessCursorWrapper
            r2.<init>(r0)
            return r2
        L_0x0072:
            r0 = move-exception
            goto L_0x0077
        L_0x0074:
            r0 = move-exception
            r12 = r19
        L_0x0077:
            int r10 = r1.mSlowQueryThreshold
            if (r10 == r8) goto L_0x00b8
            r8 = -1
            if (r11 == 0) goto L_0x0082
            int r8 = r11.getCount()
        L_0x0082:
            long r13 = java.lang.System.currentTimeMillis()
            long r13 = r13 - r6
            int r10 = r1.mSlowQueryThreshold
            r15 = r6
            long r6 = (long) r10
            int r6 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x00b9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.StringBuilder r4 = r4.append(r13)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = r9.toString()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
            goto L_0x00b9
        L_0x00b8:
            r15 = r6
        L_0x00b9:
            throw r0
        L_0x00ba:
            r12 = r19
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "database not open"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rawQuery(java.lang.String, java.lang.Object[]):net.sqlcipher.Cursor");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.sqlcipher.Cursor rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase.CursorFactory r17, java.lang.String r18, java.lang.String[] r19, java.lang.String r20) {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r16.isOpen()
            if (r0 == 0) goto L_0x00bd
            r2 = 0
            int r0 = r1.mSlowQueryThreshold
            r4 = -1
            if (r0 == r4) goto L_0x0013
            long r2 = java.lang.System.currentTimeMillis()
        L_0x0013:
            net.sqlcipher.database.SQLiteDirectCursorDriver r0 = new net.sqlcipher.database.SQLiteDirectCursorDriver
            r5 = r18
            r6 = r20
            r0.<init>(r1, r5, r6)
            r7 = r0
            r8 = 0
            java.lang.String r9 = ", args are <redacted>, count is "
            java.lang.String r10 = " ms): "
            java.lang.String r11 = "query ("
            java.lang.String r12 = "Database"
            if (r17 == 0) goto L_0x002b
            r0 = r17
            goto L_0x002d
        L_0x002b:
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r0 = r1.mFactory     // Catch:{ all -> 0x007a }
        L_0x002d:
            r13 = r19
            net.sqlcipher.Cursor r0 = r7.query(r0, r13)     // Catch:{ all -> 0x0078 }
            int r8 = r1.mSlowQueryThreshold
            if (r8 == r4) goto L_0x0072
            r4 = -1
            if (r0 == 0) goto L_0x003e
            int r4 = r0.getCount()
        L_0x003e:
            long r14 = java.lang.System.currentTimeMillis()
            long r14 = r14 - r2
            int r8 = r1.mSlowQueryThreshold
            long r5 = (long) r8
            int r5 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0072
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.StringBuilder r5 = r5.append(r14)
            java.lang.StringBuilder r5 = r5.append(r10)
            java.lang.String r6 = r7.toString()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.StringBuilder r5 = r5.append(r4)
            java.lang.String r5 = r5.toString()
            android.util.Log.v(r12, r5)
        L_0x0072:
            net.sqlcipher.CrossProcessCursorWrapper r4 = new net.sqlcipher.CrossProcessCursorWrapper
            r4.<init>(r0)
            return r4
        L_0x0078:
            r0 = move-exception
            goto L_0x007d
        L_0x007a:
            r0 = move-exception
            r13 = r19
        L_0x007d:
            int r5 = r1.mSlowQueryThreshold
            if (r5 == r4) goto L_0x00bc
            r4 = -1
            if (r8 == 0) goto L_0x0088
            int r4 = r8.getCount()
        L_0x0088:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r2
            int r14 = r1.mSlowQueryThreshold
            long r14 = (long) r14
            int r14 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r14 < 0) goto L_0x00bc
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.StringBuilder r11 = r14.append(r11)
            java.lang.StringBuilder r11 = r11.append(r5)
            java.lang.StringBuilder r10 = r11.append(r10)
            java.lang.String r11 = r7.toString()
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r9 = r10.append(r9)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r9 = r9.toString()
            android.util.Log.v(r12, r9)
        L_0x00bc:
            throw r0
        L_0x00bd:
            r13 = r19
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "database not open"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String, java.lang.String[], java.lang.String):net.sqlcipher.Cursor");
    }

    public Cursor rawQuery(String sql, String[] selectionArgs, int initialRead, int maxRead) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory((CursorFactory) null, sql, selectionArgs, (String) null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(initialRead, maxRead);
        return cursorWrapper;
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        try {
            return insertWithOnConflict(table, nullColumnHack, values, 0);
        } catch (SQLException e) {
            Log.e(TAG, "Error inserting <redacted values> into " + table, e);
            return -1;
        }
    }

    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLException {
        return insertWithOnConflict(table, nullColumnHack, values, 0);
    }

    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        try {
            return insertWithOnConflict(table, nullColumnHack, initialValues, 5);
        } catch (SQLException e) {
            Log.e(TAG, "Error inserting <redacted values> into " + table, e);
            return -1;
        }
    }

    public long replaceOrThrow(String table, String nullColumnHack, ContentValues initialValues) throws SQLException {
        return insertWithOnConflict(table, nullColumnHack, initialValues, 5);
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) {
        if (isOpen()) {
            StringBuilder sql = new StringBuilder(152);
            sql.append("INSERT");
            sql.append(CONFLICT_VALUES[conflictAlgorithm]);
            sql.append(" INTO ");
            sql.append(table);
            StringBuilder values = new StringBuilder(40);
            Set<Map.Entry<String, Object>> entrySet = null;
            if (initialValues == null || initialValues.size() <= 0) {
                sql.append("(" + nullColumnHack + ") ");
                values.append("NULL");
            } else {
                entrySet = initialValues.valueSet();
                sql.append('(');
                boolean needSeparator = false;
                for (Map.Entry<String, Object> entry : entrySet) {
                    if (needSeparator) {
                        sql.append(", ");
                        values.append(", ");
                    }
                    needSeparator = true;
                    sql.append(entry.getKey());
                    values.append('?');
                }
                sql.append(')');
            }
            sql.append(" VALUES(");
            sql.append(values);
            sql.append(");");
            lock();
            SQLiteStatement statement = null;
            try {
                statement = compileStatement(sql.toString());
                if (entrySet != null) {
                    int size = entrySet.size();
                    Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
                    for (int i = 0; i < size; i++) {
                        DatabaseUtils.bindObjectToProgram(statement, i + 1, entriesIter.next().getValue());
                    }
                }
                statement.execute();
                long insertedRowId = lastChangeCount() > 0 ? lastInsertRow() : -1;
                if (insertedRowId == -1) {
                    Log.e(TAG, "Error inserting <redacted values> using <redacted sql> into " + table);
                } else if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Inserting row " + insertedRowId + " from <redacted values> using <redacted sql> into " + table);
                }
                if (statement != null) {
                    statement.close();
                }
                unlock();
                return insertedRowId;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (statement != null) {
                    statement.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public int delete(String table, String whereClause, String[] whereArgs) {
        lock();
        if (isOpen()) {
            SQLiteStatement statement = null;
            try {
                SQLiteStatement statement2 = compileStatement("DELETE FROM " + table + (!TextUtils.isEmpty(whereClause) ? " WHERE " + whereClause : ""));
                if (whereArgs != null) {
                    int numArgs = whereArgs.length;
                    for (int i = 0; i < numArgs; i++) {
                        DatabaseUtils.bindObjectToProgram(statement2, i + 1, whereArgs[i]);
                    }
                }
                statement2.execute();
                int lastChangeCount = lastChangeCount();
                if (statement2 != null) {
                    statement2.close();
                }
                unlock();
                return lastChangeCount;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (statement != null) {
                    statement.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        return updateWithOnConflict(table, values, whereClause, whereArgs, 0);
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    public int updateWithOnConflict(String table, ContentValues values, String whereClause, String[] whereArgs, int conflictAlgorithm) {
        if (values == null || values.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sql = new StringBuilder(SoapEnvelope.VER12);
        sql.append("UPDATE ");
        sql.append(CONFLICT_VALUES[conflictAlgorithm]);
        sql.append(table);
        sql.append(" SET ");
        Set<Map.Entry<String, Object>> entrySet = values.valueSet();
        Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
        while (entriesIter.hasNext()) {
            sql.append(entriesIter.next().getKey());
            sql.append("=?");
            if (entriesIter.hasNext()) {
                sql.append(", ");
            }
        }
        if (!TextUtils.isEmpty(whereClause)) {
            sql.append(" WHERE ");
            sql.append(whereClause);
        }
        lock();
        if (isOpen()) {
            SQLiteStatement statement = null;
            try {
                SQLiteStatement statement2 = compileStatement(sql.toString());
                int size = entrySet.size();
                Iterator<Map.Entry<String, Object>> entriesIter2 = entrySet.iterator();
                int bindArg = 1;
                for (int i = 0; i < size; i++) {
                    DatabaseUtils.bindObjectToProgram(statement2, bindArg, entriesIter2.next().getValue());
                    bindArg++;
                }
                if (whereArgs != null) {
                    for (String bindString : whereArgs) {
                        statement2.bindString(bindArg, bindString);
                        bindArg++;
                    }
                }
                statement2.execute();
                int numChangedRows = lastChangeCount();
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Updated " + numChangedRows + " rows using <redacted values> and <redacted sql> for " + table);
                }
                if (statement2 != null) {
                    statement2.close();
                }
                unlock();
                return numChangedRows;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLException e2) {
                Log.e(TAG, "Error updating <redacted values> using <redacted sql> for " + table);
                throw e2;
            } catch (Throwable th) {
                if (statement != null) {
                    statement.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void execSQL(String sql) throws SQLException {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            try {
                native_execSQL(sql);
                unlock();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void rawExecSQL(String sql) {
        long uptimeMillis = SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            try {
                native_rawExecSQL(sql);
                unlock();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 7 */
    public void execSQL(String sql, Object[] bindArgs) throws SQLException {
        if (bindArgs != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            lock();
            if (isOpen()) {
                SQLiteStatement statement = null;
                try {
                    SQLiteStatement statement2 = compileStatement(sql);
                    if (bindArgs != null) {
                        int numArgs = bindArgs.length;
                        for (int i = 0; i < numArgs; i++) {
                            DatabaseUtils.bindObjectToProgram(statement2, i + 1, bindArgs[i]);
                        }
                    }
                    statement2.execute();
                    if (statement2 != null) {
                        statement2.close();
                    }
                    unlock();
                } catch (SQLiteDatabaseCorruptException e) {
                    onCorruption();
                    throw e;
                } catch (Throwable th) {
                    if (statement != null) {
                        statement.close();
                    }
                    unlock();
                    throw th;
                }
            } else {
                throw new IllegalStateException("database not open");
            }
        } else {
            throw new IllegalArgumentException("Empty bindArgs");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (isOpen()) {
            Log.e(TAG, "close() was never explicitly called on database '" + this.mPath + "' ", this.mStackTrace);
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public SQLiteDatabase(String path, char[] password, CursorFactory factory, int flags) {
        this(path, factory, flags, (DatabaseErrorHandler) null);
        openDatabaseInternal(password, (SQLiteDatabaseHook) null);
    }

    public SQLiteDatabase(String path, char[] password, CursorFactory factory, int flags, SQLiteDatabaseHook databaseHook) {
        this(path, factory, flags, (DatabaseErrorHandler) null);
        openDatabaseInternal(password, databaseHook);
    }

    private SQLiteDatabase(String path, CursorFactory factory, int flags, DatabaseErrorHandler errorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = MAX_SQL_CACHE_SIZE;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (path != null) {
            this.mFlags = flags;
            this.mPath = path;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = factory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = errorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void openDatabaseInternal(char[] r7, net.sqlcipher.database.SQLiteDatabaseHook r8) {
        /*
            r6 = this;
            r0 = 1
            byte[] r1 = r6.getBytes(r7)
            java.lang.String r2 = r6.mPath
            int r3 = r6.mFlags
            r6.dbopen(r2, r3)
            r2 = 0
            net.sqlcipher.database.SQLiteDatabase$2 r3 = new net.sqlcipher.database.SQLiteDatabase$2     // Catch:{ RuntimeException -> 0x0035 }
            r3.<init>(r1)     // Catch:{ RuntimeException -> 0x0035 }
            r6.keyDatabase(r8, r3)     // Catch:{ RuntimeException -> 0x0035 }
            r0 = 0
            if (r0 == 0) goto L_0x0025
            r6.dbclose()
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r3 == 0) goto L_0x0025
            java.lang.String r3 = r6.getTime()
            r6.mTimeClosed = r3
        L_0x0025:
            if (r1 == 0) goto L_0x006a
            int r3 = r1.length
            if (r3 <= 0) goto L_0x006a
            int r3 = r1.length
        L_0x002b:
            if (r2 >= r3) goto L_0x006a
            byte r4 = r1[r2]
            int r2 = r2 + 1
            goto L_0x002b
        L_0x0033:
            r3 = move-exception
            goto L_0x006d
        L_0x0035:
            r3 = move-exception
            boolean r4 = r6.containsNull(r7)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x006b
            net.sqlcipher.database.SQLiteDatabase$3 r4 = new net.sqlcipher.database.SQLiteDatabase$3     // Catch:{ all -> 0x0033 }
            r4.<init>(r7)     // Catch:{ all -> 0x0033 }
            r6.keyDatabase(r8, r4)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x004c
            int r4 = r1.length     // Catch:{ all -> 0x0033 }
            if (r4 <= 0) goto L_0x004c
            r6.rekey(r1)     // Catch:{ all -> 0x0033 }
        L_0x004c:
            r0 = 0
            if (r0 == 0) goto L_0x005c
            r6.dbclose()
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r3 == 0) goto L_0x005c
            java.lang.String r3 = r6.getTime()
            r6.mTimeClosed = r3
        L_0x005c:
            if (r1 == 0) goto L_0x006a
            int r3 = r1.length
            if (r3 <= 0) goto L_0x006a
            int r3 = r1.length
        L_0x0062:
            if (r2 >= r3) goto L_0x006a
            byte r4 = r1[r2]
            int r2 = r2 + 1
            goto L_0x0062
        L_0x006a:
            return
        L_0x006b:
            throw r3     // Catch:{ all -> 0x0033 }
        L_0x006d:
            if (r0 == 0) goto L_0x007c
            r6.dbclose()
            boolean r4 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = r6.getTime()
            r6.mTimeClosed = r4
        L_0x007c:
            if (r1 == 0) goto L_0x008a
            int r4 = r1.length
            if (r4 <= 0) goto L_0x008a
            int r4 = r1.length
        L_0x0082:
            if (r2 >= r4) goto L_0x008a
            byte r5 = r1[r2]
            int r2 = r2 + 1
            goto L_0x0082
        L_0x008a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabaseInternal(char[], net.sqlcipher.database.SQLiteDatabaseHook):void");
    }

    private boolean containsNull(char[] data) {
        if (data == null || data.length <= 0) {
            return false;
        }
        for (char datum : data) {
            if (datum == 0) {
                return true;
            }
        }
        return false;
    }

    private void keyDatabase(SQLiteDatabaseHook databaseHook, Runnable keyOperation) {
        if (databaseHook != null) {
            databaseHook.preKey(this);
        }
        if (keyOperation != null) {
            keyOperation.run();
        }
        if (databaseHook != null) {
            databaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor cursor = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (cursor != null) {
                cursor.moveToFirst();
                int i = cursor.getInt(0);
                cursor.close();
            }
        } catch (RuntimeException e) {
            Log.e(TAG, e.getMessage(), e);
            throw e;
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean needUpgrade(int newVersion) {
        return newVersion > getVersion();
    }

    public final String getPath() {
        return this.mPath;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToCompiledQueries(java.lang.String r6, net.sqlcipher.database.SQLiteCompiledSql r7) {
        /*
            r5 = this;
            int r0 = r5.mMaxSqlCacheSize
            if (r0 != 0) goto L_0x002f
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = "Database"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "|NOT adding_sql_to_cache|"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r5.getPath()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "|"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x002e:
            return
        L_0x002f:
            r0 = 0
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r5.mCompiledQueries
            monitor-enter(r1)
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r2 = r5.mCompiledQueries     // Catch:{ all -> 0x00c6 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x00c6 }
            net.sqlcipher.database.SQLiteCompiledSql r2 = (net.sqlcipher.database.SQLiteCompiledSql) r2     // Catch:{ all -> 0x00c6 }
            r0 = r2
            if (r0 == 0) goto L_0x0040
            monitor-exit(r1)     // Catch:{ all -> 0x00c6 }
            return
        L_0x0040:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r2 = r5.mCompiledQueries     // Catch:{ all -> 0x00c6 }
            int r2 = r2.size()     // Catch:{ all -> 0x00c6 }
            int r3 = r5.mMaxSqlCacheSize     // Catch:{ all -> 0x00c6 }
            if (r2 != r3) goto L_0x0085
            int r2 = r5.mCacheFullWarnings     // Catch:{ all -> 0x00c6 }
            r3 = 1
            int r2 = r2 + r3
            r5.mCacheFullWarnings = r2     // Catch:{ all -> 0x00c6 }
            if (r2 != r3) goto L_0x00c4
            java.lang.String r2 = "Database"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r3.<init>()     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "Reached MAX size for compiled-sql statement cache for database "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = r5.getPath()     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "; i.e., NO space for this sql statement in cache: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = ". Please change your sql statements to use '?' for "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "bindargs, instead of using actual values"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c6 }
            android.util.Log.w(r2, r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x00c4
        L_0x0085:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r2 = r5.mCompiledQueries     // Catch:{ all -> 0x00c6 }
            r2.put(r6, r7)     // Catch:{ all -> 0x00c6 }
            boolean r2 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = "Database"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c6 }
            r3.<init>()     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "|adding_sql_to_cache|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = r5.getPath()     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r4 = r5.mCompiledQueries     // Catch:{ all -> 0x00c6 }
            int r4 = r4.size()     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00c6 }
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c6 }
            android.util.Log.v(r2, r3)     // Catch:{ all -> 0x00c6 }
        L_0x00c4:
            monitor-exit(r1)     // Catch:{ all -> 0x00c6 }
            return
        L_0x00c6:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c6 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.addToCompiledQueries(java.lang.String, net.sqlcipher.database.SQLiteCompiledSql):void");
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql compiledSql : this.mCompiledQueries.values()) {
                compiledSql.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r2 == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r6.mNumCacheHits++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r6.mNumCacheMisses++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        android.util.Log.v(TAG, "|cache_stats|" + getPath() + "|" + r6.mCompiledQueries.size() + "|" + r6.mNumCacheHits + "|" + r6.mNumCacheMisses + "|" + r2 + "|" + r6.mTimeOpened + "|" + r6.mTimeClosed + "|" + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bb, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.sqlcipher.database.SQLiteCompiledSql getCompiledStatementForSql(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r1 = r6.mCompiledQueries
            monitor-enter(r1)
            r2 = 0
            int r3 = r6.mMaxSqlCacheSize     // Catch:{ all -> 0x00bc }
            if (r3 != 0) goto L_0x002c
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE     // Catch:{ all -> 0x00bc }
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = "Database"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r4.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = "|cache NOT found|"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r6.getPath()     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00bc }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x00bc }
        L_0x0029:
            r3 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x00bc }
            return r3
        L_0x002c:
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r3 = r6.mCompiledQueries     // Catch:{ all -> 0x00bc }
            java.lang.Object r3 = r3.get(r7)     // Catch:{ all -> 0x00bc }
            net.sqlcipher.database.SQLiteCompiledSql r3 = (net.sqlcipher.database.SQLiteCompiledSql) r3     // Catch:{ all -> 0x00bc }
            r0 = r3
            r4 = 1
            if (r3 == 0) goto L_0x0039
            r2 = r4
        L_0x0039:
            monitor-exit(r1)     // Catch:{ all -> 0x00bf }
            if (r2 == 0) goto L_0x0042
            int r1 = r6.mNumCacheHits
            int r1 = r1 + r4
            r6.mNumCacheHits = r1
            goto L_0x0047
        L_0x0042:
            int r1 = r6.mNumCacheMisses
            int r1 = r1 + r4
            r6.mNumCacheMisses = r1
        L_0x0047:
            boolean r1 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r1 == 0) goto L_0x00bb
            java.lang.String r1 = "Database"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "|cache_stats|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r6.getPath()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.util.Map<java.lang.String, net.sqlcipher.database.SQLiteCompiledSql> r4 = r6.mCompiledQueries
            int r4 = r4.size()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            int r4 = r6.mNumCacheHits
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            int r4 = r6.mNumCacheMisses
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r6.mTimeOpened
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r6.mTimeClosed
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "|"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r3 = r3.toString()
            android.util.Log.v(r1, r3)
        L_0x00bb:
            return r0
        L_0x00bc:
            r3 = move-exception
        L_0x00bd:
            monitor-exit(r1)     // Catch:{ all -> 0x00bf }
            throw r3
        L_0x00bf:
            r3 = move-exception
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getCompiledStatementForSql(java.lang.String):net.sqlcipher.database.SQLiteCompiledSql");
    }

    public boolean isInCompiledSqlCache(String sql) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(sql);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String sql) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(sql);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public synchronized void setMaxSqlCacheSize(int cacheSize) {
        if (cacheSize > 250 || cacheSize < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        } else if (cacheSize >= this.mMaxSqlCacheSize) {
            this.mMaxSqlCacheSize = cacheSize;
        } else {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        int indx;
        String dbName;
        int idx;
        ArrayList<SQLiteDebug.DbStats> dbStatsList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase db = it.next();
            if (db != null && db.isOpen()) {
                int lookasideUsed = db.native_getDbLookaside();
                String path = db.getPath();
                int indx2 = path.lastIndexOf("/");
                if (indx2 != -1) {
                    indx = indx2 + 1;
                    int i = indx;
                } else {
                    int i2 = indx2;
                    indx = 0;
                }
                String lastnode = path.substring(indx);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(db);
                if (attachedDbs != null) {
                    for (int i3 = 0; i3 < attachedDbs.size(); i3++) {
                        Pair<String, String> p = attachedDbs.get(i3);
                        long pageCount = getPragmaVal(db, ((String) p.first) + ".page_count;");
                        if (i3 == 0) {
                            dbName = lastnode;
                        } else {
                            lookasideUsed = 0;
                            dbName = "  (attached) " + ((String) p.first);
                            if (((String) p.second).trim().length() > 0) {
                                int idx2 = ((String) p.second).lastIndexOf("/");
                                StringBuilder append = new StringBuilder().append(dbName).append(" : ");
                                String str = (String) p.second;
                                if (idx2 != -1) {
                                    idx = idx2 + 1;
                                    int i4 = idx;
                                } else {
                                    int i5 = idx2;
                                    idx = 0;
                                }
                                dbName = append.append(str.substring(idx)).toString();
                            }
                        }
                        if (pageCount > 0) {
                            dbStatsList.add(new SQLiteDebug.DbStats(dbName, pageCount, db.getPageSize(), lookasideUsed));
                        }
                    }
                }
            }
        }
        return dbStatsList;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> databases = new ArrayList<>();
        synchronized (sActiveDatabases) {
            databases.addAll(sActiveDatabases.keySet());
        }
        return databases;
    }

    private static long getPragmaVal(SQLiteDatabase db, String pragma) {
        if (!db.isOpen()) {
            return 0;
        }
        SQLiteStatement prog = null;
        try {
            SQLiteStatement prog2 = new SQLiteStatement(db, "PRAGMA " + pragma);
            long val = prog2.simpleQueryForLong();
            prog2.close();
            return val;
        } catch (Throwable th) {
            if (prog != null) {
                prog.close();
            }
            throw th;
        }
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase dbObj) {
        if (!dbObj.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> attachedDbs = new ArrayList<>();
        Cursor c = dbObj.rawQuery("pragma database_list;", (String[]) null);
        while (c.moveToNext()) {
            attachedDbs.add(new Pair(c.getString(1), c.getString(2)));
        }
        c.close();
        return attachedDbs;
    }

    private byte[] getBytes(char[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteBuffer byteBuffer = Charset.forName(KEY_ENCODING).encode(CharBuffer.wrap(data));
        byte[] result = new byte[byteBuffer.limit()];
        byteBuffer.get(result);
        return result;
    }
}
