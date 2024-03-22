package es.santander.justicia.minisJusticia.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.ActivityContratos;
import es.santander.justicia.minisJusticia.adapters.AdapterContratos.1;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail;
import java.util.List;

public class AdapterContratos extends AdapterAbstractRecycler<ContratoDetail> {
   public AdapterContratos(ActivityContratos activityContratos, List<ContratoDetail> listContratos) {
      super(activityContratos, activityContratos, listContratos);
      this.mListItems = listContratos;
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      return new es.santander.justicia.minisJusticia.adapters.AdapterContratos.ViewHolder(this, LayoutInflater.from(this.mContext).inflate(2131558506, parent, false));
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterContratos.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterContratos.ViewHolder)abstractHolder;
      holder.textDoc.setText(((ContratoDetail)this.getItem(position)).getCodDocumento());
      holder.textName.setText(((ContratoDetail)this.getItem(position)).getAlias());
      holder.textCode.setText(((ContratoDetail)this.getItem(position)).getContrato().getLoginUnicoCentro().getEmpresa() + ((ContratoDetail)this.getItem(position)).getContrato().getLoginUnicoCentro().getCentro() + ((ContratoDetail)this.getItem(position)).getContrato().getProducto() + ((ContratoDetail)this.getItem(position)).getContrato().getNumeroDeContrato());
      holder.cardView.setOnClickListener(new 1(this, position));
   }
}
