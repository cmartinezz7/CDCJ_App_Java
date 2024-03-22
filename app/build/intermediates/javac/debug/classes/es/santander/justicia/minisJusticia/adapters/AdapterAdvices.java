package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterAdvices.1;
import es.santander.justicia.minisJusticia.models.responses.avisos.Avisos;
import java.util.List;

public class AdapterAdvices extends AdapterAbstractRecycler<Avisos> {
   public AdapterAdvices(Context context, OnRecyclerClickListener listener, List<Avisos> listaAdvices) {
      super(context, listener, listaAdvices);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = null;
      v = LayoutInflater.from(this.mContext).inflate(2131558497, parent, false);
      return new es.santander.justicia.minisJusticia.adapters.AdapterAdvices.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterAdvices.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterAdvices.ViewHolder)abstractHolder;
      es.santander.justicia.minisJusticia.adapters.AdapterAdvices.ViewHolder.access$000(holder).setText(((Avisos)this.getItem(position)).getDesAviso());
      es.santander.justicia.minisJusticia.adapters.AdapterAdvices.ViewHolder.access$000(holder).setOnClickListener(new 1(this, position));
   }
}
