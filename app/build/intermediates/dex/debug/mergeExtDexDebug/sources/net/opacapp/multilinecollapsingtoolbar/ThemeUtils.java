package net.opacapp.multilinecollapsingtoolbar;

import android.content.Context;
import android.content.res.TypedArray;

class ThemeUtils {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {2130772097};

    ThemeUtils() {
    }

    static void checkAppCompatTheme(Context context) {
        TypedArray a = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        boolean failed = !a.hasValue(0);
        if (a != null) {
            a.recycle();
        }
        if (failed) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
