package es.santander.branchlocator;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

class BLLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public BLLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    public boolean canScrollVertically() {
        return this.isScrollEnabled && BLLayoutManager.super.canScrollVertically();
    }
}
