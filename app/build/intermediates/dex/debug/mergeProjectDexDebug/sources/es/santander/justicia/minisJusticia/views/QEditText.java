package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import es.santander.justicia.R;

public class QEditText extends EditText {
    public QEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public QEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 16842862);
    }

    public QEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            QStyle.style(this, attrs, 16842862, defStyleAttr);
            initAttr(attrs);
        }
        setLongClickable(false);
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.q_QEditText);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if (attr == 0) {
                setHint(a.getString(attr));
            } else if (attr == 1) {
                setText(a.getString(attr));
            }
        }
        a.recycle();
    }
}
