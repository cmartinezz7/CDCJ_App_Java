package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.fragments.FragmentAuhtJuzgados.1;
import es.santander.justicia.minisJusticia.fragments.FragmentAuhtJuzgados.2;
import es.santander.justicia.minisJusticia.fragments.FragmentAuhtJuzgados.3;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.Serializable;

public class FragmentAuhtJuzgados extends FragmentAbstractListados<AutorizacionesUsuario> implements OnRecyclerClickListener {
   private static final int RQ_SEARCH = 32;
   private static final int RQ_MODIFY = 33;

   protected void initUi(View view) {
      this.setButtons();
      this.getDefaultExpedients();
   }

   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == -1) {
         switch(requestCode) {
         case 32:
            if (data.getExtras().getSerializable("extra_autorization") != null) {
               AuthJuzgadosArg0Detail authJuzgadosArg0Detail = (AuthJuzgadosArg0Detail)data.getExtras().getSerializable("extra_autorization");
               this.getExpedients(authJuzgadosArg0Detail.getCodNumDocumento(), PreferencesHelper.newInstance(this.getContext()).getString("preference_cod_uo"), authJuzgadosArg0Detail.getCodTipoDocumento(), authJuzgadosArg0Detail.getFechaFinal(), authJuzgadosArg0Detail.getFechaInicial(), authJuzgadosArg0Detail.getIndCaducadas());
            }
            break;
         case 33:
            this.getDefaultExpedients();
         }
      }

   }

   private void getDefaultExpedients() {
      this.getExpedients("", PreferencesHelper.newInstance(this.getContext()).getString("preference_cod_uo"), "N", DateUtils.formatDateToRequest(CommonUtils.getDateNextMonthToShow()), DateUtils.formatDateToRequest(CommonUtils.getCurrentDateToShow()), "0");
   }

   private void setButtons() {
      this.mFabSearch.setOnClickListener(new 1(this));
      this.mButtonNew.setVisibility(0);
      this.mButtonNew.setOnClickListener(new 2(this));
   }

   private void getExpedients(String docuemnt, String organismo, String tipoDoc, String fechaFinal, String fechaInicial, String caducadas) {
      ConnectionBuilder.getAutorizacionesJuzagado(docuemnt, organismo, tipoDoc, fechaFinal, fechaInicial, caducadas).clone().enqueue(new 3(this, this.getActivity()));
   }

   public void onItemClickListener(int position) {
      Intent intent = new Intent(this.getActivity(), ActivityDetalleAuthorizacion.class);
      Bundle bundle = new Bundle();
      bundle.putSerializable("extra_autorization", (Serializable)this.mItems.get(position));
      intent.putExtras(bundle);
      this.startActivityForResult(intent, 33);
   }
}
