package com.tealium.library;

import android.text.TextUtils;
import android.webkit.WebView;
import com.tealium.internal.a;
import com.tealium.internal.b;
import com.tealium.internal.c.f;
import com.tealium.internal.c.h;
import com.tealium.internal.c.j;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.data.DispatchStore;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.listeners.AddRemoteCommandListener;
import com.tealium.internal.listeners.BatteryUpdateListener;
import com.tealium.internal.listeners.DispatchReadyListener;
import com.tealium.internal.listeners.PublishSettingsUpdateListener;
import com.tealium.internal.listeners.RemoveRemoteCommandListener;
import com.tealium.internal.listeners.TraceUpdateListener;
import com.tealium.internal.listeners.WebViewLoadedListener;
import com.tealium.internal.tagbridge.RemoteCommand;
import com.tealium.library.DataSources;
import com.tealium.library.Tealium;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

final class c implements AddRemoteCommandListener, BatteryUpdateListener, DispatchReadyListener, PublishSettingsUpdateListener, RemoveRemoteCommandListener, TraceUpdateListener, WebViewLoadedListener {
    private final Tealium.Config a;
    private final com.tealium.internal.c b;
    private final a c;
    private final DispatchValidator[] d;
    private final DispatchStore e;
    private final b f;
    private final String g;
    /* access modifiers changed from: private */
    public final List<RemoteCommand> h;
    /* access modifiers changed from: private */
    public volatile com.tealium.internal.b.c i;
    private com.tealium.internal.b.b j;
    private com.tealium.internal.b.a k;
    private PublishSettings l;
    private boolean m;
    private boolean n;
    private String o;
    private volatile boolean p;

    c(Tealium.Config config, com.tealium.internal.c cVar, DataSources dataSources) {
        this(config, cVar, dataSources, a.a(config.getApplication()));
    }

    private c(Tealium.Config config, com.tealium.internal.c cVar, DataSources dataSources, a aVar) {
        this.a = config;
        this.g = dataSources.getVisitorId();
        this.f = config.getLogger();
        this.e = new DispatchStore(config);
        this.d = (DispatchValidator[]) config.getDispatchValidators().toArray(new DispatchValidator[config.getDispatchValidators().size()]);
        this.b = cVar;
        this.c = aVar;
        this.h = new LinkedList();
        onPublishSettingsUpdate(config.getPublishSettings());
    }

    private void a() {
        if (this.k == null && this.l.isS2SLegacyEnabled()) {
            com.tealium.internal.b.a aVar = new com.tealium.internal.b.a(this.a, this.b, this.g);
            this.k = aVar;
            this.b.a((EventListener) aVar);
        } else if (this.k != null && !this.l.isS2SLegacyEnabled()) {
            this.b.b((EventListener) this.k);
            this.k = null;
        }
    }

    private boolean a(int i2) {
        return this.e.getCount() + i2 < this.l.getEventBatchSize();
    }

    private boolean a(Dispatch dispatch) {
        int i2 = 0;
        int i3 = dispatch == null ? 0 : 1;
        boolean a2 = a(i3);
        if (!a2) {
            a2 = d();
            if (!a2) {
                a2 = e();
                if (!a2) {
                    a2 = !f();
                    if (a2 && dispatch != null) {
                        this.f.b(R.string.dispatch_queue_debug_queued_dispatcher_not_ready, dispatch);
                    }
                } else if (dispatch != null) {
                    this.f.b(this.l.isWifiOnlySending() ? R.string.dispatch_queue_debug_queued_no_wifi : R.string.dispatch_queue_debug_queued_no_network, dispatch);
                }
            } else if (dispatch != null) {
                this.f.b(R.string.dispatch_queue_debug_queued_battery_low, dispatch);
            }
        } else if (dispatch != null) {
            this.f.b(R.string.dispatch_queue_debug_queued_batch, dispatch, Integer.valueOf(this.e.getCount() + i3), Integer.valueOf(this.l.getEventBatchSize()));
        }
        if (dispatch != null) {
            while (true) {
                DispatchValidator[] dispatchValidatorArr = this.d;
                if (i2 >= dispatchValidatorArr.length || (a2 = dispatchValidatorArr[i2].shouldQueue(dispatch, a2))) {
                    break;
                }
                i2++;
            }
        }
        return a2;
    }

    private void b() {
        if (this.l.isTagManagementEnabled() && this.i == null) {
            this.i = new com.tealium.internal.b.c(this.a, this.b);
            this.b.a((EventListener) this.i);
            this.b.a(h());
            this.i.a(this.o, false);
        } else if (!this.l.isTagManagementEnabled() && this.i != null) {
            this.b.b((EventListener) this.i);
            this.i = null;
            this.m = false;
            this.n = false;
        }
    }

