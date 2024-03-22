package com.santander.globile.mobisec.securekeyboard;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class BaseSecureEditText_LifecycleAdapter implements GeneratedAdapter {
    final BaseSecureEditText mReceiver;

    BaseSecureEditText_LifecycleAdapter(BaseSecureEditText receiver) {
        this.mReceiver = receiver;
    }

    public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny, MethodCallsLogger logger) {
        boolean hasLogger = logger != null;
        if (onAny || event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (!hasLogger || logger.approveCall("onDestroy", 1)) {
            this.mReceiver.onDestroy();
        }
    }
}
