package com.santander.globile.mobisec.securekeyboard.listeners;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;
import java.lang.ref.WeakReference;

public class SanEventReceiver extends BroadcastReceiver {
    public static final String ACTION_KEYBOARD_READY = (SanEventReceiver.class.getName() + ".ACTION_KEYBOARD_READY");
    private final WeakReference<SanEventCallbacks> sanEventCallbacksWeakRef;

    public SanEventReceiver(SanEventCallbacks sanEventCallbacks) {
        this.sanEventCallbacksWeakRef = new WeakReference<>(sanEventCallbacks);
    }

    public void onReceive(Context context, Intent intent) {
        SanEventCallbacks sanEventCallbacks;
        if (intent != null && ACTION_KEYBOARD_READY.equals(intent.getAction()) && (sanEventCallbacks = (SanEventCallbacks) this.sanEventCallbacksWeakRef.get()) != null && (context instanceof Activity)) {
            sanEventCallbacks.onSanKeyboardReady(SanKeyboardUtils.findKeyboardView((Activity) context));
        }
    }
}
