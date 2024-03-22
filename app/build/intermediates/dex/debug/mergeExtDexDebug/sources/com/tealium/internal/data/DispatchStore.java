package com.tealium.internal.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tealium.library.Tealium;
import java.io.File;
import java.util.Locale;

public final class DispatchStore {
    private final SQLiteDatabase a;
    private int b;
    private int c;
    private float d;

    public DispatchStore(Tealium.Config config) {
        this.a = a(config);
        update(config.getPublishSettings().getOfflineDispatchLimit(), config.getPublishSettings().getDispatchExpiration());
    }

    private static SQLiteDatabase a(Tealium.Config config) {
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(new File(config.getTealiumDir(), "tealium.db").getAbsolutePath(), (SQLiteDatabase.CursorFactory) null, net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY);
        openDatabase.execSQL(String.format(Locale.ROOT, "CREATE TABLE IF NOT EXISTS %s ( \t%s TEXT NOT NULL, \t%s INT NOT NULL )", new Object[]{"dispatch", "data_json", "post_time"}));
        return openDatabase;
    }

    private void a() {
        Cursor rawQuery = this.a.rawQuery("SELECT COUNT(*) FROM dispatch", (String[]) null);
        rawQuery.moveToFirst();
        this.b = rawQuery.getInt(0);
        rawQuery.close();
    }

    private static void a(SQLiteDatabase sQLiteDatabase, float f) {
        if (f >= 0.0f) {
            sQLiteDatabase.delete("dispatch", "post_time < ?", new String[]{Long.toString(System.currentTimeMillis() - (((long) f) * 86400000))});
        }
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tealium.internal.data.Dispatch[] dequeueDispatches() {
        /*
            r11 = this;
            int r0 = r11.b
            r1 = 0
            if (r0 != 0) goto L_0x0008
            com.tealium.internal.data.Dispatch[] r0 = new com.tealium.internal.data.Dispatch[r1]
            return r0
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r2 = r11.a
            java.lang.String r0 = "post_time"
            java.lang.String r3 = "data_json"
            java.lang.String[] r4 = new java.lang.String[]{r0, r3}
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r3 = "dispatch"
            java.lang.String r9 = "post_time ASC"
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            int r2 = r0.getCount()
            com.tealium.internal.data.Dispatch[] r3 = new com.tealium.internal.data.Dispatch[r2]
            r0.moveToFirst()
            r4 = r1
        L_0x0028:
            boolean r5 = r0.isAfterLast()
            if (r5 != 0) goto L_0x004e
            int r5 = r4 + 1
            com.tealium.internal.data.Dispatch r6 = new com.tealium.internal.data.Dispatch     // Catch:{ JSONException -> 0x0046 }
            long r7 = r0.getLong(r1)     // Catch:{ JSONException -> 0x0046 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0046 }
            r10 = 1
            java.lang.String r10 = r0.getString(r10)     // Catch:{ JSONException -> 0x0046 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0046 }
            r6.<init>(r7, r9)     // Catch:{ JSONException -> 0x0046 }
            r3[r4] = r6     // Catch:{ JSONException -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r4 = move-exception
            int r5 = r5 + -1
        L_0x0049:
            r4 = r5
            r0.moveToNext()
            goto L_0x0028
        L_0x004e:
            if (r4 == r2) goto L_0x0057
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r4)
            r3 = r2
            com.tealium.internal.data.Dispatch[] r3 = (com.tealium.internal.data.Dispatch[]) r3
        L_0x0057:
            r0.close()
            android.database.sqlite.SQLiteDatabase r0 = r11.a
            java.lang.String r2 = "dispatch"
            r4 = 0
            r0.delete(r2, r4, r4)
            r11.b = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tealium.internal.data.DispatchStore.dequeueDispatches():com.tealium.internal.data.Dispatch[]");
    }

    public void enqueueDispatch(Dispatch dispatch) {
        if (dispatch != null) {
            a(this.a, this.d);
            a();
            int i = this.c;
            if (i != 0) {
                int i2 = this.b;
                int i3 = i2 + 1;
                if (i == -1 || i3 <= i) {
                    this.b = i2 + 1;
                } else {
                    this.a.execSQL("DELETE FROM dispatch WHERE rowid IN ( \tSELECT rowid \tFROM dispatch\tORDER BY post_time ASC \tLIMIT ? )", new Object[]{Integer.valueOf(i3 - i)});
                    this.b = this.c;
                }
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("data_json", dispatch.toJsonString());
                contentValues.put("post_time", Long.valueOf(dispatch.getCreationTime()));
                this.a.insert("dispatch", (String) null, contentValues);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("dispatch must not be null.");
    }

    public int getCount() {
        return this.b;
    }

    public void update(int i, float f) {
        this.c = i;
        this.d = f;
        a(this.a, f);
        a();
    }
}
