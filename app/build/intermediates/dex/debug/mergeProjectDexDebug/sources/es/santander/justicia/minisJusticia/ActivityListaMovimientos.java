package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.MovementListAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.controllers.MovementsController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.totalMovementsDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.expedientes.task.DetalleMovimientoTask;
import es.santander.justicia.minisJusticia.interfaces.MovementQueryCallback;
import es.santander.justicia.minisJusticia.tasks.ListViewScrollTracker;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityListaMovimientos extends MainActivity implements MovementQueryCallback, ActivityCallBack {
    /* access modifiers changed from: private */
    public static String numExpediente;
    /* access modifiers changed from: private */
    public static int positionSelected;
    private static ArrayList<String> values = new ArrayList<>();
    /* access modifiers changed from: private */
    public ActivityCallBack activityCallBack;
    private MovementListAdapter adapter;
    private boolean buscarMovimientos = false;
    private Context context;
    private ProgressDialog dialog;
    private TextView emptyListMessage;
    private boolean flag_search_empty = false;
    private View header_lista_movimientos;
    private boolean inRequest = false;
    private AbsListView.OnScrollListener lead_scrolllist = new AbsListView.OnScrollListener() {
        public void onScrollStateChanged(AbsListView view, int scrollState) {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            ActivityListaMovimientos.access$720(ActivityListaMovimientos.this, ActivityListaMovimientos.this.mScrollTracke.calculateIncrementalOffset(firstVisibleItem, visibleItemCount));
            float rango = ((float) (ActivityListaMovimientos.this.totalsList.size() + 1)) * 150.0f;
            float scrollInverso = rango - (((float) ActivityListaMovimientos.this.scrollTotal) > rango ? rango : (float) ActivityListaMovimientos.this.scrollTotal);
            float newTextSice = (scrollInverso / rango) * 16.0f;
            float alpha = scrollInverso / rango;
            if (alpha < 0.2f) {
                alpha = 0.0f;
            }
            if (ActivityListaMovimientos.this.totalsList != null) {
                if (ActivityListaMovimientos.this.listaTextTotales == null) {
                    List unused = ActivityListaMovimientos.this.listaTextTotales = new ArrayList();
                    List unused2 = ActivityListaMovimientos.this.listaLayoutTotales = new ArrayList();
                    int i = 1;
                    while (i <= ActivityListaMovimientos.this.totalsList.size() && i <= 5) {
                        List access$1000 = ActivityListaMovimientos.this.listaLayoutTotales;
                        ActivityListaMovimientos activityListaMovimientos = ActivityListaMovimientos.this;
                        access$1000.add(activityListaMovimientos.findViewById(activityListaMovimientos.findIdByName("lnr_expandible" + i)));
                        List access$900 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos2 = ActivityListaMovimientos.this;
                        access$900.add((TextView) activityListaMovimientos2.findViewById(activityListaMovimientos2.findIdByName("tv_text_total_abonos" + i)));
                        List access$9002 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos3 = ActivityListaMovimientos.this;
                        access$9002.add((TextView) activityListaMovimientos3.findViewById(activityListaMovimientos3.findIdByName("tv_text_total_cargos" + i)));
                        List access$9003 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos4 = ActivityListaMovimientos.this;
                        access$9003.add((TextView) activityListaMovimientos4.findViewById(activityListaMovimientos4.findIdByName("tv_text_total_pendiente" + i)));
                        List access$9004 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos5 = ActivityListaMovimientos.this;
                        access$9004.add((TextView) activityListaMovimientos5.findViewById(activityListaMovimientos5.findIdByName("text_total_abonos" + i)));
                        List access$9005 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos6 = ActivityListaMovimientos.this;
                        access$9005.add((TextView) activityListaMovimientos6.findViewById(activityListaMovimientos6.findIdByName("text_total_cargos" + i)));
                        List access$9006 = ActivityListaMovimientos.this.listaTextTotales;
                        ActivityListaMovimientos activityListaMovimientos7 = ActivityListaMovimientos.this;
                        access$9006.add((TextView) activityListaMovimientos7.findViewById(activityListaMovimientos7.findIdByName("text_total_pendiente" + i)));
                        i++;
                    }
                }
                for (TextView tv : ActivityListaMovimientos.this.listaTextTotales) {
                    tv.setTextSize(newTextSice);
                    tv.setAlpha(alpha);
                }
                for (View v : ActivityListaMovimientos.this.listaLayoutTotales) {
                    LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) v.getLayoutParams();
                    relativeParams.topMargin = (int) ((scrollInverso / rango) * 20.0f);
                    v.setLayoutParams(relativeParams);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public List<View> listaLayoutTotales = null;
    /* access modifiers changed from: private */
    public List<TextView> listaTextTotales = null;
    /* access modifiers changed from: private */
    public ListView lvMovementList;
    private int mLastFirstVisibleItem;
    /* access modifiers changed from: private */
    public ListViewScrollTracker mScrollTracke;
    private MovementsController movementsController;
    /* access modifiers changed from: private */
    public int scrollTotal = 0;
    /* access modifiers changed from: private */
    public Spinner spinnerNumeroMovimiento;
    /* access modifiers changed from: private */
    public ArrayList<totalMovementsDTO> totalsList;

    static /* synthetic */ int access$720(ActivityListaMovimientos x0, int x1) {
        int i = x0.scrollTotal - x1;
        x0.scrollTotal = i;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/lista_movimientos");
        setContentView(R.layout.lista_movimientos_activity);
        this.scrollTotal = 0;
        this.context = getBaseContext();
        this.activityCallBack = this;
        this.movementsController = new MovementsController(this);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        boolean z = extras.getBoolean("BuscarMovimientos");
        this.buscarMovimientos = z;
        if (extras != null && !z) {
            values = i.getStringArrayListExtra("spinnerData");
            positionSelected = i.getIntExtra("itemPositionSelected", 0);
            numExpediente = i.getStringExtra(Constants.EXPEDIENT_NUMBER).trim();
        }
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[0]}, new int[]{getResources().getColor(R.color.bancoSantander)}));
        fab.setImageResource(R.drawable.ic_search);
        fab.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientos] */
            public void onClick(View view) {
                ActivityListaMovimientos.this.startActivityForResult(new Intent(ActivityListaMovimientos.this, MovementsSearchActivity.class), 1000);
            }
        });
        this.spinnerNumeroMovimiento = (Spinner) findViewById(R.id.sp_motive);
        this.lvMovementList = (ListView) findViewById(R.id.lv_lista_movimiento);
        this.emptyListMessage = (TextView) findViewById(R.id.tv_empty_list);
        this.header_lista_movimientos = findViewById(R.id.header_lista_movimientos);
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText("Lista de movimientos");
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityListaMovimientos.this.finish();
            }
        });
        ArrayList<String> valuesFormatted = new ArrayList<>();
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            valuesFormatted.add(CommonUtils.getProceedingFormatted(it.next()));
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this.context, R.layout.simple_spinner_item, R.id.text_spinner, valuesFormatted);
        adapter2.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spinnerNumeroMovimiento.setAdapter(adapter2);
        this.spinnerNumeroMovimiento.setSelection(positionSelected);
        this.spinnerNumeroMovimiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityListaMovimientos.numExpediente = ActivityListaMovimientos.this.spinnerNumeroMovimiento.getSelectedItem().toString().replace(" ", "");
                int unused2 = ActivityListaMovimientos.positionSelected = ActivityListaMovimientos.this.spinnerNumeroMovimiento.getSelectedItemPosition();
                ActivityListaMovimientos.this.getMovements();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private int getIndex(Spinner spinner, String myString) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().replace(" ", "").equalsIgnoreCase(myString)) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientos] */
    public void onFinishGetMovements(ArrayList<MovementItemDTO> movementList, ArrayList<totalMovementsDTO> totalsList2, boolean success, String errorMessage) {
        ArrayList<MovementItemDTO> arrayList = movementList;
        ArrayList<totalMovementsDTO> arrayList2 = totalsList2;
        String str = errorMessage;
        this.totalsList = arrayList2;
        this.listaTextTotales = null;
        this.listaLayoutTotales = null;
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
        int i = 0;
        this.inRequest = false;
        if (success && arrayList != null && movementList.size() > 0) {
            this.emptyListMessage.setVisibility(8);
            int i2 = 1;
            while (i2 <= 5) {
                View lnr_expandible = findViewById(findIdByName("lnr_expandible" + i2));
                if (i2 <= totalsList2.size()) {
                    totalMovementsDTO total = arrayList2.get(i2 - 1);
                    lnr_expandible.setVisibility(i);
                    ((TextView) findViewById(findIdByName("tv_text_total_abonos" + i2))).setText(CommonUtils.formatImport(total.getImportPayment()) + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
                    ((TextView) findViewById(findIdByName("tv_text_total_cargos" + i2))).setText(CommonUtils.formatImport(total.getImportCharge()) + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
                    ((TextView) findViewById(findIdByName("tv_text_total_pendiente" + i2))).setText(CommonUtils.formatImport(total.getImportPending()) + " " + CommonUtils.getCurrencySymbol(total.getCodmod()));
                } else {
                    lnr_expandible.setVisibility(8);
                }
                i2++;
                i = 0;
            }
            this.adapter = new MovementListAdapter(this.context, arrayList);
            Spinner spinner = this.spinnerNumeroMovimiento;
            spinner.setSelection(getIndex(spinner, numExpediente));
            this.lvMovementList.setAdapter(this.adapter);
            View footerView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.list_blank_footer, (ViewGroup) null, false);
            if (this.lvMovementList.getFooterViewsCount() == 0) {
                this.lvMovementList.addFooterView(footerView);
            }
            this.lvMovementList.setVisibility(0);
            this.lvMovementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    MovementItemDTO movementItem = (MovementItemDTO) ActivityListaMovimientos.this.lvMovementList.getAdapter().getItem(position);
                    ExpedienteDTO expedienteDTO = ExpedientesManager.getInstance().findExpedienteByNumExp(ActivityListaMovimientos.numExpediente);
                    if (movementItem == null) {
                        return;
                    }
                    if (movementItem.isDetail()) {
                        ActivityListaMovimientos.this.onTaskFinished(DetalleMovimientoTask.TASK_ID, movementItem);
                        return;
                    }
                    ActivityListaMovimientos.this.showProgressDialog((int) R.string.loading_movement_detail);
                    new DetalleMovimientoTask(ActivityListaMovimientos.this.activityCallBack).execute(new Object[]{movementItem, expedienteDTO.getJuzga(), movementItem.getJnuoper()});
                }
            });
            this.scrollTotal = 0;
            this.mScrollTracke = new ListViewScrollTracker(this.lvMovementList);
            this.lvMovementList.setOnScrollListener(this.lead_scrolllist);
        } else if (!success || arrayList == null || movementList.size() != 0) {
            if (str.equals(Constants.TOKEN_TIMEOUT)) {
                Toast.makeText(this.context, str, 0).show();
                Intent intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
                intent.setFlags(268468224);
                startActivity(intent);
                finish();
            }
        } else if (this.flag_search_empty) {
            startActivity(new Intent(this, BusquedaMovimientosVaciaDesdeBuscador.class));
        } else {
            startActivity(new Intent(this, BusquedaMovimientosVacia.class));
        }
    }

    /* access modifiers changed from: private */
    public void getMovements() {
        if (this.buscarMovimientos) {
            buscarMovimientos(getIntent().getExtras());
        } else if (!numExpediente.trim().isEmpty() && !this.inRequest) {
            this.inRequest = true;
            ExpedienteDTO expdiente = ExpedientesManager.getInstance().findExpedienteByNumExp(numExpediente);
            showDialog();
            this.movementsController.getMovements(expdiente.getJuzga(), expdiente.getJuzgori(), expdiente.getJnumexp(), expdiente.getJproced(), expdiente.getJanoapex(), DateUtils.getDateMonthBeforeCurrent(expdiente.getUltmov()), "", "", "", "", "");
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientos] */
    private void showDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCancelable(false);
        this.dialog.setMessage(this.context.getResources().getString(R.string.loading_movement_list));
        this.dialog.show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == -1) {
            buscarMovimientos(data.getExtras());
        }
    }

    public void buscarMovimientos(Bundle extras) {
        Bundle bundle = extras;
        String dateFrom = bundle.getString(Constants.DATE_FROM, "");
        String dateTo = bundle.getString(Constants.DATE_TO, "");
        String importFrom = bundle.getString(Constants.IMPORT_FROM, "");
        String importTo = bundle.getString(Constants.IMPORT_TO, "");
        String movementType = bundle.getString(Constants.MOVEMENT_TYPE, "");
        String currencyType = bundle.getString(Constants.CURRENCY_TYPE, "");
        this.flag_search_empty = bundle.getBoolean("flag_empty", false);
        ExpedienteDTO expdiente = CommonUtils.parseExpedientToObject(numExpediente);
        showDialog();
        this.movementsController.getMovements(expdiente.getJuzga(), expdiente.getJuzgori(), expdiente.getJnumexp(), expdiente.getJproced(), expdiente.getJanoapex(), dateFrom, dateTo, importFrom, importTo, movementType, currencyType);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientos] */
    public void onTaskFinished(String taskID, Object result) {
        if (DetalleMovimientoTask.TASK_ID.equals(taskID)) {
            closeProgressDialog();
            if (result != null) {
                new Bundle();
                Intent intent = new Intent(this, DetalleMovimientoActivity.class);
                intent.putExtra("movimiento", (MovementItemDTO) result);
                intent.putExtra("expediente", numExpediente);
                startActivity(intent);
                return;
            }
            Toast.makeText(getApplicationContext(), "Error al invocar al servicio, vuelva a intentarlo", 1).show();
        }
    }
}
