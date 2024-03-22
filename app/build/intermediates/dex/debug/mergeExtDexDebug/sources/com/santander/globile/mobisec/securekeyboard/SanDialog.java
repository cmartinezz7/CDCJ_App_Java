package com.santander.globile.mobisec.securekeyboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.santander.globile.mobisec.securekeyboard.listeners.SanEventCallbacks;
import com.santander.globile.mobisec.securekeyboard.listeners.SanEventReceiver;
import com.santander.globile.mobisec.securekeyboard.utils.SanKeyboardUtils;
import java.lang.ref.WeakReference;

@Deprecated
public class SanDialog extends AppCompatActivity implements SanEventCallbacks {
    private static final int LAYOUT_RES_DEFAULT_VALUE = 0;
    private static int contentResId;
    private static WeakReference<Resources.Theme> contentThemeWeakRef;
    private static WeakReference<View> contentViewWeakRef;
    private ViewGroup baseLayout;
    private Resources.Theme extraTheme;
    private View extraView;
    private IntentFilter sanEventFilter;
    private SanEventReceiver sanEventReceiver;

    public static void show(Context context, int layoutResId) {
        contentResId = layoutResId;
        contentThemeWeakRef = new WeakReference<>(context.getTheme());
        context.startActivity(new Intent(context, SanDialog.class));
    }

    public static void show(View view) {
        contentViewWeakRef = new WeakReference<>(view);
        view.getContext().startActivity(new Intent(view.getContext(), SanDialog.class));
    }

    private void retrieveAndReleaseStaticExtras() {
        WeakReference<Resources.Theme> weakReference = contentThemeWeakRef;
        if (weakReference != null) {
            this.extraTheme = (Resources.Theme) weakReference.get();
            contentThemeWeakRef = null;
        }
        WeakReference<View> weakReference2 = contentViewWeakRef;
        if (weakReference2 != null) {
            this.extraView = (View) weakReference2.get();
            contentViewWeakRef = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        SanDialog.super.onCreate(savedInstanceState);
        retrieveAndReleaseStaticExtras();
        setContentView(R.layout.san_dialog_view);
        addDialogContent();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.santander.globile.mobisec.securekeyboard.listeners.SanEventCallbacks, com.santander.globile.mobisec.securekeyboard.SanDialog, androidx.appcompat.app.AppCompatActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onStart() {
        SanDialog.super.onStart();
        SanKeyboardView sanKeyboardView = SanKeyboardUtils.findKeyboardView((Activity) this);
        if (sanKeyboardView != null) {
            onSanKeyboardReady(sanKeyboardView);
            return;
        }
        if (this.sanEventReceiver == null) {
            this.sanEventReceiver = new SanEventReceiver(this);
            this.sanEventFilter = new IntentFilter(SanEventReceiver.ACTION_KEYBOARD_READY);
        }
        registerReceiver(this.sanEventReceiver, this.sanEventFilter);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        terminateSanEventReceiver();
        SanDialog.super.onStop();
    }

    public void onSanKeyboardReady(SanKeyboardView keyboardView) {
        terminateSanEventReceiver();
        keyboardView.setEventListener(this);
    }

    public void onSanKeyboardShown(SanKeyboardView keyboardView) {
    }

    public void onSanKeyboardHidden(SanKeyboardView keyboardView) {
    }

    private ViewGroup getVerifiedBaseLayout() {
        if (this.baseLayout == null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.san_dialog_content_view);
            this.baseLayout = viewGroup;
            if (viewGroup == null) {
                throw new IllegalStateException("There was an error");
            }
        }
        return this.baseLayout;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.santander.globile.mobisec.securekeyboard.SanDialog] */
    private void addDialogContent() throws RuntimeException {
        if (this.extraTheme != null) {
            try {
                LayoutInflater.from(this).inflate(contentResId, getVerifiedBaseLayout());
                applyBaseActivityTheme(this.extraTheme);
            } finally {
                contentResId = 0;
            }
        } else {
            View view = this.extraView;
            if (view != null) {
                Resources.Theme theme = view.getContext().getTheme();
                getVerifiedBaseLayout().addView(this.extraView);
                applyBaseActivityTheme(theme);
                return;
            }
            throw new IllegalStateException("There was an error");
        }
    }

    private void applyBaseActivityTheme(Resources.Theme theme) {
        View dialogContentView;
        if (theme != null && (dialogContentView = getVerifiedBaseLayout().getChildAt(0)) != null) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16842836, typedValue, true);
            if (typedValue.type < 28 || typedValue.type > 31) {
                try {
                    dialogContentView.setBackground(getResources().getDrawable(typedValue.resourceId));
                } catch (Exception e) {
                    dialogContentView.setBackgroundColor(getResources().getColor(17170443));
                }
            } else {
                dialogContentView.setBackgroundColor(typedValue.data);
            }
        }
    }

    private void terminateSanEventReceiver() {
        SanEventReceiver sanEventReceiver2 = this.sanEventReceiver;
        if (sanEventReceiver2 != null) {
            unregisterReceiver(sanEventReceiver2);
            this.sanEventReceiver = null;
        }
    }
}
