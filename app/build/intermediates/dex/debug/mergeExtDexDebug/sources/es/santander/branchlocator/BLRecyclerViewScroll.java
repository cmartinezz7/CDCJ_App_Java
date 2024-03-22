package es.santander.branchlocator;

import androidx.recyclerview.widget.RecyclerView;

class BLRecyclerViewScroll extends RecyclerView.OnScrollListener {
    private BLOnHorizontalScroll BLOnHorizontalScroll;
    private int overallXScroll = 0;

    public BLRecyclerViewScroll(BLOnHorizontalScroll BLOnHorizontalScroll2) {
        this.BLOnHorizontalScroll = BLOnHorizontalScroll2;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState != 0) {
            if (newState == 2 && this.overallXScroll == 0) {
                this.BLOnHorizontalScroll.onNoScroll();
            }
        } else if (this.overallXScroll == 0) {
            this.BLOnHorizontalScroll.onNoScroll();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        int i = this.overallXScroll + dx;
        this.overallXScroll = i;
        if (dx > 0) {
            this.BLOnHorizontalScroll.onScrolling();
        } else if (dx < 0 && i > 0) {
            this.BLOnHorizontalScroll.onScrolling();
        }
    }
}
