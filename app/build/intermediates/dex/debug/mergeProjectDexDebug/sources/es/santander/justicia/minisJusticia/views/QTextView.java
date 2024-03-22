package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import es.santander.justicia.R;

public class QTextView extends AppCompatTextView {
    public QTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public QTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.views.QTextView, android.widget.TextView] */
    public QTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            QStyle.style(this, attrs, 16842884, defStyleAttr);
            initAttr(attrs);
        }
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.q_QTextView);
        for (int i = 0; i < a.getIndexCount(); i++) {
            if (a.getIndex(i) == 1) {
                String str = a.getString(1);
                if (!isInEditMode() && !TextUtils.isEmpty(str)) {
                    setText(str);
                }
            }
        }
        a.recycle();
    }
}
