package es.santander.branchlocator;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class BLAutoCompleteTextViewBase extends AppCompatAutoCompleteTextView {
    private static final int DEFAULT_AUTOCOMPLETE_DELAY = 750;
    private static final int MESSAGE_TEXT_CHANGED = 100;
    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            BLAutoCompleteTextViewBase.super.performFiltering((CharSequence) msg.obj, msg.arg1);
        }
    };

    public BLAutoCompleteTextViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void performFiltering(CharSequence text, int keyCode) {
        this.handler.removeMessages(100);
        Handler handler2 = this.handler;
        handler2.sendMessageDelayed(handler2.obtainMessage(100, text), 750);
    }

    public void onFilterComplete(int count) {
        BLAutoCompleteTextViewBase.super.onFilterComplete(count);
    }
}
