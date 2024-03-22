package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts.1;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.utils.DateUtils;
import java.util.List;

public class AdapterAuthCourts extends AdapterAbstractRecycler<AutorizacionesUsuario> {
   public AdapterAuthCourts(Context context, OnRecyclerClickListener listener, List<AutorizacionesUsuario> listOperaciones) {
      super(context, listener, listOperaciones);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      return new es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts.ViewHolder(this, LayoutInflater.from(this.mContext).inflate(2131558498, parent, false));
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts.ViewHolder)abstractHolder;
      holder.textName.setText(((AutorizacionesUsuario)this.getItem(position)).getNombre() + " " + ((AutorizacionesUsuario)this.getItem(position)).getApellido1());
      holder.textInitDate.setText(DateUtils.formatDate(((AutorizacionesUsuario)this.getItem(position)).getFechaInicial(), "yyyy-MM-dd HH:mm:ss"));
      holder.textFinDate.setText(DateUtils.formatDate(((AutorizacionesUsuario)this.getItem(position)).getFechaFinal(), "yyyy-MM-dd HH:mm:ss"));
      holder.textProfile.setText(((AutorizacionesUsuario)this.getItem(position)).getPerfil());
      holder.cardView.setOnClickListener(new 1(this, position));
   }
}
