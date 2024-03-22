package es.santander.justicia.minisJusticia.views;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import es.santander.justicia.R;

public class QStyle {
    protected static void style(TextView v, AttributeSet attrs, int defAttr, int defStyleRef) {
        TypedArray a = v.getContext().obtainStyledAttributes(attrs, R.styleable.q_QTextView, defAttr, defStyleRef);
        String fontFileName = a.getString(2);
        if (fontFileName != null) {
            v.setTypeface(TypeFaceCache.instance.getTypeFace(fontFileName, v.getContext()));
        }
        a.recycle();
    }
}
