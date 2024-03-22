package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import java.util.List;

public class AdapterPendintOperations extends AdapterAbstractRecycler<String> {
   public AdapterPendintOperations(Context context, OnRecyclerClickListener listener, List<String> listNews) {
      super(context, listener, listNews);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = null;
      v = LayoutInflater.from(this.mContext).inflate(2131558512, parent, false);
      return new es.santander.justicia.minisJusticia.adapters.AdapterPendintOperations.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract holder, int position) {
   }
}
