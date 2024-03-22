package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion.1;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion.2;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion.3;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion.4;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.AltaAutorizationArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.DatosAutorizacion;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityAltaAutorizacion extends ActivityAbstractBusqueda implements DialogSolicitudCalback, PopUpActionDone {
   private Spinner mSpinnerDocType;
   private String docType;
   private TextView textViewDateFrom;
   private TextView textViewDateTo;
   private String caducadas = "0";

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558431);
      this.getWindow().setSoftInputMode(2);
      this.textViewDateFrom = (TextView)this.findViewById(2131362880);
      this.textViewDateTo = (TextView)this.findViewById(2131362882);
      this.textViewDateFrom.setText(CommonUtils.getCurrentDateToShow());
      this.textViewDateTo.setText(CommonUtils.getDateNextMonthToShow());
      if (this.getIntent().getExtras() != null && this.getIntent().getExtras().getString("extra_search") != null) {
         this.findViewById(2131362396).setVisibility(0);
         ((TextView)this.findViewById(2131362869)).setText(this.getString(2131886741));
         ((TextView)this.findViewById(2131362815)).setText(this.getString(2131886130));
      } else {
         ((TextView)this.findViewById(2131362815)).setText(this.getString(2131886129));
         ((TextView)this.findViewById(2131362869)).setText(this.getString(2131886648));
      }

      this.defineListeners();
      this.initUi();
      this.getDetalleJuzgado(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
   }

   protected void defineSpinners() {
      this.mSpinnerDocType = (Spinner)this.findViewById(2131362741);
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnDocumentTypeForLetrados"));
      arrayAdapterSeleccion.setDropDownViewResource(2131558753);
      this.mSpinnerDocType.setAdapter(arrayAdapterSeleccion);
      this.mSpinnerDocType.setOnItemSelectedListener(new 1(this));
   }

   protected void defineListeners() {
      this.findViewById(2131362867).setOnClickListener(new 2(this));
   }

   private void returnResult(AuthJuzgadosArg0Detail authJuzgadosArg0Detail) {
      Intent intent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putSerializable("extra_autorization", authJuzgadosArg0Detail);
      intent.putExtras(bundle);
      this.setResult(-1, intent);
      this.finish();
   }

   protected void buscarClick() {
      if (CommonUtils.validateDocumentNumber(this, this.docType, (EditText)this.findViewById(2131362116))) {
         if (((TextView)this.findViewById(2131362869)).getText().toString().equals(this.getString(2131886741))) {
            AuthJuzgadosArg0Detail authJuzgadosArg0Detail = new AuthJuzgadosArg0Detail();
            authJuzgadosArg0Detail.setIndCaducadas(this.caducadas);
            if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateTo.getText().toString())) {
               authJuzgadosArg0Detail.setFechaFinal(DateUtils.formatDateToRequest(this.textViewDateTo.getText().toString()));
            }

            if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateFrom.getText().toString())) {
               authJuzgadosArg0Detail.setFechaInicial(DateUtils.formatDateToRequest(this.textViewDateFrom.getText().toString()));
            }

            if (CommonUtils.isNotNullNotBlackNotStringNull(((EditText)this.findViewById(2131362116)).getText().toString())) {
               authJuzgadosArg0Detail.setCodNumDocumento(((EditText)this.findViewById(2131362116)).getText().toString().toUpperCase());
            }

            authJuzgadosArg0Detail.setCodTipoDocumento(this.docType);
            this.returnResult(authJuzgadosArg0Detail);
         } else if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateFrom.getText().toString()) && CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateTo.getText().toString())) {
            CommonUtils.showOperativaPopUp(this, this.findViewById(16908290), this, false, 2131886345, 0);
         }
      }

   }

   private void showInfo(DatosJuzgado datosJuzgado) {
      ((TextView)this.findViewById(2131362844)).setText(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
      ((TextView)this.findViewById(2131362851)).setText(datosJuzgado.getEntornoJudicial());
      ((TextView)this.findViewById(2131362853)).setText(datosJuzgado.getTelefono1());
      String address = datosJuzgado.getTipoVia() + " " + datosJuzgado.getNombreVia() + " " + (datosJuzgado.getNumero() != null ? datosJuzgado.getNumero() : " ") + " " + datosJuzgado.getProvincia() + "  " + datosJuzgado.getCodpost();
      ((TextView)this.findViewById(2131362845)).setText(address);
   }

   private void buildAltaRequest(String firma, String fechaIni, String fechaFin) {
      AltaAutorizationArg0Detail altaAutorizationArg0Detail = new AltaAutorizationArg0Detail();
      altaAutorizationArg0Detail.setFirma(firma);
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this);
      EditText editDocument = (EditText)this.findViewById(2131362116);
      altaAutorizationArg0Detail.setDatosAutorizacion(new DatosAutorizacion(editDocument.getText().toString().toUpperCase(), preferencesHelper.getString("preference_cod_uo"), fechaIni, fechaFin, this.docType));
      this.makeAlta(altaAutorizationArg0Detail);
   }

   private void getDetalleJuzgado(String juzga) {
      ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new 3(this, this));
   }

   public void makeAlta(AltaAutorizationArg0Detail altaAutorizationArg0Detail) {
      ConnectionBuilder.altaAutorizacion(altaAutorizationArg0Detail).enqueue(new 4(this, this));
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      this.buildAltaRequest(pass, DateUtils.formatDateToRequest(this.textViewDateFrom.getText().toString()), DateUtils.formatDateToRequest(this.textViewDateTo.getText().toString()));
   }

   public void onPopUpClosed() {
   }

   // $FF: synthetic method
   static String access$002(ActivityAltaAutorizacion x0, String x1) {
      return x0.docType = x1;
   }

   // $FF: synthetic method
   static void access$100(ActivityAltaAutorizacion x0, AuthJuzgadosArg0Detail x1) {
      x0.returnResult(x1);
   }

   // $FF: synthetic method
   static void access$200(ActivityAltaAutorizacion x0, DatosJuzgado x1) {
      x0.showInfo(x1);
   }
}
