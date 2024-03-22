package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.1;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.2;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.3;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.4;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.5;
import es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.DatosOperacion;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.TotalMovimiento;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityListaMovimientosLetrado extends ActivityAbstractLetrados implements OnRecyclerClickListener {
   private final int RQ_SEARCH = 13;
   private RecyclerView mRecycler;
   private ArrayList<DatosExpedienteDetail> mListExpedientes;
   private Spinner mSpinerExpedientes;
   private ArrayList<DatosOperacion> mItemsOperations;
   private ArrayList<TotalMovimiento> mItemsTotal;
   private LinearLayout mLinerContainer;
   private int mScrollTotal;
   private List<QFontTextView> mListaTextTotales;
   private List<View> mListaLayouts;
   private String mCurrentExpediente;
   private LinearLayout mLinearGlobalMovements;
   private RelativeLayout mRelativeNoResults;
   private FloatingActionButton mFabButton;
   private DatosExpedienteDetail expedienteSelected;
   private String janoapex;
   private String jnumexp;
   private String jproced;
   private String juzga;
   private String juzgori;
   private String jfechareDe;
   private String jfechareHasta;
   private String jimpnomiDe;
   private String jimpnomiHasta;
   private String codMon;
   private String tipoMov;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558446);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/lista_movimientos");
   }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == -1) {
         this.getMovements(this.expedienteSelected.getJanoapex(), this.expedienteSelected.getJnumexp(), this.expedienteSelected.getJproced(), this.expedienteSelected.getJuzga(), this.expedienteSelected.getJuzgori(), data.getStringExtra("extra_desde"), data.getStringExtra("extra_hasta"), data.getStringExtra("extra_importe_desde"), data.getStringExtra("extra_importe_hasta"), data.getStringExtra("extra_moneda"), data.getStringExtra("extra_tipo_movimiento"));
      }

   }

   private void initUi() {
      this.mSpinerExpedientes = (Spinner)this.findViewById(2131362724);
      this.mRecycler = (RecyclerView)this.findViewById(2131362622);
      this.mLinerContainer = (LinearLayout)this.findViewById(2131362406);
      this.mLinearGlobalMovements = (LinearLayout)this.findViewById(2131362414);
      this.mRelativeNoResults = (RelativeLayout)this.findViewById(2131362367);
      this.mFabButton = (FloatingActionButton)this.findViewById(2131362172);
      this.findViewById(2131361975).setOnClickListener(new 1(this));
      this.getIntent().setExtrasClassLoader(DatosExpedienteDetail.class.getClassLoader());
      this.mListExpedientes = this.getIntent().getParcelableArrayListExtra("extra_listado_expedientes");
      this.mListaTextTotales = new ArrayList();
      this.mListaLayouts = new ArrayList();
      this.setRecycler();
      this.setSpinner();
   }

   private void setSpinner() {
      ArrayList<String> values = this.getNumExpedientes();
      ArrayList<String> valuesFormatted = new ArrayList();
      Iterator var3 = values.iterator();

      while(var3.hasNext()) {
         String value = (String)var3.next();
         valuesFormatted.add(CommonUtils.getProceedingFormatted(value));
      }

      ArrayAdapter<String> adapter = new ArrayAdapter(this, 2131558752, 2131362922, valuesFormatted);
      adapter.setDropDownViewResource(2131558753);
      this.mSpinerExpedientes.setAdapter(adapter);
      this.mSpinerExpedientes.setSelection(this.getIntent().getIntExtra("extra_spinner_position", 0));
      this.mSpinerExpedientes.setOnItemSelectedListener(new 2(this));
   }

   private void setRecycler() {
      this.mRecycler.setHasFixedSize(true);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
      this.mRecycler.setOnScrollListener(new 3(this));
   }

   public void onFabClick(View v) {
      Intent intent = new Intent(this, ActivityBusquedaMovimientos.class);
      this.startActivityForResult(intent, 13);
   }

   private void getMovements(String janoapex, String jnumexp, String jproced, String juzga, String juzgori, String jfechareDe, String jfechareHasta, String jimpnomiDe, String jimpnomiHasta, String codMon, String tipoMov) {
      ConnectionBuilder.getListaMovimientos(janoapex, jnumexp, jproced, juzga, juzgori, jfechareDe, jfechareHasta, jimpnomiDe, jimpnomiHasta, codMon, tipoMov).enqueue(new 4(this, this, true, true));
   }

   private void getMoveDetail(String numOper, String juzga, int position) {
      ConnectionBuilder.getDetalleMovimientoCall(numOper, juzga).enqueue(new 5(this, this, true, true, position));
   }

   private void addTotalMovements() {
      View layoutTotalMovimiento = null;
      this.mLinerContainer.removeAllViews();
      int countIds = 0;

      for(Iterator var3 = this.mItemsTotal.iterator(); var3.hasNext(); ++countIds) {
         TotalMovimiento totalMovimiento = (TotalMovimiento)var3.next();
         layoutTotalMovimiento = this.getLayoutInflater().inflate(2131558621, (ViewGroup)null, false);
         this.mLinerContainer.addView(layoutTotalMovimiento);
         layoutTotalMovimiento.setId(countIds);
         this.mListaLayouts.add(layoutTotalMovimiento);
         ++countIds;
         LinearLayout linearTotalMovGlobal = (LinearLayout)layoutTotalMovimiento.findViewById(2131362408);
         linearTotalMovGlobal.setId(countIds);
         this.mListaLayouts.add(linearTotalMovGlobal);
         ++countIds;
         LinearLayout linearAbonos = (LinearLayout)layoutTotalMovimiento.findViewById(2131362401);
         linearAbonos.setId(countIds);
         this.mListaLayouts.add(linearAbonos);
         ++countIds;
         LinearLayout linearCargos = (LinearLayout)layoutTotalMovimiento.findViewById(2131362405);
         linearCargos.setId(countIds);
         this.mListaLayouts.add(linearCargos);
         ++countIds;
         LinearLayout linearPendientes = (LinearLayout)layoutTotalMovimiento.findViewById(2131362416);
         linearPendientes.setId(countIds);
         this.mListaLayouts.add(linearPendientes);
         ++countIds;
         QFontTextView textTabonos = (QFontTextView)layoutTotalMovimiento.findViewById(2131362856);
         textTabonos.setText(CommonUtils.formatImport(totalMovimiento.getJimpabono()) + " " + totalMovimiento.getCodmon());
         textTabonos.setId(countIds);
         this.mListaTextTotales.add(textTabonos);
         ++countIds;
         QFontTextView textCargos = (QFontTextView)layoutTotalMovimiento.findViewById(2131362873);
         textCargos.setText(CommonUtils.formatImport(totalMovimiento.getJimpcargo()) + " " + totalMovimiento.getCodmon());
         textCargos.setId(countIds);
         this.mListaTextTotales.add(textCargos);
         ++countIds;
         QFontTextView textPdt = (QFontTextView)layoutTotalMovimiento.findViewById(2131362914);
         textPdt.setText(CommonUtils.formatImport(totalMovimiento.getJimppend()) + " " + totalMovimiento.getCodmon());
         textPdt.setId(countIds);
         this.mListaTextTotales.add(textPdt);
         ++countIds;
         QFontTextView textAbonosTilte = (QFontTextView)this.findViewById(2131362857);
         textAbonosTilte.setId(countIds);
         this.mListaTextTotales.add(textAbonosTilte);
         ++countIds;
         QFontTextView textCargosTitle = (QFontTextView)this.findViewById(2131362874);
         textCargosTitle.setId(countIds);
         this.mListaTextTotales.add(textCargosTitle);
         ++countIds;
         QFontTextView textPendienteTitle = (QFontTextView)this.findViewById(2131362915);
         textPendienteTitle.setId(countIds);
         this.mListaTextTotales.add(textPendienteTitle);
      }

      this.mLinerContainer.setVisibility(0);
   }

   private void showOperations() {
      this.mRecycler.setAdapter(new AdapterListaMovimientos(this, this.mItemsOperations));
   }

   private ArrayList<String> getNumExpedientes() {
      ArrayList<String> retValue = new ArrayList();
      Iterator var2 = this.mListExpedientes.iterator();

      while(var2.hasNext()) {
         DatosExpedienteDetail datosExpedienteDetail = (DatosExpedienteDetail)var2.next();
         retValue.add(CommonUtils.formatExpedient(datosExpedienteDetail.getJuzga(), datosExpedienteDetail.getJuzgori(), datosExpedienteDetail.getJproced(), datosExpedienteDetail.getJnumexp(), datosExpedienteDetail.getJanoapex()));
      }

      return retValue;
   }

   private void extractInfo(ArrayList<Object> datosOperacions) {
      this.mItemsOperations = new ArrayList();
      this.mItemsTotal = new ArrayList();
      Iterator var2 = datosOperacions.iterator();

      while(var2.hasNext()) {
         Object object = var2.next();
         if (object instanceof DatosOperacion) {
            this.mItemsOperations.add((DatosOperacion)object);
         } else {
            this.mItemsTotal.add((TotalMovimiento)object);
         }
      }

      this.addTotalMovements();
      this.showOperations();
   }

   public void onItemClickListener(int position) {
      this.getMoveDetail(((DatosOperacion)this.mItemsOperations.get(position)).getJnuoper(), PreferencesHelper.newInstance(this).getString("preference_cod_uo"), position);
   }

   private MovementItemDTO getMovmentItemDTO(DatosOperacion datosOperacion, es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion movementObject) {
      MovementItemDTO movement = new MovementItemDTO();
      movement.setDetail(true);
      movement.setEsLetrado(true);
      if (movementObject.getDatosExpedienteDestino() != null) {
         movement.setExpedienteDestino(movementObject.getDatosExpedienteDestino().getCodExpediente());
      }

      movement.setRepresentado(movementObject.getJnors());
      movement.setDocumento(movementObject.getCoddocum());
      if (movementObject.getDatosExpediente().getSaldos() != null) {
         movement.setImporteSaldo(movementObject.getDatosExpediente().getSaldos().getImpsald());
      }

      if (movementObject.getDatosRepresentante() != null && movementObject.getDatosRepresentante().getGenombre() != null) {
         movement.setRepresentante(movementObject.getDatosRepresentante().getGenombre());
      }

      if (movementObject.getCodmon() != null) {
         movement.setCodmon(movementObject.getCodmon());
      }

      if (movementObject.getDesctipomod() != null) {
         movement.setDesctipomod(movementObject.getDesctipomod());
      }

      if (movementObject.getJimpnomi() != null) {
         movement.setImporteDetalle(movementObject.getJimpnomi());
         movement.setMovementStatus(MovementStatusEnum.EXECUTED);
      } else if (movementObject.getJimppend() != null) {
         movement.setImporteDetalle(movementObject.getJimppend());
         movement.setMovementStatus(MovementStatusEnum.PENDING);
      } else if (datosOperacion.getJimpcaduca() != null) {
         movement.setImporteDetalle(datosOperacion.getJimpcaduca());
         movement.setMovementStatus(MovementStatusEnum.EXPIRED);
      }

      if (datosOperacion.getJnors() != null) {
         movement.setJnors(datosOperacion.getJnors());
      }

      if (movementObject.getJnuoper() != null) {
         movement.setJnuoper(movementObject.getJnuoper());
      }

      if (datosOperacion.getJtipomod() != null) {
         movement.setJtipomod(datosOperacion.getJtipomod());
      }

      if (datosOperacion.getMoneda() != null) {
         movement.setMoneda(datosOperacion.getMoneda());
      }

      if (movementObject.getNumerosr() != null) {
         movement.setNumerosr(movementObject.getNumerosr());
      }

      if (movementObject.getSeralfab() != null) {
         movement.setSeralfab(movementObject.getSeralfab());
      }

      if (movementObject.getSerieYMandamiento() != null) {
         movement.setSerieYMandamiento(movementObject.getSerieYMandamiento());
      }

      if (movementObject.getJusrhare() != null) {
         movement.setjResponsableAlta(movementObject.getJusrhare());
      }

      if (movementObject.getJusrfirma() != null) {
         movement.setjResponsableFirma(movementObject.getJusrfirma());
      }

      if (movementObject.getJusrfirmeza() != null) {
         movement.setjResponsableFirmeza(movementObject.getJusrfirmeza());
      }

      if (movementObject.getJusrautoriza() != null) {
         movement.setjResponsableAutorizacion(movementObject.getJusrautoriza());
      }

      if (movementObject.getJusrconf() != null) {
         movement.setjResponsableConfirmacion(movementObject.getJusrconf());
      }

      if (movementObject.getJfechare() != null) {
         movement.setJfechare(DateUtils.formatDate(movementObject.getJfechare()));
      }

      if (movementObject.getJfecfirma() != null) {
         movement.setjFechaFirma(DateUtils.formatDate(movementObject.getJfecfirma()));
      }

      if (movementObject.getJfecfirmeza() != null) {
         movement.setjFechaFirmeza(DateUtils.formatDate(movementObject.getJfecfirmeza()));
      }

      if (movementObject.getJfecautoriza() != null) {
         movement.setjFechaAutorizacion(DateUtils.formatDate(movementObject.getJfecautoriza()));
      }

      if (movementObject.getJfecconf() != null) {
         movement.setjFechaConfirmacion(DateUtils.formatDate(movementObject.getJfecconf()));
      }

      if (movementObject.getJfeccaduc() != null) {
         movement.setjFechaCaducidad(DateUtils.formatDate(movementObject.getJfeccaduc()));
      }

      if (movementObject.getConc30() != null) {
         movement.setConcepto(movementObject.getConc30());
      }

      movement.setFecha(CommonUtils.getCurrentDateToShow());
      return movement;
   }

   // $FF: synthetic method
   static FloatingActionButton access$000(ActivityListaMovimientosLetrado x0) {
      return x0.mFabButton;
   }

   // $FF: synthetic method
   static DatosExpedienteDetail access$102(ActivityListaMovimientosLetrado x0, DatosExpedienteDetail x1) {
      return x0.expedienteSelected = x1;
   }

   // $FF: synthetic method
   static ArrayList access$200(ActivityListaMovimientosLetrado x0) {
      return x0.mListExpedientes;
   }

   // $FF: synthetic method
   static DatosExpedienteDetail access$100(ActivityListaMovimientosLetrado x0) {
      return x0.expedienteSelected;
   }

   // $FF: synthetic method
   static void access$300(ActivityListaMovimientosLetrado x0, String x1, String x2, String x3, String x4, String x5, String x6, String x7, String x8, String x9, String x10, String x11) {
      x0.getMovements(x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11);
   }

   // $FF: synthetic method
   static String access$402(ActivityListaMovimientosLetrado x0, String x1) {
      return x0.mCurrentExpediente = x1;
   }

   // $FF: synthetic method
   static RecyclerView access$500(ActivityListaMovimientosLetrado x0) {
      return x0.mRecycler;
   }

   // $FF: synthetic method
   static int access$602(ActivityListaMovimientosLetrado x0, int x1) {
      return x0.mScrollTotal = x1;
   }

   // $FF: synthetic method
   static ArrayList access$700(ActivityListaMovimientosLetrado x0) {
      return x0.mItemsTotal;
   }

   // $FF: synthetic method
   static int access$600(ActivityListaMovimientosLetrado x0) {
      return x0.mScrollTotal;
   }

   // $FF: synthetic method
   static List access$800(ActivityListaMovimientosLetrado x0) {
      return x0.mListaTextTotales;
   }

   // $FF: synthetic method
   static List access$900(ActivityListaMovimientosLetrado x0) {
      return x0.mListaLayouts;
   }

   // $FF: synthetic method
   static void access$1000(ActivityListaMovimientosLetrado x0, ArrayList x1) {
      x0.extractInfo(x1);
   }

   // $FF: synthetic method
   static RelativeLayout access$1100(ActivityListaMovimientosLetrado x0) {
      return x0.mRelativeNoResults;
   }

   // $FF: synthetic method
   static LinearLayout access$1200(ActivityListaMovimientosLetrado x0) {
      return x0.mLinearGlobalMovements;
   }

   // $FF: synthetic method
   static ArrayList access$1300(ActivityListaMovimientosLetrado x0) {
      return x0.mItemsOperations;
   }

   // $FF: synthetic method
   static MovementItemDTO access$1400(ActivityListaMovimientosLetrado x0, DatosOperacion x1, es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion x2) {
      return x0.getMovmentItemDTO(x1, x2);
   }

   // $FF: synthetic method
   static String access$400(ActivityListaMovimientosLetrado x0) {
      return x0.mCurrentExpediente;
   }
}