    private boolean b(Dispatch dispatch) {
        int i2 = 0;
        while (true) {
            DispatchValidator[] dispatchValidatorArr = this.d;
            if (i2 >= dispatchValidatorArr.length) {
                return false;
            }
            DispatchValidator dispatchValidator = dispatchValidatorArr[i2];
            if (dispatchValidator.shouldDrop(dispatch)) {
                this.f.b(R.string.dispatch_queue_debug_format_suppressed_by, dispatchValidator, dispatch);
                return true;
            }
            i2++;
        }
    }

    private void c() {
        com.tealium.internal.b.b bVar;
        if (this.l.isCollectEnabled() && this.j == null) {
            com.tealium.internal.b.b bVar2 = new com.tealium.internal.b.b(this.a, this.b, this.f, this.g);
            this.j = bVar2;
            this.b.a((EventListener) bVar2);
            this.j.a(this.o);
        } else if (!this.l.isCollectEnabled() && (bVar = this.j) != null) {
            this.b.b((EventListener) bVar);
            this.j = null;
        }
    }

    private boolean d() {
        return this.p && this.l.isBatterySaver();
    }

    private boolean e() {
        return this.l.isWifiOnlySending() ? !this.c.a() : !this.c.b();
    }

    private boolean f() {
        boolean z = this.l.isCollectEnabled() || this.l.isS2SLegacyEnabled();
        if (z && !this.l.isTagManagementEnabled()) {
            return true;
        }
        if (!this.l.isTagManagementEnabled() || !this.n) {
            return z && this.l.isTagManagementEnabled() && this.m;
        }
        return true;
    }

    private void g() {
        if (this.e.getCount() != 0 && !a((Dispatch) null)) {
            Dispatch[] dequeueDispatches = this.e.dequeueDispatches();
            for (Dispatch hVar : dequeueDispatches) {
                this.b.b(new h(hVar));
            }
        }
    }

    private Runnable h() {
        return new Runnable() {
            public void run() {
                com.tealium.internal.b.c a2 = c.this.i;
                if (a2 != null) {
                    for (int i = 0; i < c.this.h.size(); i++) {
                        a2.a().a((RemoteCommand) c.this.h.get(i));
                    }
                }
            }
        };
    }

    public void onAddRemoteCommand(RemoteCommand remoteCommand) {
        this.h.add(remoteCommand);
        com.tealium.internal.b.c cVar = this.i;
        if (cVar != null) {
            cVar.a().a(remoteCommand);
        }
    }

    public void onBatteryUpdate(boolean z) {
        this.p = z;
    }

    public void onDispatchReady(Dispatch dispatch) {
        com.tealium.internal.c cVar;
        j hVar;
        if (!b(dispatch)) {
            if (a(dispatch)) {
                dispatch.putIfAbsent(DataSources.Key.WAS_QUEUED, String.valueOf(true));
                this.e.enqueueDispatch(dispatch);
                cVar = this.b;
                hVar = new f(dispatch);
            } else {
                if (this.e.getCount() > 0) {
                    Dispatch[] dequeueDispatches = this.e.dequeueDispatches();
                    for (Dispatch hVar2 : dequeueDispatches) {
                        this.b.b(new h(hVar2));
                    }
                }
                dispatch.putIfAbsent(DataSources.Key.WAS_QUEUED, String.valueOf(false));
                cVar = this.b;
                hVar = new h(dispatch);
            }
            cVar.b(hVar);
        }
    }

    public void onPublishSettingsUpdate(PublishSettings publishSettings) {
        this.l = publishSettings;
        this.e.update(publishSettings.getOfflineDispatchLimit(), this.l.getDispatchExpiration());
        if (this.l.getSource() != null) {
            a();
            c();
            b();
            g();
        }
    }

    public void onRemoveRemoteCommand(RemoteCommand remoteCommand) {
        this.h.remove(remoteCommand);
        com.tealium.internal.b.c cVar = this.i;
        if (cVar != null) {
            cVar.a().b(remoteCommand);
        }
    }

    public void onTraceUpdate(String str, boolean z) {
        if (!TextUtils.equals(this.o, str)) {
            if (TextUtils.isEmpty(this.o)) {
                this.f.c(R.string.dispatch_router_join_trace, str);
            } else if (TextUtils.isEmpty(str)) {
                this.f.c(R.string.dispatch_router_leave_trace, this.o);
            } else {
                this.f.c(R.string.dispatch_router_update_trace, this.o, str);
            }
            this.o = str;
            com.tealium.internal.b.b bVar = this.j;
            if (bVar != null) {
                bVar.a(str);
            }
            if (this.i != null) {
                this.i.a(str, !z);
            }
        }
    }

    public void onWebViewLoad(WebView webView, boolean z) {
        this.m = true;
        this.n = z;
        g();
    }
}
