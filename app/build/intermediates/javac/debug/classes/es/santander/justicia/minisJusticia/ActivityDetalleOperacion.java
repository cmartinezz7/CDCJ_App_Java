package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.1;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.2;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.3;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.4;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.5;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.6;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion.7;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.OnOperativeClicked;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperDatosExpediente;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperDatosOperacion;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsuOperResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import retrofit2.Call;

public class ActivityDetalleOperacion extends ActivityAbstractLetrados implements OnRecyclerClickListener, OnOperativeClicked, DialogSolicitudCalback {
   public static final int OPERATIVE_ANULAR = 1;
   public static final int OPERATIVE_FIRMAR = 2;
   public static final String CODIGO_ESTADO_A = "A";
   public static final String CODIGO_ESTADO_I = "I";
   public static final String CODIGO_ESTADO_F = "F";
   public static final String CODIGO_ESTADO_P = "P";
   public static final String COD_TRANSFERENCIA_XE = "XE";
   public static final String COD_TRASPASO_TE = "TE";
   public static final String COD_TRASPASO_TR = "TR";
   public static final String COD_TRASPASO_TT = "TT";
   public static final String COD_TRANSF_RECIBIDA = "XR";
   private RecyclerView mRecycler;
   private ArrayList<ConsultaOperaciones> mItems;
   private Call<ConsuOperResponseEnvelope> mLastCallConsultOper;
   private RelativeLayout mRelativeNoResults;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558447);
      this.initUi();
   }

   private void initUi() {
      this.findViewById(2131362172).setVisibility(0);
      ((QTextView)this.findViewById(2131362929)).setText(this.getIntent().hasExtra("extra_operacion_seleccionada") ? this.getString(2131886585) : this.getString(2131886584));
      this.findViewById(2131362172).setVisibility(8);
      this.mRelativeNoResults = (RelativeLayout)this.findViewById(2131362367);
      this.findViewById(2131361975).setOnClickListener(new 1(this));
      this.mRecycler = (RecyclerView)this.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(true);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
      this.getOperacion(this.getIntent().getStringExtra("extra_juzdestino"), this.getIntent().getStringExtra("extra_moneda"), this.getIntent().getStringExtra("extra_operacion"), this.getIntent().getStringExtra("extra_operacion_seleccionada"), this.getFechaInicio(this.getIntent().getStringExtra("extra_operacion_seleccionada")), false);
   }

   private String getFechaInicio(String tipoOper) {
      if (tipoOper != null) {
         byte var3 = -1;
         switch(tipoOper.hashCode()) {
         case 279896340:
            if (tipoOper.equals("CONFIRMACIONES")) {
               var3 = 1;
            }
            break;
         case 992482274:
            if (tipoOper.equals("INGRESOS")) {
               var3 = 2;
            }
            break;
         case 1993158816:
            if (tipoOper.equals("COBROS")) {
               var3 = 0;
            }
         }

         switch(var3) {
         case 0:
            return CommonUtils.getDateFourMonthsAgo();
         case 1:
            return CommonUtils.getDateFromFristDayOfTheYear();
         case 2:
            return CommonUtils.getDateSevenMonthsAgo();
         }
      }

      return CommonUtils.getDateWeekAgo();
   }

   private void getOperacion(String juzgadoDestion, String moneda, String operacion, String operSelacionada, String fechaInicio, boolean repeatLastCall) {
      if (!repeatLastCall) {
         this.mLastCallConsultOper = ConnectionBuilder.getConsultaOperacionCall(juzgadoDestion, moneda, operacion, operSelacionada, fechaInicio);
      }

      this.mLastCallConsultOper.clone().enqueue(new 2(this, this, true, true, operSelacionada));
   }

   private void getMoveDetail(String numOper, String juzga, int position) {
      ConnectionBuilder.getDetalleMovimientoCall(numOper, juzga).enqueue(new 3(this, this, true, true, position));
   }

   private void getAnularOpPteCobro(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
      ConnectionBuilder.getAnularOpPteCobrCall(datosOperacion, firma, motivoAnulacion).enqueue(new 4(this, this, true, true));
   }

   private void getAnularOpPteConfir(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
      ConnectionBuilder.getAnularOpPteConfirmacion(datosOperacion, firma, motivoAnulacion).enqueue(new 5(this, this, true, true));
   }

   private void getAnularOpPteIngres(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
      ConnectionBuilder.getAnularOpPteIngreso(datosOperacion, firma, motivoAnulacion).enqueue(new 6(this, this, true, true));
   }

   private void getConfOpPteConf(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
      TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (firmar)");
      ConnectionBuilder.getConfirmOpPteConfir(datosOperacion, firma, motivoAnulacion).enqueue(new 7(this, this, true, true));
   }

   private void handleResultsVisibility() {
      if (this.mItems != null && !this.mItems.isEmpty()) {
         this.mRecycler.setVisibility(0);
         this.mRelativeNoResults.setVisibility(8);
      } else {
         this.mRecycler.setVisibility(8);
         this.mRelativeNoResults.setVisibility(0);
      }

   }

   public void onFabClick(View v) {
   }

   public void onItemClickListener(int position) {
      this.getMoveDetail(((ConsultaOperaciones)this.mItems.get(position)).getNumOperacion(), PreferencesHelper.newInstance(this).getString("preference_cod_uo"), position);
   }

   public void onOperativeClicked(int opeartive, int position) {
      CommonUtils.showOperativaPopUp(this, this.mRecycler, this, opeartive == 1, opeartive == 1 ? 2131886125 : 2131886345, position);
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      if (textResource == 2131886125) {
         String var5 = ((ConsultaOperaciones)this.mItems.get(position)).getCodigoEstadoOperacion();
         byte var6 = -1;
         switch(var5.hashCode()) {
         case 65:
            if (var5.equals("A")) {
               var6 = 3;
            }
            break;
         case 70:
            if (var5.equals("F")) {
               var6 = 1;
            }
            break;
         case 73:
            if (var5.equals("I")) {
               var6 = 0;
            }
            break;
         case 80:
            if (var5.equals("P")) {
               var6 = 2;
            }
         }

         switch(var6) {
         case 0:
            this.getAnularOpPteIngres(this.getDatosOperacion((ConsultaOperaciones)this.mItems.get(position)), pass, motive);
            break;
         case 1:
            this.getAnularOpPteConfir(this.getDatosOperacion((ConsultaOperaciones)this.mItems.get(position)), pass, motive);
            break;
         case 2:
            this.getAnularOpPteCobro(this.getDatosOperacion((ConsultaOperaciones)this.mItems.get(position)), pass, motive);
         case 3:
         }
      } else {
         this.getConfOpPteConf(this.getDatosOperacion((ConsultaOperaciones)this.mItems.get(position)), pass, motive);
      }

   }

   private OperDatosOperacion getDatosOperacion(ConsultaOperaciones consultaOperaciones) {
      OperDatosExpediente operDatosExpediente = new OperDatosExpediente(CommonUtils.formatExpedient(consultaOperaciones.getJuzgadoDestino(), consultaOperaciones.getJuzgadoOrigen(), consultaOperaciones.getProcedimiento(), consultaOperaciones.getNumExpediente(), consultaOperaciones.getAnyoApertura()), consultaOperaciones.getAnyoApertura(), consultaOperaciones.getNumExpediente(), consultaOperaciones.getProcedimiento(), consultaOperaciones.getJuzgadoDestino(), consultaOperaciones.getJuzgadoOrigen());
      return new OperDatosOperacion(consultaOperaciones.getCodigoMoneda(), operDatosExpediente, consultaOperaciones.getNumOperacion());
   }

   // $FF: synthetic method
   static ArrayList access$002(ActivityDetalleOperacion x0, ArrayList x1) {
      return x0.mItems = x1;
   }

   // $FF: synthetic method
   static ArrayList access$000(ActivityDetalleOperacion x0) {
      return x0.mItems;
   }

   // $FF: synthetic method
   static RecyclerView access$100(ActivityDetalleOperacion x0) {
      return x0.mRecycler;
   }

   // $FF: synthetic method
   static void access$200(ActivityDetalleOperacion x0) {
      x0.handleResultsVisibility();
   }

   // $FF: synthetic method
   static void access$300(ActivityDetalleOperacion x0, String x1, String x2, String x3, String x4, String x5, boolean x6) {
      x0.getOperacion(x1, x2, x3, x4, x5, x6);
   }
}
