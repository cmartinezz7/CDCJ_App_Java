package es.santander.branchlocator;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

class BLTouchableWrapper extends FrameLayout {
    private static final long SCROLL_TIME = 100;
    private long lastTouched = 0;
    private UpdateMapAfterUserInterection updateMapAfterUserInterection;

    public interface UpdateMapAfterUserInterection {
        void onUpdateMapAfterUserInterection();
    }

    public BLTouchableWrapper(Context context) {
        super(context);
        try {
            this.updateMapAfterUserInterection = (UpdateMapAfterUserInterection) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement UpdateMapAfterUserInterection");
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == 0) {
            this.lastTouched = SystemClock.uptimeMillis();
        } else if (action == 1 && SystemClock.uptimeMillis() - this.lastTouched > SCROLL_TIME) {
            this.updateMapAfterUserInterection.onUpdateMapAfterUserInterection();
        }
        return super.dispatchTouchEvent(ev);
    }
}
