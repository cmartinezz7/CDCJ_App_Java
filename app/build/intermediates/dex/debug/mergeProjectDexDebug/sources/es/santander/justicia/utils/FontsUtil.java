package es.santander.justicia.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.Hashtable;

public class FontsUtil {
    public static TextView changeFont(Context context, TextView text, String fontAsset) {
        TextView myTextView = text;
        myTextView.setTypeface(FontCache.get(fontAsset, context));
        return myTextView;
    }

    public static float setFonts(Context context, float textSize) {
        return ((float) getDeviceScreenSize(context).heightPixels) * textSize;
    }

    public static DisplayMetrics getDeviceScreenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static class FontCache {
        private static Hashtable<String, Typeface> fontCache = new Hashtable<>();

        public static Typeface get(String name, Context context) {
            Typeface tf = fontCache.get(name);
            if (tf != null) {
                return tf;
            }
            try {
                Typeface tf2 = Typeface.createFromAsset(context.getAssets(), name);
                fontCache.put(name, tf2);
                return tf2;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
