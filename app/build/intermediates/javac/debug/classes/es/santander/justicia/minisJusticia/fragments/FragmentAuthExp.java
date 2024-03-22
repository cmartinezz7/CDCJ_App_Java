package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.OnOthersClick;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.1;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.2;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.3;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.4;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.5;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.6;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.7;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.8;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.9;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscPetAccResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;

public class FragmentAuthExp extends FragmentAbstractListados<BuscarPeticionesAcceso> implements OnOthersClick, DialogSolicitudCalback, PopUpActionDone {
   private final int OPERATIVE_ACEPTAR = 1;
   private final int OPERATIVE_BAJA = 2;
   private final int OPERATIVE_DENEGAR = 3;
   private final int OPERATIVE_MODIFICAR = 4;
   private OnClickListener mOthersClickListener;
   private AdapterExpaAuthExpe mAdapterExpaAuthExpe;
   private int mCurrentItem;
   private static final int RQ_SEARCH = 1;
   private Call<BuscPetAccResponseEnvelope> mLasgGetExpedientesCall;

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/autorizacion_expediente");
   }

   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == -1) {
         this.getExpedients(data.getStringExtra("extra_juzga"), data.getStringExtra("extra_juzgori"), data.getStringExtra("extra_jproced"), data.getStringExtra("extra_jnumexp"), data.getStringExtra("extra_janoapex"), data.getStringExtra("extra_state"), false);
      }

   }

   protected void initUi(View view) {
      this.getExpedients(PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"), (String)null, (String)null, (String)null, (String)null, this.getArguments().getString("extra_filter", (String)null), false);
      this.mFabSearch.setOnClickListener(new 1(this));
   }

   private void initAdapter() {
      this.mAdapterExpaAuthExpe = new AdapterExpaAuthExpe(this.getActivity(), this.mItems, this);
      this.mAdapterExpaAuthExpe.setExpandCollapseListener(new 2(this));
      this.setOthersClickListener();
      this.mRecycler.setAdapter(this.mAdapterExpaAuthExpe);
   }

   private void getExpedients(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String state, boolean repeatLastConnection) {
      if (!repeatLastConnection) {
         this.mLasgGetExpedientesCall = ConnectionBuilder.getBuscPetCall(juzga, juzgori, jproced, jnumexp, janoapex, state);
      }

      this.mLasgGetExpedientesCall.clone().enqueue(new 3(this, this.getActivity(), true, true));
   }

   private void acceptSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
      TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (aceptar)");
      ConnectionBuilder.getAceptSoliCall(detallePetAcceDetail).enqueue(new 4(this, this.getActivity(), true, true));
   }

   private void denegarSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
      TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (denegar)");
      ConnectionBuilder.getDeniedSoliCall(detallePetAcceDetail).enqueue(new 5(this, this.getActivity(), true, true));
   }

   private void bajaSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
      TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (baja)");
      ConnectionBuilder.getBajaSoliCall(detallePetAcceDetail).enqueue(new 6(this, this.getActivity(), true, true));
   }

   private void modificarSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
      TealiumHelper.trackEvent("/autorizacion_cuenta_expediente", "modificar_solicitud");
      ConnectionBuilder.getModificarSoliCall(detallePetAcceDetail).enqueue(new 7(this, this.getActivity(), true, true));
   }

   private void getDetailSolicitud(String anioAp, String codDoc, String cdExp, String codTipDoc, String fechaReg, int nexOperation, String motivo, String pass) {
      ConnectionBuilder.getDetallePetAcc(anioAp, codDoc, cdExp, codTipDoc, fechaReg).enqueue(new 8(this, this.getActivity(), true, true, motivo, pass, nexOperation));
   }

   public void setOthersClickListener() {
      this.mOthersClickListener = new 9(this);
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      switch(textResource) {
      case 2131886705:
         this.getDetailSolicitud(((BuscarPeticionesAcceso)this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso)this.mItems.get(position)).getFecDeLaPeticion()), 1, motive, pass);
      case 2131886706:
      case 2131886708:
      case 2131886709:
      case 2131886710:
      case 2131886711:
      default:
         break;
      case 2131886707:
         this.getDetailSolicitud(((BuscarPeticionesAcceso)this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso)this.mItems.get(position)).getFecDeLaPeticion()), 2, motive, pass);
         break;
      case 2131886712:
         this.getDetailSolicitud(((BuscarPeticionesAcceso)this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso)this.mItems.get(position)).getFecDeLaPeticion()), 3, motive, pass);
         break;
      case 2131886713:
         this.getDetailSolicitud(((BuscarPeticionesAcceso)this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso)this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso)this.mItems.get(position)).getFecDeLaPeticion()), 4, motive, pass);
      }

      Log.d("Silos", motive == null ? "motive null" : motive);
      Log.d("Silos", pass == null ? "pass null" : pass);
   }

   public void onItemClickListener(int opeartive, int position) {
      this.mCurrentItem = position;
      switch(opeartive) {
      case 0:
         CommonUtils.showOperativaPopUp(this.getActivity(), this.getView(), this, true, 2131886705, position);
         break;
      case 1:
         CommonUtils.showOperativaPopUp(this.getActivity(), this.getView(), this, true, 2131886712, position);
         break;
      case 2:
         CommonUtils.showOperativaPopUp(this.getActivity(), this.getView(), this, false, 2131886707, position);
         break;
      case 3:
         CommonUtils.showOperativaPopUp(this.getActivity(), this.getView(), this, true, 2131886713, position);
         break;
      case 4:
         CommonUtils.showOptionsPopUp(this.getActivity(), this.getView(), this.mOthersClickListener);
      }

   }

   public void onPopUpClosed() {
      this.getExpedients((String)null, (String)null, (String)null, (String)null, (String)null, (String)null, true);
   }

   // $FF: synthetic method
   static AdapterExpaAuthExpe access$000(FragmentAuthExp x0) {
      return x0.mAdapterExpaAuthExpe;
   }

   // $FF: synthetic method
   static void access$100(FragmentAuthExp x0) {
      x0.initAdapter();
   }

   // $FF: synthetic method
   static void access$200(FragmentAuthExp x0, OperativasGlobalArg0Detail x1) {
      x0.acceptSolicitud(x1);
   }

   // $FF: synthetic method
   static void access$300(FragmentAuthExp x0, OperativasGlobalArg0Detail x1) {
      x0.denegarSolicitud(x1);
   }

   // $FF: synthetic method
   static void access$400(FragmentAuthExp x0, OperativasGlobalArg0Detail x1) {
      x0.bajaSolicitud(x1);
   }

   // $FF: synthetic method
   static void access$500(FragmentAuthExp x0, OperativasGlobalArg0Detail x1) {
      x0.modificarSolicitud(x1);
   }

   // $FF: synthetic method
   static int access$600(FragmentAuthExp x0) {
      return x0.mCurrentItem;
   }
}
