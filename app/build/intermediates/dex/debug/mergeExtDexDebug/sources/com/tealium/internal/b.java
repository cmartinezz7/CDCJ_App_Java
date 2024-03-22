package com.tealium.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.listeners.DispatchSendListener;
import com.tealium.internal.listeners.PublishSettingsUpdateListener;
import com.tealium.library.BuildConfig;
import com.tealium.library.DataSources;
import com.tealium.library.R;

public final class b implements DispatchSendListener, PublishSettingsUpdateListener {
    private final Context a;
    private volatile int b;

    public b(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = a(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r4) {
        /*
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r4 = r4.toLowerCase(r0)
            int r0 = r4.hashCode()
            r1 = 3600(0xe10, float:5.045E-42)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L_0x002f
            r1 = 99349(0x18415, float:1.39218E-40)
            if (r0 == r1) goto L_0x0025
            r1 = 3449687(0x34a357, float:4.834041E-39)
            if (r0 == r1) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r0 = "prod"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0039
            r4 = r3
            goto L_0x003a
        L_0x0025:
            java.lang.String r0 = "dev"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0039
            r4 = 0
            goto L_0x003a
        L_0x002f:
            java.lang.String r0 = "qa"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0039
            r4 = r2
            goto L_0x003a
        L_0x0039:
            r4 = -1
        L_0x003a:
            if (r4 == 0) goto L_0x0048
            if (r4 == r2) goto L_0x0046
            if (r4 == r3) goto L_0x0044
            r4 = 2147483647(0x7fffffff, float:NaN)
            return r4
        L_0x0044:
            r4 = 7
            return r4
        L_0x0046:
            r4 = 4
            return r4
        L_0x0048:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tealium.internal.b.a(java.lang.String):int");
    }

    public void a(int i) {
        if (e()) {
            Log.e(BuildConfig.TAG, this.a.getString(i));
        }
    }

    public void a(int i, Throwable th) {
        if (this.b <= 7) {
            Log.wtf(BuildConfig.TAG, this.a.getString(i), th);
        }
    }

    public void a(int i, Throwable th, Object... objArr) {
        if (e()) {
            Log.e(BuildConfig.TAG, this.a.getString(i, objArr), th);
        }
    }

    public void a(int i, Object... objArr) {
        if (this.b == 2) {
            Log.v(BuildConfig.TAG, this.a.getString(i, objArr));
        }
    }

    public void a(Throwable th) {
        a(R.string.logger_error_caught_exception, th, new Object[0]);
    }

    public boolean a() {
        return this.b == 2;
    }

    public void b(int i, Object... objArr) {
        if (b()) {
            Log.d(BuildConfig.TAG, this.a.getString(i, objArr));
        }
    }

    public void b(Throwable th) {
        if (this.b <= 7) {
            Log.wtf(BuildConfig.TAG, th);
        }
    }

    public boolean b() {
        return this.b <= 3;
    }

    public void c(int i, Object... objArr) {
        if (c()) {
            Log.i(BuildConfig.TAG, this.a.getString(i, objArr));
        }
    }

    public boolean c() {
        return this.b <= 4;
    }

    public void d(int i, Object... objArr) {
        if (e()) {
            Log.e(BuildConfig.TAG, this.a.getString(i, objArr));
        }
    }

    public boolean d() {
        return this.b <= 5;
    }

    public void e(int i, Object... objArr) {
        if (d()) {
            Log.w(BuildConfig.TAG, this.a.getString(i, objArr));
        }
    }

    public boolean e() {
        return this.b <= 6;
    }

    public void onDispatchSend(Dispatch dispatch) {
        if (b()) {
            Context context = this.a;
            int i = R.string.logger_dispatch_send;
            Object[] objArr = new Object[2];
            objArr[0] = "true".equals(dispatch.getString(DataSources.Key.WAS_QUEUED)) ? "queued" : "new";
            objArr[1] = dispatch.toSortedJsonString();
            Log.d(BuildConfig.TAG, context.getString(i, objArr));
        }
    }

    public void onPublishSettingsUpdate(PublishSettings publishSettings) {
        if (!TextUtils.isEmpty(publishSettings.getOverrideLog())) {
            this.b = a(publishSettings.getOverrideLog());
        }
        c(R.string.logger_rcvd_publish_settings, publishSettings);
    }
}
