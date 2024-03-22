package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private Map<String, Integer> mColumnNameMap;
    private String[] mColumns;
    /* access modifiers changed from: private */
    public int mCount = -1;
    /* access modifiers changed from: private */
    public int mCursorState = 0;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    private int mInitialRead = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public ReentrantLock mLock = null;
    /* access modifiers changed from: private */
    public int mMaxRead = Integer.MAX_VALUE;
    protected MainThreadNotificationHandler mNotificationHandler;
    /* access modifiers changed from: private */
    public boolean mPendingData = false;
    /* access modifiers changed from: private */
    public SQLiteQuery mQuery;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();

    public void setLoadStyle(int initialRead, int maxRead) {
        this.mMaxRead = maxRead;
        this.mInitialRead = initialRead;
        this.mLock = new ReentrantLock(true);
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    private final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int version) {
            this.mThreadState = version;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler != null) {
                SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
                boolean unused = SQLiteCursor.this.mPendingData = false;
                return;
            }
            boolean unused2 = SQLiteCursor.this.mPendingData = true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            net.sqlcipher.database.SQLiteCursor.access$502(r5.this$0, r1);
            sendMessage();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                net.sqlcipher.CursorWindow r0 = r0.mWindow
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            L_0x000f:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.lock()
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                int r1 = r1.mCursorState
                int r2 = r5.mThreadState
                if (r1 == r2) goto L_0x002c
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.unlock()
                goto L_0x008c
            L_0x002c:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                net.sqlcipher.database.SQLiteQuery r1 = r1.mQuery     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r2 = r2.mMaxRead     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r3 = r3.mCount     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r1 = r1.fillWindow(r0, r2, r3)     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                if (r1 == 0) goto L_0x006d
                r2 = -1
                if (r1 != r2) goto L_0x0065
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r3 = r2.mCount     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                net.sqlcipher.database.SQLiteCursor r4 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r4 = r4.mMaxRead     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int r3 = r3 + r4
                int unused = r2.mCount = r3     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                r5.sendMessage()     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.mLock
                r1.unlock()
                goto L_0x000f
            L_0x0065:
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                int unused = r2.mCount = r1     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
                r5.sendMessage()     // Catch:{ Exception -> 0x0082, all -> 0x0077 }
            L_0x006d:
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = r2.mLock
                r2.unlock()
                goto L_0x008c
            L_0x0077:
                r1 = move-exception
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = r2.mLock
                r2.unlock()
                throw r1
            L_0x0082:
                r1 = move-exception
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = r2.mLock
                r2.unlock()
            L_0x008c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    protected static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        MainThreadNotificationHandler(SQLiteCursor cursor) {
            this.wrappedCursor = new WeakReference<>(cursor);
        }

        public void handleMessage(Message msg) {
            SQLiteCursor cursor = (SQLiteCursor) this.wrappedCursor.get();
            if (cursor != null) {
                cursor.notifyDataSetChange();
            }
        }
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
        this.mDatabase = db;
        this.mDriver = driver;
        this.mEditTable = editTable;
        this.mColumnNameMap = null;
        this.mQuery = query;
        try {
            db.lock();
            int columnCount = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                String columnName = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = columnName;
                if ("_id".equals(columnName)) {
                    this.mRowIdColumnIndex = i;
                }
            }
        } finally {
            db.unlock();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public boolean onMove(int oldPosition, int newPosition) {
        if (this.mWindow != null && newPosition >= this.mWindow.getStartPosition() && newPosition < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            return true;
        }
        fillWindow(newPosition);
        return true;
    }

    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    private void fillWindow(int startPos) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(startPos);
        int fillWindow = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        this.mCount = fillWindow;
        if (fillWindow == -1) {
            this.mCount = this.mInitialRead + startPos;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    public int getColumnIndex(String columnName) {
        if (this.mColumnNameMap == null) {
            String[] columns = this.mColumns;
            int columnCount = columns.length;
            HashMap<String, Integer> map = new HashMap<>(columnCount, 1.0f);
            for (int i = 0; i < columnCount; i++) {
                map.put(columns[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = map;
        }
        int periodIndex = columnName.lastIndexOf(46);
        if (periodIndex != -1) {
            Log.e(TAG, "requesting column name with table name -- " + columnName, new Exception());
            columnName = columnName.substring(periodIndex + 1);
        }
        Integer i2 = this.mColumnNameMap.get(columnName);
        if (i2 != null) {
            return i2.intValue();
        }
        return -1;
    }

    public boolean deleteRow() {
        boolean success;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            Log.e(TAG, "Could not delete row because either the row ID column is not available or ithas not been read.");
            return false;
        }
        this.mDatabase.lock();
        try {
            this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
            success = true;
        } catch (SQLException e) {
            success = false;
        } catch (Throwable th) {
            th = th;
            this.mDatabase.unlock();
            throw th;
        }
        try {
            int pos = this.mPos;
            requery();
            moveToPosition(pos);
            this.mDatabase.unlock();
            if (!success) {
                return false;
            }
            onChange(true);
            return true;
        } catch (Throwable th2) {
            th = th2;
            boolean z = success;
            this.mDatabase.unlock();
            throw th;
        }
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    /* Debug info: failed to restart local var, previous not found, register: 17 */
    /* JADX INFO: finally extract failed */
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> additionalValues) {
        Map<? extends Long, ? extends Map<String, Object>> map = additionalValues;
        int i = 0;
        if (!supportsUpdates()) {
            Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (map != null) {
                this.mUpdatedRows.putAll(map);
            }
            if (this.mUpdatedRows.size() == 0) {
                return true;
            }
            this.mDatabase.beginTransaction();
            try {
                StringBuilder sql = new StringBuilder(128);
                for (Map.Entry<Long, Map<String, Object>> rowEntry : this.mUpdatedRows.entrySet()) {
                    Map<String, Object> values = rowEntry.getValue();
                    Long rowIdObj = rowEntry.getKey();
                    if (rowIdObj == null || values == null) {
                        throw new IllegalStateException("null rowId or values found! rowId = " + rowIdObj + ", values = " + values);
                    } else if (values.size() != 0) {
                        long rowId = rowIdObj.longValue();
                        Iterator<Map.Entry<String, Object>> valuesIter = values.entrySet().iterator();
                        sql.setLength(i);
                        sql.append("UPDATE " + this.mEditTable + " SET ");
                        Object[] bindings = new Object[values.size()];
                        int i2 = 0;
                        while (valuesIter.hasNext()) {
                            Map.Entry<String, Object> entry = valuesIter.next();
                            sql.append(entry.getKey());
                            sql.append("=?");
                            bindings[i2] = entry.getValue();
                            if (valuesIter.hasNext()) {
                                sql.append(", ");
                            }
                            i2++;
                        }
                        sql.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + rowId);
                        sql.append(';');
                        this.mDatabase.execSQL(sql.toString(), bindings);
                        this.mDatabase.rowUpdated(this.mEditTable, rowId);
                        i = 0;
                    }
                }
                this.mDatabase.setTransactionSuccessful();
                this.mDatabase.endTransaction();
                this.mUpdatedRows.clear();
                onChange(true);
                return true;
            } catch (Throwable th) {
                this.mDatabase.endTransaction();
                throw th;
            }
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            return super.requery();
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void setWindow(CursorWindow window) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = window;
    }

    public void setSelectionArguments(String[] selectionArgs) {
        this.mDriver.setBindArguments(selectionArgs);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (this.mWindow != null) {
                int len = this.mQuery.mSql.length();
                StringBuilder append = new StringBuilder().append("Finalizing a Cursor that has not been deactivated or closed. database = ").append(this.mDatabase.getPath()).append(", table = ").append(this.mEditTable).append(", query = ");
                String str = this.mQuery.mSql;
                int i = 100;
                if (len <= 100) {
                    i = len;
                }
                Log.e(TAG, append.append(str.substring(0, i)).toString(), this.mStackTrace);
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    public void fillWindow(int startPos, android.database.CursorWindow window) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(startPos);
        int fillWindow = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        this.mCount = fillWindow;
        if (fillWindow == -1) {
            this.mCount = this.mInitialRead + startPos;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}
