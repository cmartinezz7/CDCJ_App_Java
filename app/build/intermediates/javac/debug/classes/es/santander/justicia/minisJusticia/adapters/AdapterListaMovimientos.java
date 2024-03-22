package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos.1;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.DatosOperacion;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterListaMovimientos extends AdapterAbstractRecycler<DatosOperacion> {
   public AdapterListaMovimientos(Context context, List<DatosOperacion> listOperaciones) {
      super(context, (OnRecyclerClickListener)context, listOperaciones);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      return new es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos.ViewHolder(this, LayoutInflater.from(this.mContext).inflate(2131558511, parent, false));
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos.ViewHolder)abstractHolder;
      holder.textTypeMovement.setText(CommonUtils.capitalize(((DatosOperacion)this.getItem(position)).getDesctipomod()));
      holder.textId.setText(((DatosOperacion)this.getItem(position)).getSerieYMandamiento());
      holder.textDate.setText(CommonUtils.getDateFromExp(((DatosOperacion)this.getItem(position)).getJfechare()));
      holder.relativeGlobal.setOnClickListener(new 1(this, position));
      if (((DatosOperacion)this.getItem(position)).getJimpnomi() != null && !((DatosOperacion)this.getItem(position)).getJimpnomi().isEmpty()) {
         holder.imageSate.setVisibility(8);
         holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion)this.getItem(position)).getJimpnomi()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion)this.getItem(position)).getCodmon()));
         holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, ((DatosOperacion)this.getItem(position)).getJimpnomi().startsWith("-") ? 2131100022 : 2131100023));
         holder.textState.setVisibility(8);
      } else if (((DatosOperacion)this.getItem(position)).getJimppend() != null && !((DatosOperacion)this.getItem(position)).getJimppend().isEmpty()) {
         holder.imageSate.setVisibility(0);
         holder.imageSate.setImageResource(2131231140);
         holder.imageSate.setColorFilter(ContextCompat.getColor(this.mContext, 2131100019));
         holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion)this.getItem(position)).getJimppend()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion)this.getItem(position)).getCodmon()));
         holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, 2131100019));
         holder.textState.setVisibility(0);
         holder.textState.setText(this.mContext.getString(2131886598));
         holder.textState.setTextColor(ContextCompat.getColor(this.mContext, 2131100019));
      } else if (((DatosOperacion)this.getItem(position)).getJimpcaduca() != null && !((DatosOperacion)this.getItem(position)).getJimpcaduca().isEmpty()) {
         holder.imageSate.setVisibility(0);
         holder.imageSate.setImageResource(2131231049);
         holder.imageSate.setColorFilter(ContextCompat.getColor(this.mContext, 2131100947));
         holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion)this.getItem(position)).getJimpcaduca()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion)this.getItem(position)).getCodmon()));
         holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, 2131100005));
         holder.textState.setVisibility(0);
         holder.textState.setText(this.mContext.getString(2131886592));
         holder.textState.setTextColor(ContextCompat.getColor(this.mContext, 2131100005));
      }

   }
}
