package es.santander.justicia.minisJusticia.tasks;

import android.util.SparseArray;
import android.widget.AbsListView;

public class ListViewScrollTracker {
    private AbsListView mListView;
    private SparseArray<Integer> mPositions;

    public ListViewScrollTracker(AbsListView listView) {
        this.mListView = listView;
    }

    public int calculateIncrementalOffset(int firstVisiblePosition, int visibleItemCount) {
        SparseArray<Integer> previousPositions = this.mPositions;
        this.mPositions = new SparseArray<>();
        for (int i = 0; i < visibleItemCount; i++) {
            this.mPositions.put(firstVisiblePosition + i, Integer.valueOf(this.mListView.getChildAt(i).getTop()));
        }
        if (previousPositions == null) {
            return 0;
        }
        for (int i2 = 0; i2 < previousPositions.size(); i2++) {
            int position = previousPositions.keyAt(i2);
            int previousTop = previousPositions.get(position).intValue();
            Integer newTop = this.mPositions.get(position);
            if (newTop != null) {
                return newTop.intValue() - previousTop;
            }
        }
        return 0;
    }

    public void clear() {
        this.mPositions = null;
    }
}
