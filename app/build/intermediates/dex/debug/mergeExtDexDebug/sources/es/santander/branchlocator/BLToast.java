package es.santander.branchlocator;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Toast;

class BLToast extends Toast {
    private int duration;
    /* access modifiers changed from: private */
    public boolean showing = false;

    public BLToast(Context context, int duration2) {
        super(context);
        this.duration = duration2;
    }

    public void setDuration(int seconds) {
        super.setDuration(0);
        if (seconds < 2) {
            seconds = 2;
        }
        this.duration = seconds;
    }

    public void show() {
        super.show();
        if (!this.showing) {
            this.showing = true;
            new CountDownTimer((long) ((this.duration - 2) * 1000), 1000) {
                public void onTick(long millisUntilFinished) {
                    this.show();
                }

                public void onFinish() {
                    this.show();
                    boolean unused = BLToast.this.showing = false;
                }
            }.start();
        }
    }
}
