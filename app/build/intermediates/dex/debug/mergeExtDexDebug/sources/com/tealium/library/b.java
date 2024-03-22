package com.tealium.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tealium.internal.c;
import com.tealium.internal.c.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DisableListener;
import com.tealium.internal.listeners.PopulateDispatchListener;
import com.tealium.library.DataSources;

final class b implements DisableListener, PopulateDispatchListener {
    private final BroadcastReceiver a;
    private final Context b;
    /* access modifiers changed from: private */
    public volatile int c;
    /* access modifiers changed from: private */
    public volatile boolean d;
    /* access modifiers changed from: private */
    public volatile boolean e;

    b(Context context, c cVar) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            BroadcastReceiver a2 = a(cVar);
            this.a = a2;
            a2.onReceive(applicationContext, applicationContext.registerReceiver(a2, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
            return;
        }
        throw new IllegalArgumentException();
    }

    private BroadcastReceiver a(final c cVar) {
        if (cVar != null) {
            return new BroadcastReceiver() {
                private void a() {
                    cVar.b(new d(b.this.e));
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
                /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onReceive(android.content.Context r8, android.content.Intent r9) {
                    /*
                        r7 = this;
                        if (r9 != 0) goto L_0x0003
                        return
                    L_0x0003:
                        java.lang.String r0 = "level"
                        r1 = -1
                        int r0 = r9.getIntExtra(r0, r1)
                        java.lang.String r2 = "scale"
                        int r2 = r9.getIntExtra(r2, r1)
                        java.lang.String r3 = "status"
                        int r3 = r9.getIntExtra(r3, r1)
                        r4 = 1
                        r5 = 0
                        if (r0 == r1) goto L_0x0049
                        if (r2 == r1) goto L_0x0049
                        if (r2 == 0) goto L_0x0049
                        com.tealium.library.b r6 = com.tealium.library.b.this
                        float r0 = (float) r0
                        float r2 = (float) r2
                        float r0 = r0 / r2
                        r2 = 1120403456(0x42c80000, float:100.0)
                        float r0 = r0 * r2
                        int r0 = java.lang.Math.round(r0)
                        int unused = r6.c = r0
                        com.tealium.library.b r0 = com.tealium.library.b.this
                        int r0 = r0.c
                        r2 = 15
                        if (r0 > r2) goto L_0x0039
                        r0 = r4
                        goto L_0x003a
                    L_0x0039:
                        r0 = r5
                    L_0x003a:
                        com.tealium.library.b r2 = com.tealium.library.b.this
                        boolean r2 = r2.e
                        r2 = r2 ^ r0
                        if (r2 == 0) goto L_0x0056
                        com.tealium.library.b r2 = com.tealium.library.b.this
                        boolean unused = r2.e = r0
                        goto L_0x0053
                    L_0x0049:
                        com.tealium.library.b r0 = com.tealium.library.b.this
                        int unused = r0.c = r1
                        com.tealium.library.b r0 = com.tealium.library.b.this
                        boolean unused = r0.e = r5
                    L_0x0053:
                        r7.a()
                    L_0x0056:
                        if (r3 == r1) goto L_0x0065
                        com.tealium.library.b r0 = com.tealium.library.b.this
                        r1 = 2
                        if (r3 == r1) goto L_0x0062
                        r1 = 5
                        if (r3 != r1) goto L_0x0061
                        goto L_0x0062
                    L_0x0061:
                        r4 = r5
                    L_0x0062:
                        boolean unused = r0.d = r4
                    L_0x0065:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tealium.library.b.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
                }
            };
        }
        throw new IllegalArgumentException();
    }

    public void onDisable(Tealium tealium) {
        this.b.unregisterReceiver(this.a);
    }

    public void onPopulateDispatch(Dispatch dispatch) {
        if (this.c != -1) {
            dispatch.put(DataSources.Key.DEVICE_BATTERY_PERCENT, this.c + "");
        }
        dispatch.put(DataSources.Key.DEVICE_ISCHARGING, this.d + "");
    }
}
