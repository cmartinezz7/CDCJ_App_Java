package com.santander.globile.mobisec.securekeyboard.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.santander.globile.mobisec.securekeyboard.R;
import com.santander.globile.mobisec.securekeyboard.SanKeyboardView;
import com.santander.globile.mobisec.securekeyboard.listeners.SanEventReceiver;
import java.util.Locale;

public abstract class SanKeyboardUtils {
    public static final int INVALID_INDEX = Integer.MIN_VALUE;

    private SanKeyboardUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static SanKeyboardView findKeyboardView(Activity activity) {
        if (activity != null) {
            return findKeyboardView(activity.getWindow().getDecorView());
        }
        return null;
    }

    private static SanKeyboardView findKeyboardView(View view) {
        if (view != null) {
            return (SanKeyboardView) view.getRootView().findViewById(R.id.san_keyboard_view);
        }
        return null;
    }

    public static SanKeyboardView createKeyboardView(View view) {
        SanKeyboardView sanKeyboardView = findKeyboardView(view);
        if (sanKeyboardView == null) {
            Context context = view.getContext();
            LayoutInflater.from(context).inflate(R.layout.san_keyboard_view, (ViewGroup) view.getRootView().findViewById(16908290));
            sanKeyboardView = findKeyboardView(view);
            if (sanKeyboardView != null) {
                sanKeyboardView.initAnimationsManager();
                context.sendBroadcast(new Intent(SanEventReceiver.ACTION_KEYBOARD_READY));
            } else {
                throw new IllegalStateException("Error creating keyboard!");
            }
        }
        return sanKeyboardView;
    }

    public static Context getContextForLocale(Context context, Locale desiredLocale) {
        Configuration conf = new Configuration(context.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            conf.setLocale(desiredLocale);
            Context contextForLocale = context.createConfigurationContext(conf);
            contextForLocale.getResources().getConfiguration().setLocale(desiredLocale);
            return contextForLocale;
        }
        conf.locale = desiredLocale;
        context.getResources().updateConfiguration(conf, context.getResources().getDisplayMetrics());
        return context;
    }
}
