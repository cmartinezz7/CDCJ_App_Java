package com.tealium.library;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.tealium.internal.c;
import com.tealium.internal.c.b;
import com.tealium.internal.listeners.DisableListener;
import com.tealium.library.Tealium;

final class a implements DisableListener {
    private final Application a;
    private final Application.ActivityLifecycleCallbacks b;

    public a(Tealium.Config config, c cVar) {
        Application application = config.getApplication();
        this.a = application;
        if (Build.VERSION.SDK_INT >= 14) {
            Application.ActivityLifecycleCallbacks a2 = a(cVar);
            this.b = a2;
            application.registerActivityLifecycleCallbacks(a2);
            return;
        }
        this.b = null;
        config.getLogger().e(R.string.activity_observer_warn_api_too_low, new Object[0]);
    }

    private static Application.ActivityLifecycleCallbacks a(final c cVar) {
        if (cVar != null) {
            return new Application.ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivityPaused(Activity activity) {
                    cVar.a(new com.tealium.internal.c.a(activity));
                }

                public void onActivityResumed(Activity activity) {
                    cVar.a(new b(activity));
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }
            };
        }
        throw new IllegalArgumentException();
    }

    public void onDisable(Tealium tealium) {
        if (Build.VERSION.SDK_INT >= 14) {
            this.a.unregisterActivityLifecycleCallbacks(this.b);
        }
    }
}
