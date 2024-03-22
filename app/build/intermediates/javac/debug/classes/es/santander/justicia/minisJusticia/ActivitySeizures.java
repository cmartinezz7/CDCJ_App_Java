package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.minisJusticia.ActivitySeizures.1;
import es.santander.justicia.minisJusticia.ActivitySeizures.2;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.OnBajaClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.seizures.Embargo;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoDetail;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoResponseEnvelope;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;

public class ActivitySeizures extends ActivityAbstractLetrados implements OnBajaClickListener, DialogSolicitudCalback, PopUpActionDone {
   private final int RQ_BUSQUEDA = 11;
   private RecyclerView mRecycler;
   private ArrayList<Embargo> mListSeizures;
   private Call<EmbargoResponseEnvelope> mCallEmbargos;
   private RelativeLayout mRelativeNoresults;
   private FloatingActionButton mFabButton;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558442);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/embargos");
   }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == -1) {
         this.getEmbargos(data.getStringExtra("extra_juzgori"), data.getStringExtra("extra_jproced"), data.getStringExtra("extra_janoapex"), data.getStringExtra("extra_jnumexp"), data.getStringExtra("extra_importe_desde"), data.getStringExtra("extra_importe_hasta"), data.getStringExtra("extra_desde"), data.getStringExtra("extra_hasta"), data.getStringExtra("extra_tipo_embargo"), data.getStringExtra("extra_estado_embargo"), false);
      }

   }

   private void initUi() {
      ((QTextView)this.findViewById(2131362928)).setText(this.getString(2131886758));
      this.mRecycler = (RecyclerView)this.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(false);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
      this.mRelativeNoresults = (RelativeLayout)this.findViewById(2131362367);
      this.mFabButton = (FloatingActionButton)this.findViewById(2131362172);
      this.getEmbargos("", "", "", "", "", "", "", "", "", this.getIntent().getStringExtra("extra_estado_embargo"), false);
   }

   private void getEmbargos(String juzgadoOrigenExp, String procedimientoExp, String anoAperturaExpediente, String numeroExp, String importeEmbargadoDesde, String importeEmbargadoHasta, String fechaDesde, String fechaHasta, String codigoTipoEmbargo, String codigoEstado, boolean repeatCall) {
      if (!repeatCall) {
         this.mCallEmbargos = ConnectionBuilder.getEmbargos(PreferencesHelper.newInstance(this).getString("preference_cod_uo"), juzgadoOrigenExp, procedimientoExp, anoAperturaExpediente, numeroExp, importeEmbargadoDesde, importeEmbargadoHasta, fechaDesde, fechaHasta, codigoTipoEmbargo, codigoEstado);
      }

      this.mCallEmbargos.clone().enqueue(new 1(this, this, true, true));
   }

   private void bajaEmbargo(String codUniOrg, String numEmbargo, String firma, String observ) {
      ConnectionBuilder.getBajaEmbargoCall(codUniOrg, numEmbargo, firma, observ).enqueue(new 2(this, this, true, true));
   }

   private void buildMebargosDetail() {
      int datosPaginacinIndex = -1;
      int count = 0;
      Iterator var3 = this.mListSeizures.iterator();

      while(var3.hasNext()) {
         Embargo embargo = (Embargo)var3.next();
         if (embargo.getNumeroEmbargo() == null) {
            datosPaginacinIndex = count;
         }

         ++count;
         embargo.addEmbargoDetails(new EmbargoDetail(embargo.getNombrePersonaEmbargo() + " " + (CommonUtils.isNotNullNotBlackNotStringNull(embargo.getApellido1PersonaEmbargo()) ? embargo.getApellido1PersonaEmbargo() : "") + " " + (CommonUtils.isNotNullNotBlackNotStringNull(embargo.getApellido2PersonaEmbargo()) ? embargo.getApellido2PersonaEmbargo() : ""), embargo.getImporteTotalEmbargo(), embargo.getCodigoDocumentoIdentidad()));
      }

      if (datosPaginacinIndex != -1) {
         this.mListSeizures.remove(datosPaginacinIndex);
      }

      this.mRecycler.setAdapter(new AdapterExpaSeizures(this, this.mListSeizures));
   }

   public void onFabClick(View v) {
      Intent intent = new Intent(this, ActivityBusquedaEmbargos.class);
      this.startActivityForResult(intent, 11);
   }

   public void onBajaClick(int position) {
      CommonUtils.showOperativaPopUp(this, this.mRecycler, this, false, 2131886711, position);
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      this.bajaEmbargo(((Embargo)this.mListSeizures.get(position)).getCodigoJuzgadoDestino(), ((Embargo)this.mListSeizures.get(position)).getNumeroEmbargo(), pass, (String)null);
   }

   public void onPopUpClosed() {
      this.getEmbargos((String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, true);
   }

   // $FF: synthetic method
   static ArrayList access$002(ActivitySeizures x0, ArrayList x1) {
      return x0.mListSeizures = x1;
   }

   // $FF: synthetic method
   static ArrayList access$000(ActivitySeizures x0) {
      return x0.mListSeizures;
   }

   // $FF: synthetic method
   static void access$100(ActivitySeizures x0) {
      x0.buildMebargosDetail();
   }

   // $FF: synthetic method
   static RelativeLayout access$200(ActivitySeizures x0) {
      return x0.mRelativeNoresults;
   }

   // $FF: synthetic method
   static FloatingActionButton access$300(ActivitySeizures x0) {
      return x0.mFabButton;
   }

   // $FF: synthetic method
   static RecyclerView access$400(ActivitySeizures x0) {
      return x0.mRecycler;
   }
}
