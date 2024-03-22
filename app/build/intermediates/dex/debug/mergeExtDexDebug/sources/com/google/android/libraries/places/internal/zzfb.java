package com.google.android.libraries.places.internal;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import com.google.android.libraries.places.R;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzfb {
    public static void zza(Activity activity, int i, int i2, int i3) {
        Toolbar zza = zza(activity);
        if (zza != null) {
            zza.setBackgroundColor(i);
            zza.setTitleTextColor(i3);
            Drawable navigationIcon = zza.getNavigationIcon();
            if (navigationIcon != null) {
                zza(navigationIcon, i3);
                zza.setNavigationIcon(navigationIcon);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().setStatusBarColor(i2);
            }
        }
    }

    public static void zza(Drawable drawable, int i) {
        drawable.mutate().setColorFilter(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)), PorterDuff.Mode.SRC_ATOP);
        drawable.setAlpha(Color.alpha(i));
    }

    private static Toolbar zza(Activity activity) {
        try {
            Toolbar findViewById = activity.findViewById(R.id.places_autocomplete_action_bar);
            if (findViewById != null) {
                return findViewById;
            }
            if (Log.isLoggable("ColorUtil", 6)) {
                Log.e("ColorUtil", "Failed to get action bar; couldn't get view.");
            }
            return null;
        } catch (ClassCastException e) {
            if (Log.isLoggable("ColorUtil", 6)) {
                Log.e("ColorUtil", "Failed to get action bar; View is wrong class.", e);
            }
            return null;
        }
    }
}
