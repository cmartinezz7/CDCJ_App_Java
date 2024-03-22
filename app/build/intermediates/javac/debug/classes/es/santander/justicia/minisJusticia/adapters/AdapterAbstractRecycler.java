package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;

public abstract class AdapterAbstractRecycler<T> extends Adapter<ViewHolderAbstract> {
   protected es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener mListener;
   protected List<T> mListItems;
   protected Context mContext;

   public AdapterAbstractRecycler(Context context, es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener listener, List<T> listNews) {
      this.mListItems = listNews;
      this.mContext = context;
      this.mListener = listener;
   }

   public int getItemCount() {
      return this.mListItems != null ? this.mListItems.size() : 0;
   }

   protected T getItem(int position) {
      return this.mListItems.get(position);
   }

   public void setItems(ArrayList<T> items) {
      this.mListItems = items;
      this.notifyDataSetChanged();
   }

   public List<T> getAllItems() {
      return this.mListItems;
   }
}
