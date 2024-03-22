package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.1;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterSearchTribunal extends AdapterAbstractRecycler<DatosJuzgado> {
   public AdapterSearchTribunal(Context context, List<DatosJuzgado> listNews) {
      super(context, (OnRecyclerClickListener)context, listNews);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = null;
      v = LayoutInflater.from(this.mContext).inflate(2131558515, parent, false);
      return new es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder)abstractHolder;
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder.access$000(holder).setOnClickListener(new 1(this, position));
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder.access$100(holder).setText(CommonUtils.wordCapitalize(((DatosJuzgado)this.getItem(position)).getNombreOrganismo()));
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder.access$200(holder).setText(CommonUtils.wordCapitalize(((DatosJuzgado)this.getItem(position)).getEntornoJudicial()));
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder.access$300(holder).setText(((DatosJuzgado)this.getItem(position)).getEstado());
      es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal.ViewHolder.access$400(holder).setText(CommonUtils.wordCapitalize(((DatosJuzgado)this.getItem(position)).getProvincia()));
   }
}
