package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public enum TypeFaceCache {
    instance;
    
    private Hashtable<String, Typeface> fontCache;

    public Typeface getTypeFace(String name, Context context) {
        Typeface tf = this.fontCache.get(name);
        if (tf != null) {
            return tf;
        }
        try {
            Typeface tf2 = Typeface.createFromAsset(context.getAssets(), name);
            this.fontCache.put(name, tf2);
            return tf2;
        } catch (Exception e) {
            return null;
        }
    }
}
