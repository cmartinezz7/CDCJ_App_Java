package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos.1;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos.2;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos.3;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos.4;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos.5;
import es.santander.justicia.minisJusticia.adapters.MovementListAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.controllers.MovementsController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.totalMovementsDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.interfaces.MovementQueryCallback;
import es.santander.justicia.minisJusticia.tasks.ListViewScrollTracker;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityListaMovimientos extends MainActivity implements MovementQueryCallback, ActivityCallBack {
   private Spinner spinnerNumeroMovimiento;
   private static ArrayList<String> values = new ArrayList();
   private static int positionSelected;
   private Context context;
   private ListView lvMovementList;
   private static String numExpediente;
   private ProgressDialog dialog;
   private MovementsController movementsController;
   private MovementListAdapter adapter;
   private ActivityCallBack activityCallBack;
   private TextView emptyListMessage;
   private View header_lista_movimientos;
   private boolean inRequest = false;
   private int scrollTotal = 0;
   private ListViewScrollTracker mScrollTracke;
   private ArrayList<totalMovementsDTO> totalsList;
   private boolean flag_search_empty = false;
   private List<TextView> listaTextTotales = null;
   private List<View> listaLayoutTotales = null;
   private boolean buscarMovimientos = false;
   private int mLastFirstVisibleItem;
   private OnScrollListener lead_scrolllist = new 5(this);

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/lista_movimientos");
      this.setContentView(2131558628);
      this.scrollTotal = 0;
      this.context = this.getBaseContext();
      this.activityCallBack = this;
      this.movementsController = new MovementsController(this);
      Intent i = this.getIntent();
      Bundle extras = i.getExtras();
      this.buscarMovimientos = extras.getBoolean("BuscarMovimientos");
      if (extras != null && !this.buscarMovimientos) {
         values = i.getStringArrayListExtra("spinnerData");
         positionSelected = i.getIntExtra("itemPositionSelected", 0);
         numExpediente = i.getStringExtra("expedientNumber").trim();
      }

      FloatingActionButton fab = (FloatingActionButton)this.findViewById(2131362171);
      int miColor = this.getResources().getColor(2131099837);
      ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{miColor});
      fab.setBackgroundTintList(csl);
      fab.setImageResource(2131231147);
      fab.setOnClickListener(new 1(this));
      this.spinnerNumeroMovimiento = (Spinner)this.findViewById(2131362714);
      TextView juzgados = (TextView)this.findViewById(2131363082);
      ImageButton button = (ImageButton)this.findViewById(2131361967);
      this.lvMovementList = (ListView)this.findViewById(2131362453);
      this.emptyListMessage = (TextView)this.findViewById(2131363012);
      this.header_lista_movimientos = this.findViewById(2131362249);
      juzgados.setText("Lista de movimientos");
      button.setOnClickListener(new 2(this));
      ArrayList<String> valuesFormatted = new ArrayList();
      Iterator var10 = values.iterator();

      while(var10.hasNext()) {
         String value = (String)var10.next();
         valuesFormatted.add(CommonUtils.getProceedingFormatted(value));
      }

      ArrayAdapter<String> adapter = new ArrayAdapter(this.context, 2131558752, 2131362922, valuesFormatted);
      adapter.setDropDownViewResource(2131558753);
      this.spinnerNumeroMovimiento.setAdapter(adapter);
      this.spinnerNumeroMovimiento.setSelection(positionSelected);
      this.spinnerNumeroMovimiento.setOnItemSelectedListener(new 3(this));
   }

   private int getIndex(Spinner spinner, String myString) {
      int index = 0;

      for(int i = 0; i < spinner.getCount(); ++i) {
         if (spinner.getItemAtPosition(i).toString().replace(" ", "").equalsIgnoreCase(myString)) {
            index = i;
            break;
         }
      }

      return index;
   }

   public void onFinishGetMovements(ArrayList<MovementItemDTO> movementList, ArrayList<totalMovementsDTO> totalsList, boolean success, String errorMessage) {
      this.totalsList = totalsList;
      this.listaTextTotales = null;
      this.listaLayoutTotales = null;
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

      this.inRequest = false;
      if (success && movementList != null && movementList.size() > 0) {
         this.emptyListMessage.setVisibility(8);

         for(int i = 1; i <= 5; ++i) {
            View lnr_expandible = this.findViewById(this.findIdByName("lnr_expandible" + i));
            if (i <= totalsList.size()) {
               totalMovementsDTO total = (totalMovementsDTO)totalsList.get(i - 1);
               lnr_expandible.setVisibility(0);
               TextView tv_text_total_abonos = (TextView)this.findViewById(this.findIdByName("tv_text_total_abonos" + i));
               String payment = CommonUtils.formatImport(total.getImportPayment());
               tv_text_total_abonos.setText(payment + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
               TextView tv_text_total_cargos = (TextView)this.findViewById(this.findIdByName("tv_text_total_cargos" + i));
               String charge = CommonUtils.formatImport(total.getImportCharge());
               tv_text_total_cargos.setText(charge + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
               TextView tv_text_total_pendiente = (TextView)this.findViewById(this.findIdByName("tv_text_total_pendiente" + i));
               String pending = CommonUtils.formatImport(total.getImportPending());
               tv_text_total_pendiente.setText(pending + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
            } else {
               lnr_expandible.setVisibility(8);
            }
         }

         this.adapter = new MovementListAdapter(this.context, movementList);
         this.spinnerNumeroMovimiento.setSelection(this.getIndex(this.spinnerNumeroMovimiento, numExpediente));
         this.lvMovementList.setAdapter(this.adapter);
         View footerView = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(2131558626, (ViewGroup)null, false);
         if (this.lvMovementList.getFooterViewsCount() == 0) {
            this.lvMovementList.addFooterView(footerView);
         }

         this.lvMovementList.setVisibility(0);
         this.lvMovementList.setOnItemClickListener(new 4(this));
         this.scrollTotal = 0;
         this.mScrollTracke = new ListViewScrollTracker(this.lvMovementList);
         this.lvMovementList.setOnScrollListener(this.lead_scrolllist);
      } else {
         Intent intent;
         if (success && movementList != null && movementList.size() == 0) {
            if (this.flag_search_empty) {
               intent = new Intent(this, BusquedaMovimientosVaciaDesdeBuscador.class);
               this.startActivity(intent);
            } else {
               intent = new Intent(this, BusquedaMovimientosVacia.class);
               this.startActivity(intent);
            }
         } else if (errorMessage.equals("Error al validar el token, El token ha expirado")) {
            Toast.makeText(this.context, errorMessage, 0).show();
            intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
            intent.setFlags(268468224);
            this.startActivity(intent);
            this.finish();
         }
      }

   }

   private void getMovements() {
      if (this.buscarMovimientos) {
         Intent i = this.getIntent();
         Bundle extras = i.getExtras();
         this.buscarMovimientos(extras);
      } else if (!numExpediente.trim().isEmpty() && !this.inRequest) {
         this.inRequest = true;
         ExpedienteDTO expdiente = ExpedientesManager.getInstance().findExpedienteByNumExp(numExpediente);
         this.showDialog();
         this.movementsController.getMovements(expdiente.getJuzga(), expdiente.getJuzgori(), expdiente.getJnumexp(), expdiente.getJproced(), expdiente.getJanoapex(), DateUtils.getDateMonthBeforeCurrent(expdiente.getUltmov()), "", "", "", "", "");
      }

   }

   private void showDialog() {
      this.dialog = new ProgressDialog(this);
      this.dialog.setCancelable(false);
      this.dialog.setMessage(this.context.getResources().getString(2131886519));
      this.dialog.show();
   }

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      if (requestCode == 1000 && resultCode == -1) {
         this.buscarMovimientos(data.getExtras());
      }

   }

   public void buscarMovimientos(Bundle extras) {
      String dateFrom = extras.getString("dateFrom", "");
      String dateTo = extras.getString("dateTo", "");
      String importFrom = extras.getString("importFrom", "");
      String importTo = extras.getString("importTo", "");
      String movementType = extras.getString("movementType", "");
      String currencyType = extras.getString("cointType", "");
      this.flag_search_empty = extras.getBoolean("flag_empty", false);
      ExpedienteDTO expdiente = CommonUtils.parseExpedientToObject(numExpediente);
      this.showDialog();
      this.movementsController.getMovements(expdiente.getJuzga(), expdiente.getJuzgori(), expdiente.getJnumexp(), expdiente.getJproced(), expdiente.getJanoapex(), dateFrom, dateTo, importFrom, importTo, movementType, currencyType);
   }

   public void onTaskFinished(String taskID, Object result) {
      if ("DETALLE_MOVIMIENTO".equals(taskID)) {
         this.closeProgressDialog();
         if (result != null) {
            new Bundle();
            Intent intent = new Intent(this, DetalleMovimientoActivity.class);
            intent.putExtra("movimiento", (MovementItemDTO)result);
            intent.putExtra("expediente", numExpediente);
            this.startActivity(intent);
         } else {
            Toast.makeText(this.getApplicationContext(), "Error al invocar al servicio, vuelva a intentarlo", 1).show();
         }
      }

   }

   // $FF: synthetic method
   static String access$002(String x0) {
      numExpediente = x0;
      return x0;
   }

   // $FF: synthetic method
   static Spinner access$100(ActivityListaMovimientos x0) {
      return x0.spinnerNumeroMovimiento;
   }

   // $FF: synthetic method
   static int access$202(int x0) {
      positionSelected = x0;
      return x0;
   }

   // $FF: synthetic method
   static void access$300(ActivityListaMovimientos x0) {
      x0.getMovements();
   }

   // $FF: synthetic method
   static ListView access$400(ActivityListaMovimientos x0) {
      return x0.lvMovementList;
   }

   // $FF: synthetic method
   static String access$000() {
      return numExpediente;
   }

   // $FF: synthetic method
   static ActivityCallBack access$500(ActivityListaMovimientos x0) {
      return x0.activityCallBack;
   }

   // $FF: synthetic method
   static ListViewScrollTracker access$600(ActivityListaMovimientos x0) {
      return x0.mScrollTracke;
   }

   // $FF: synthetic method
   static int access$720(ActivityListaMovimientos x0, int x1) {
      return x0.scrollTotal -= x1;
   }

   // $FF: synthetic method
   static ArrayList access$800(ActivityListaMovimientos x0) {
      return x0.totalsList;
   }

   // $FF: synthetic method
   static int access$700(ActivityListaMovimientos x0) {
      return x0.scrollTotal;
   }

   // $FF: synthetic method
   static List access$900(ActivityListaMovimientos x0) {
      return x0.listaTextTotales;
   }

   // $FF: synthetic method
   static List access$902(ActivityListaMovimientos x0, List x1) {
      return x0.listaTextTotales = x1;
   }

   // $FF: synthetic method
   static List access$1002(ActivityListaMovimientos x0, List x1) {
      return x0.listaLayoutTotales = x1;
   }

   // $FF: synthetic method
   static List access$1000(ActivityListaMovimientos x0) {
      return x0.listaLayoutTotales;
   }
}
