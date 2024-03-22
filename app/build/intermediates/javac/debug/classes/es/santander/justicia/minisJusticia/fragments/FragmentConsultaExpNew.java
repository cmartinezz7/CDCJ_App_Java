package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnActivarClick;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnExpandClick;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.1;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.2;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.3;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.4;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.5;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.6;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew.7;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.BuscExpResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;
import retrofit2.Call;

public class FragmentConsultaExpNew extends FragmentAbstractListados<DatosExpedienteNew> implements OnActivarClick, OnExpandClick, DialogSolicitudCalback {
   private AdapterConsultaExp mAdapterConsultaExp;
   private final int RQ_SEARCH = 1;
   private Call<BuscExpResponseEnvelope> mCallBuscarExp;

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/consulta_expediente");
   }

   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == -1) {
         this.getExpedients(data.getStringExtra("extra_juzga"), data.getStringExtra("extra_juzgori"), data.getStringExtra("extra_jproced"), data.getStringExtra("extra_jnumexp"), data.getStringExtra("extra_janoapex"), data.getStringExtra("extra_moneda"), data.getStringExtra("extra_state"), data.getStringExtra("extra_desde") != null ? data.getStringExtra("extra_desde") : CommonUtils.getDateMonthAgo(), data.getStringExtra("extra_hasta") != null ? data.getStringExtra("extra_hasta") : CommonUtils.getCurrentDate(), data.getStringExtra("extra_tipo_seleccion"), false);
      }

   }

   protected void initUi(View view) {
      this.getExpedients(PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"), (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, CommonUtils.getDateMonthAgo(), CommonUtils.getCurrentDate(), (String)null, false);
      this.mFabSearch.setOnClickListener(new 1(this));
   }

   private void initAdapter() {
      this.mAdapterConsultaExp = new AdapterConsultaExp(this.getActivity(), this, this, this.mItems);
      this.mRecycler.setAdapter(this.mAdapterConsultaExp);
   }

   private void getExpedients(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String moneda, String state, String fechaDesde, String fechaHasta, String tipoSeleccion, boolean repeatCall) {
      if (!repeatCall) {
         this.mCallBuscarExp = ConnectionBuilder.getBuscarExpedientesCall(juzga, juzgori, jproced, jnumexp, janoapex, moneda, state, fechaDesde, fechaHasta, tipoSeleccion);
      }

      this.mCallBuscarExp.clone().enqueue(new 2(this, this.getActivity(), true, true));
   }

   private void getDetailExpediente(int position) {
      TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (expandir)");
      ConnectionBuilder.getDetalleExpCall((DatosExpedienteNew)this.mItems.get(position)).enqueue(new 3(this, this.getActivity(), true, true, position));
   }

   private void activarExpediente(String anoAperturaExpediente, String numeroExpediente, String codigoJuzgadoDestino, String codigoJuzgadoOrigen, String codigoProcedimiento, String codigoExpediente, String codigoMoneda, String firma) {
      TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (activar)");
      ConnectionBuilder.getActivarExpedienteCall(anoAperturaExpediente, numeroExpediente, codigoJuzgadoDestino, codigoJuzgadoOrigen, codigoProcedimiento, codigoExpediente, codigoMoneda, firma).enqueue(new 4(this, this.getActivity(), true, true));
   }

   private ArrayList<DatosExpedienteNew> getOrderExpedientes(ArrayList<DatosExpedienteNew> response) {
      ArrayList<DatosExpedienteNew> retValue = new ArrayList();
      ArrayList<DatosExpedienteNew> auxLeters = new ArrayList();
      ArrayList<DatosExpedienteNew> auxNormal = new ArrayList();
      Pattern chars = Pattern.compile("[a-zA-Z]+");
      Iterator var6 = response.iterator();

      while(var6.hasNext()) {
         DatosExpedienteNew datosExpedienteNew = (DatosExpedienteNew)var6.next();
         if (chars.matcher(datosExpedienteNew.getCodExpediente()).find()) {
            auxLeters.add(datosExpedienteNew);
         } else {
            auxNormal.add(datosExpedienteNew);
         }
      }

      Collections.sort(auxLeters, new 5(this));
      retValue.addAll(auxLeters);
      Collections.sort(auxNormal, new 6(this));
      retValue.addAll(auxNormal);
      return retValue;
   }

   public void onOperativaClicked(String motive, String pass, int textIdResource, int position) {
      Log.d("Silos", motive == null ? "motive null" : motive);
      Log.d("Silos", pass == null ? "pass null" : pass);
   }

   public void onItemClickListener(int position, int oldPosition) {
      int childsRemoved = 0;
      if (oldPosition != -1) {
         for(boolean removing = true; removing; removing = oldPosition < this.mItems.size() && ((DatosExpedienteNew)this.mItems.get(oldPosition)).isChild()) {
            if (((DatosExpedienteNew)this.mItems.get(oldPosition)).isChild()) {
               this.mItems.remove(oldPosition);
               ++childsRemoved;
            }
         }

         ((DatosExpedienteNew)this.mItems.get(oldPosition - childsRemoved)).setExpanded(false);
         this.mAdapterConsultaExp.notifyDataSetChanged();
      }

      if (position + 1 != oldPosition) {
         if (position + 1 > oldPosition) {
            ((DatosExpedienteNew)this.mItems.get(position - childsRemoved)).setExpanded(true);
            if (oldPosition != -1 && position != oldPosition) {
               ((DatosExpedienteNew)this.mItems.get(oldPosition)).setExpanded(true);
            }

            this.getDetailExpediente(position - childsRemoved);
         } else {
            ((DatosExpedienteNew)this.mItems.get(position)).setExpanded(true);
            this.getDetailExpediente(position);
         }
      } else {
         ((DatosExpedienteNew)this.mItems.get(position)).setExpanded(false);
         this.mAdapterConsultaExp.setExpandedCard(-1);
      }

   }

   public void onActivarClickListener(int position) {
      CommonUtils.showOperativaPopUp(this.getActivity(), this.getView(), new 7(this), false, 2131886114, position);
   }

   // $FF: synthetic method
   static ArrayList access$000(FragmentConsultaExpNew x0, ArrayList x1) {
      return x0.getOrderExpedientes(x1);
   }

   // $FF: synthetic method
   static void access$100(FragmentConsultaExpNew x0) {
      x0.initAdapter();
   }

   // $FF: synthetic method
   static AdapterConsultaExp access$200(FragmentConsultaExpNew x0) {
      return x0.mAdapterConsultaExp;
   }

   // $FF: synthetic method
   static void access$300(FragmentConsultaExpNew x0, String x1, String x2, String x3, String x4, String x5, String x6, String x7, String x8, String x9, String x10, boolean x11) {
      x0.getExpedients(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11);
   }

   // $FF: synthetic method
   static void access$400(FragmentConsultaExpNew x0, String x1, String x2, String x3, String x4, String x5, String x6, String x7, String x8) {
      x0.activarExpediente(x1, x2, x3, x4, x5, x6, x7, x8);
   }
}
