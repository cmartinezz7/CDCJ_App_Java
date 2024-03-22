package es.santander.branchlocator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextView;

class BLTextView extends AppCompatTextView {
    public BLTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BLTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BLTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray ta;
        if (!isInEditMode() && (ta = context.obtainStyledAttributes(attrs, R.styleable.FontText)) != null) {
            String fontAsset = ta.getString(R.styleable.FontText_typefaceAsset);
            if (!TextUtils.isEmpty(fontAsset)) {
                Typeface tf = BLFontManager.getInstance(getContext()).getFont(fontAsset);
                int style = getTypeface() != null ? getTypeface().getStyle() : 0;
                if (tf != null) {
                    setTypeface(tf, style);
                } else {
                    Log.d("FontText", String.format("Could not create a font from asset: %s", new Object[]{fontAsset}));
                }
            }
        }
    }
}
