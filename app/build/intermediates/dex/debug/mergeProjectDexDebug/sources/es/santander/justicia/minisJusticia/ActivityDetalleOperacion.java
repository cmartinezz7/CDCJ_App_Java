package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperDatosExpediente;
import es.santander.justicia.minisJusticia.models.requests.operativasOperaciones.OperDatosOperacion;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsuOperResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import retrofit2.Call;

public class ActivityDetalleOperacion extends ActivityAbstractLetrados implements AdapterAbstractRecycler.OnRecyclerClickListener, AdapterOpeEjectDetail.OnOperativeClicked, DialogSolicitudCalback {
    public static final String CODIGO_ESTADO_A = "A";
    public static final String CODIGO_ESTADO_F = "F";
    public static final String CODIGO_ESTADO_I = "I";
    public static final String CODIGO_ESTADO_P = "P";
    public static final String COD_TRANSFERENCIA_XE = "XE";
    public static final String COD_TRANSF_RECIBIDA = "XR";
    public static final String COD_TRASPASO_TE = "TE";
    public static final String COD_TRASPASO_TR = "TR";
    public static final String COD_TRASPASO_TT = "TT";
    public static final int OPERATIVE_ANULAR = 1;
    public static final int OPERATIVE_FIRMAR = 2;
    /* access modifiers changed from: private */
    public ArrayList<ConsultaOperaciones> mItems;
    private Call<ConsuOperResponseEnvelope> mLastCallConsultOper;
    /* access modifiers changed from: private */
    public RecyclerView mRecycler;
    private RelativeLayout mRelativeNoResults;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listados);
        initUi();
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    private void initUi() {
        findViewById(R.id.fab_button).setVisibility(0);
        ((QTextView) findViewById(R.id.text_title_toolbar)).setText(getString(getIntent().hasExtra(Constants.EXTRA_OPERACION_SELECCIONADA) ? R.string.menu_operations_pending : R.string.menu_operations_done));
        findViewById(R.id.fab_button).setVisibility(8);
        this.mRelativeNoResults = (RelativeLayout) findViewById(R.id.layout_no_result);
        findViewById(R.id.button_nueva_busqueda).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityDetalleOperacion.this.onBackPressed();
            }
        });
        RecyclerView findViewById = findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(true);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
        getOperacion(getIntent().getStringExtra(Constants.EXTRA_JUZDESTIMNO), getIntent().getStringExtra(Constants.EXTRA_MONEDA), getIntent().getStringExtra(Constants.EXTRA_OPERACION), getIntent().getStringExtra(Constants.EXTRA_OPERACION_SELECCIONADA), getFechaInicio(getIntent().getStringExtra(Constants.EXTRA_OPERACION_SELECCIONADA)), false);
    }

    private String getFechaInicio(String tipoOper) {
        if (tipoOper != null) {
            char c = 65535;
            int hashCode = tipoOper.hashCode();
            if (hashCode != 279896340) {
                if (hashCode != 992482274) {
                    if (hashCode == 1993158816 && tipoOper.equals(FragmentOperations.COBROS)) {
                        c = 0;
                    }
                } else if (tipoOper.equals(FragmentOperations.INGRESOS)) {
                    c = 2;
                }
            } else if (tipoOper.equals(FragmentOperations.CONFIRMACIONES)) {
                c = 1;
            }
            if (c == 0) {
                return CommonUtils.getDateFourMonthsAgo();
            }
            if (c == 1) {
                return CommonUtils.getDateFromFristDayOfTheYear();
            }
            if (c == 2) {
                return CommonUtils.getDateSevenMonthsAgo();
            }
        }
        return CommonUtils.getDateWeekAgo();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getOperacion(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            r8 = this;
            if (r14 != 0) goto L_0x0008
            retrofit2.Call r0 = es.santander.justicia.minisJusticia.connections.ConnectionBuilder.getConsultaOperacionCall(r9, r10, r11, r12, r13)
            r8.mLastCallConsultOper = r0
        L_0x0008:
            retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsuOperResponseEnvelope> r0 = r8.mLastCallConsultOper
            retrofit2.Call r0 = r0.clone()
            es.santander.justicia.minisJusticia.ActivityDetalleOperacion$2 r7 = new es.santander.justicia.minisJusticia.ActivityDetalleOperacion$2
            r1 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r1 = r7
            r2 = r8
            r3 = r8
            r6 = r12
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.getOperacion(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getMoveDetail(java.lang.String r9, java.lang.String r10, int r11) {
        /*
            r8 = this;
            retrofit2.Call r0 = es.santander.justicia.minisJusticia.connections.ConnectionBuilder.getDetalleMovimientoCall(r9, r10)
            es.santander.justicia.minisJusticia.ActivityDetalleOperacion$3 r7 = new es.santander.justicia.minisJusticia.ActivityDetalleOperacion$3
            r1 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r1 = r7
            r2 = r8
            r3 = r8
            r4 = r5
            r6 = r11
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.getMoveDetail(java.lang.String, java.lang.String, int):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    private void getAnularOpPteCobro(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
        ConnectionBuilder.getAnularOpPteCobrCall(datosOperacion, firma, motivoAnulacion).enqueue(new RetrofitCallbackInterface<AnularOpPteCobroResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: type inference failed for: r0v8, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[Catch:{ IOException -> 0x007c }] */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x003f A[Catch:{ IOException -> 0x007c }] */
            /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope> r9, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope> r10) {
                /*
                    r8 = this;
                    super.onResponse(r9, r10)
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x007c }
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x007c }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0028
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x007c }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope) r1     // Catch:{ IOException -> 0x007c }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x007c }
                    if (r1 == 0) goto L_0x0028
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x007c }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope) r1     // Catch:{ IOException -> 0x007c }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x007c }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x007c }
                    goto L_0x0029
                L_0x0028:
                    r1 = r2
                L_0x0029:
                    int r3 = r10.code()     // Catch:{ IOException -> 0x007c }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0039
                    okhttp3.ResponseBody r2 = r10.errorBody()     // Catch:{ IOException -> 0x007c }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x007c }
                L_0x0039:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x007c }
                    if (r0 == 0) goto L_0x007b
                    okhttp3.ResponseBody r0 = r10.errorBody()     // Catch:{ IOException -> 0x007c }
                    if (r0 != 0) goto L_0x006b
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r1 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x007c }
                    java.lang.String r2 = ""
                    java.lang.String r3 = ""
                    java.lang.String r4 = ""
                    android.content.Intent r0 = r1.getIntent()     // Catch:{ IOException -> 0x007c }
                    java.lang.String r5 = "extra_operacion_seleccionada"
                    java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ IOException -> 0x007c }
                    java.lang.String r6 = ""
                    r7 = 1
                    r1.getOperacion(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x007c }
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x007c }
                    androidx.recyclerview.widget.RecyclerView r1 = r0.mRecycler     // Catch:{ IOException -> 0x007c }
                    r2 = 2131886704(0x7f120270, float:1.9407994E38)
                    r3 = 0
                    es.santander.justicia.utils.CommonUtils.showPopUpActionDone(r0, r1, r2, r3)     // Catch:{ IOException -> 0x007c }
                    goto L_0x007b
                L_0x006b:
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x007c }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x007c }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x007c }
                    r0.show()     // Catch:{ IOException -> 0x007c }
                L_0x007b:
                    goto L_0x0084
                L_0x007c:
                    r0 = move-exception
                    java.lang.String r1 = "getAnularOpPteCobro"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x0084:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.AnonymousClass4.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    private void getAnularOpPteConfir(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
        ConnectionBuilder.getAnularOpPteConfirmacion(datosOperacion, firma, motivoAnulacion).enqueue(new RetrofitCallbackInterface<AnularOpPteConfirmacionResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: type inference failed for: r0v8, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope> r9, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope> r10) {
                /*
                    r8 = this;
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteConfirmacion.AnularOpPteConfirmacionResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0026
                L_0x0025:
                    r1 = r2
                L_0x0026:
                    int r3 = r10.code()     // Catch:{ IOException -> 0x0079 }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0036
                    okhttp3.ResponseBody r2 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x0079 }
                L_0x0036:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    if (r0 == 0) goto L_0x0078
                    okhttp3.ResponseBody r0 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    if (r0 != 0) goto L_0x0068
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r1 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    java.lang.String r3 = ""
                    java.lang.String r4 = ""
                    android.content.Intent r0 = r1.getIntent()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r5 = "extra_operacion_seleccionada"
                    java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r6 = ""
                    r7 = 1
                    r1.getOperacion(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    androidx.recyclerview.widget.RecyclerView r1 = r0.mRecycler     // Catch:{ IOException -> 0x0079 }
                    r2 = 2131886704(0x7f120270, float:1.9407994E38)
                    r3 = 0
                    es.santander.justicia.utils.CommonUtils.showPopUpActionDone(r0, r1, r2, r3)     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0078
                L_0x0068:
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    r0.show()     // Catch:{ IOException -> 0x0079 }
                L_0x0078:
                    goto L_0x0081
                L_0x0079:
                    r0 = move-exception
                    java.lang.String r1 = "getAnularOpPteConfir"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x0081:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.AnonymousClass5.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    private void getAnularOpPteIngres(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (anular)");
        ConnectionBuilder.getAnularOpPteIngreso(datosOperacion, firma, motivoAnulacion).enqueue(new RetrofitCallbackInterface<AnularOpPteIngresoResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: type inference failed for: r0v8, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope> r9, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope> r10) {
                /*
                    r8 = this;
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.anularOpPteIngreso.AnularOpPteIngresoResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0026
                L_0x0025:
                    r1 = r2
                L_0x0026:
                    int r3 = r10.code()     // Catch:{ IOException -> 0x0079 }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0036
                    okhttp3.ResponseBody r2 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x0079 }
                L_0x0036:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    if (r0 == 0) goto L_0x0078
                    okhttp3.ResponseBody r0 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    if (r0 != 0) goto L_0x0068
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r1 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    java.lang.String r3 = ""
                    java.lang.String r4 = ""
                    android.content.Intent r0 = r1.getIntent()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r5 = "extra_operacion_seleccionada"
                    java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r6 = ""
                    r7 = 1
                    r1.getOperacion(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    androidx.recyclerview.widget.RecyclerView r1 = r0.mRecycler     // Catch:{ IOException -> 0x0079 }
                    r2 = 2131886704(0x7f120270, float:1.9407994E38)
                    r3 = 0
                    es.santander.justicia.utils.CommonUtils.showPopUpActionDone(r0, r1, r2, r3)     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0078
                L_0x0068:
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    r0.show()     // Catch:{ IOException -> 0x0079 }
                L_0x0078:
                    goto L_0x0081
                L_0x0079:
                    r0 = move-exception
                    java.lang.String r1 = "getAnularOpPteIngres"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x0081:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.AnonymousClass6.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    private void getConfOpPteConf(OperDatosOperacion datosOperacion, String firma, String motivoAnulacion) {
        TealiumHelper.trackEvent("/detalle_movimiento", "detalle_movimiento (firmar)");
        ConnectionBuilder.getConfirmOpPteConfir(datosOperacion, firma, motivoAnulacion).enqueue(new RetrofitCallbackInterface<ConfirmarOpPteConfResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: type inference failed for: r0v8, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IOException -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope> r9, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope> r10) {
                /*
                    r8 = this;
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r10.body()     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope) r1     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0026
                L_0x0025:
                    r1 = r2
                L_0x0026:
                    int r3 = r10.code()     // Catch:{ IOException -> 0x0079 }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0036
                    okhttp3.ResponseBody r2 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x0079 }
                L_0x0036:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    if (r0 == 0) goto L_0x0078
                    okhttp3.ResponseBody r0 = r10.errorBody()     // Catch:{ IOException -> 0x0079 }
                    if (r0 != 0) goto L_0x0068
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r1 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r2 = ""
                    java.lang.String r3 = ""
                    java.lang.String r4 = ""
                    android.content.Intent r0 = r1.getIntent()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r5 = "extra_operacion_seleccionada"
                    java.lang.String r5 = r0.getStringExtra(r5)     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r6 = ""
                    r7 = 1
                    r1.getOperacion(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0079 }
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    androidx.recyclerview.widget.RecyclerView r1 = r0.mRecycler     // Catch:{ IOException -> 0x0079 }
                    r2 = 2131886704(0x7f120270, float:1.9407994E38)
                    r3 = 0
                    es.santander.justicia.utils.CommonUtils.showPopUpActionDone(r0, r1, r2, r3)     // Catch:{ IOException -> 0x0079 }
                    goto L_0x0078
                L_0x0068:
                    es.santander.justicia.minisJusticia.ActivityDetalleOperacion r0 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.this     // Catch:{ IOException -> 0x0079 }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x0079 }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x0079 }
                    r0.show()     // Catch:{ IOException -> 0x0079 }
                L_0x0078:
                    goto L_0x0081
                L_0x0079:
                    r0 = move-exception
                    java.lang.String r1 = "getConfOpPteConf"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x0081:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.AnonymousClass7.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleResultsVisibility() {
        ArrayList<ConsultaOperaciones> arrayList = this.mItems;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mRecycler.setVisibility(8);
            this.mRelativeNoResults.setVisibility(0);
            return;
        }
        this.mRecycler.setVisibility(0);
        this.mRelativeNoResults.setVisibility(8);
    }

    public void onFabClick(View v) {
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleOperacion] */
    public void onItemClickListener(int position) {
        getMoveDetail(this.mItems.get(position).getNumOperacion(), PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO), position);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOperativeClicked(int r7, int r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.RecyclerView r1 = r6.mRecycler
            r0 = 1
            if (r7 != r0) goto L_0x0007
            r3 = r0
            goto L_0x0009
        L_0x0007:
            r2 = 0
            r3 = r2
        L_0x0009:
            if (r7 != r0) goto L_0x000f
            r0 = 2131886125(0x7f12002d, float:1.940682E38)
            goto L_0x0012
        L_0x000f:
            r0 = 2131886345(0x7f120109, float:1.9407266E38)
        L_0x0012:
            r4 = r0
            r0 = r6
            r2 = r6
            r5 = r8
            es.santander.justicia.utils.CommonUtils.showOperativaPopUp(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleOperacion.onOperativeClicked(int, int):void");
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        if (textResource == 2131886125) {
            String codigoEstadoOperacion = this.mItems.get(position).getCodigoEstadoOperacion();
            char c = 65535;
            int hashCode = codigoEstadoOperacion.hashCode();
            if (hashCode != 65) {
                if (hashCode != 70) {
                    if (hashCode != 73) {
                        if (hashCode == 80 && codigoEstadoOperacion.equals(CODIGO_ESTADO_P)) {
                            c = 2;
                        }
                    } else if (codigoEstadoOperacion.equals(CODIGO_ESTADO_I)) {
                        c = 0;
                    }
                } else if (codigoEstadoOperacion.equals(CODIGO_ESTADO_F)) {
                    c = 1;
                }
            } else if (codigoEstadoOperacion.equals(CODIGO_ESTADO_A)) {
                c = 3;
            }
            if (c == 0) {
                getAnularOpPteIngres(getDatosOperacion(this.mItems.get(position)), pass, motive);
            } else if (c == 1) {
                getAnularOpPteConfir(getDatosOperacion(this.mItems.get(position)), pass, motive);
            } else if (c == 2) {
                getAnularOpPteCobro(getDatosOperacion(this.mItems.get(position)), pass, motive);
            }
        } else {
            getConfOpPteConf(getDatosOperacion(this.mItems.get(position)), pass, motive);
        }
    }

    private OperDatosOperacion getDatosOperacion(ConsultaOperaciones consultaOperaciones) {
        return new OperDatosOperacion(consultaOperaciones.getCodigoMoneda(), new OperDatosExpediente(CommonUtils.formatExpedient(consultaOperaciones.getJuzgadoDestino(), consultaOperaciones.getJuzgadoOrigen(), consultaOperaciones.getProcedimiento(), consultaOperaciones.getNumExpediente(), consultaOperaciones.getAnyoApertura()), consultaOperaciones.getAnyoApertura(), consultaOperaciones.getNumExpediente(), consultaOperaciones.getProcedimiento(), consultaOperaciones.getJuzgadoDestino(), consultaOperaciones.getJuzgadoOrigen()), consultaOperaciones.getNumOperacion());
    }
}
