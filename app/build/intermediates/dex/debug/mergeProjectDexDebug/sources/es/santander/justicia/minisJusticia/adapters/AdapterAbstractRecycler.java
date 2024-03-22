package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class AdapterAbstractRecycler<T> extends RecyclerView.Adapter<ViewHolderAbstract> {
    protected Context mContext;
    protected List<T> mListItems;
    protected OnRecyclerClickListener mListener;

    public interface OnRecyclerClickListener {
        void onItemClickListener(int i);
    }

    public AdapterAbstractRecycler(Context context, OnRecyclerClickListener listener, List<T> listNews) {
        this.mListItems = listNews;
        this.mContext = context;
        this.mListener = listener;
    }

    public int getItemCount() {
        List<T> list = this.mListItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public T getItem(int position) {
        return this.mListItems.get(position);
    }

    public void setItems(ArrayList<T> items) {
        this.mListItems = items;
        notifyDataSetChanged();
    }

    public List<T> getAllItems() {
        return this.mListItems;
    }
}
