package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.ViewPagerDetalleMovimientoAdapter;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.AutorizacionRetrocesionDto;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityDetalleMovimiento extends ActivityAbstractLetrados implements DialogSolicitudCalback, PopUpActionDone {
    /* access modifiers changed from: private */
    public ImageView bullet1;
    /* access modifiers changed from: private */
    public ImageView bullet2;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public int currentPage = -1;
    /* access modifiers changed from: private */
    public MovementItemDTO movementItemDTO;
    private TextView txtExpediente;
    private TextView txtMandamiento;
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_movimiento);
        this.context = getBaseContext();
        getMovement();
    }

    /* access modifiers changed from: private */
    public void showMovementInfo(String nroExpediente, String anulationMotive) {
        this.txtExpediente = (TextView) findViewById(R.id.txt_movimiento_expediente);
        this.txtMandamiento = (TextView) findViewById(R.id.txt_movimiento_mandamiento);
        this.txtExpediente.setText(CommonUtils.getProceedingFormatted(nroExpediente));
        this.txtMandamiento.setText(this.movementItemDTO.getSerieYMandamiento());
        this.bullet1 = (ImageView) findViewById(R.id.iv_bullet1);
        this.bullet2 = (ImageView) findViewById(R.id.iv_bullet2);
        this.bullet1.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bullet_active_white));
        this.bullet2.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bullet_inactive_white));
        ViewPager findViewById = findViewById(R.id.container_viewpager_detalle);
        this.viewPager = findViewById;
        findViewById.setAdapter(new ViewPagerDetalleMovimientoAdapter(getSupportFragmentManager(), this.movementItemDTO));
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (position == 0) {
                    ActivityDetalleMovimiento.this.bullet1.setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.this.context, R.drawable.ic_bullet_active_white));
                    ActivityDetalleMovimiento.this.bullet2.setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.this.context, R.drawable.ic_bullet_inactive_white));
                    int unused = ActivityDetalleMovimiento.this.currentPage = 0;
                } else if (position == 1) {
                    ActivityDetalleMovimiento.this.bullet1.setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.this.context, R.drawable.ic_bullet_inactive_white));
                    ActivityDetalleMovimiento.this.bullet2.setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.this.context, R.drawable.ic_bullet_active_white));
                    int unused2 = ActivityDetalleMovimiento.this.currentPage = 1;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void getMovement() {
        Bundle extra = getIntent().getExtras();
        if (extra == null) {
            return;
        }
        if (extra.containsKey("movimiento")) {
            this.movementItemDTO = (MovementItemDTO) extra.getSerializable("movimiento");
            showMovementInfo(extra.getString("expediente"), (String) null);
            return;
        }
        ((TextView) findViewById(R.id.textTitleIng)).setText(getString(R.string.auth_incoming));
        getMovementFromServer(extra.getString(Constants.EXTRA_OPERACION), extra.getString(Constants.EXTRA_ORGANISMO));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int i;
        super.onResume();
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && (i = this.currentPage) != 1) {
            viewPager2.setCurrentItem(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/detalle_movimiento");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void acceptOrDeny(boolean r8) {
        /*
            r7 = this;
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r7.findViewById(r0)
            if (r8 == 0) goto L_0x000d
            r0 = 2131886108(0x7f12001c, float:1.9406786E38)
            goto L_0x0010
        L_0x000d:
            r0 = 2131886375(0x7f120127, float:1.9407327E38)
        L_0x0010:
            r5 = r0
            r6 = 0
            r4 = 1
            r1 = r7
            r3 = r7
            es.santander.justicia.utils.CommonUtils.showOperativaPopUp(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.acceptOrDeny(boolean):void");
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        if (textResource == 2131886108) {
            resolverAutorizacion(new AutorizacionRetrocesionDto(getIntent().getExtras().getString(Constants.EXTRA_OPERACION), getIntent().getExtras().getString(Constants.EXTRA_ORGANISMO), "T", motive), pass);
        } else if (textResource == 2131886375) {
            resolverAutorizacion(new AutorizacionRetrocesionDto(getIntent().getExtras().getString(Constants.EXTRA_OPERACION), getIntent().getExtras().getString(Constants.EXTRA_ORGANISMO), "R", motive), pass);
        }
    }

    public void onPopUpClosed() {
        onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleMovimiento] */
    private void getMovementFromServer(String numOper, final String juzga) {
        ConnectionBuilder.getDetalleMovimientoCall(numOper, PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO)).enqueue(new RetrofitCallbackInterface<DetalleMovimientoResponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleMovimiento] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ IOException -> 0x00eb }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IOException -> 0x00eb }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope> r6, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope> r7) {
                /*
                    r5 = this;
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r0 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope) r1     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x00eb }
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope) r1     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x00eb }
                    goto L_0x0026
                L_0x0025:
                    r1 = r2
                L_0x0026:
                    int r3 = r7.code()     // Catch:{ IOException -> 0x00eb }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0036
                    okhttp3.ResponseBody r2 = r7.errorBody()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x00eb }
                L_0x0036:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x00eb }
                    if (r0 == 0) goto L_0x00ea
                    okhttp3.ResponseBody r0 = r7.errorBody()     // Catch:{ IOException -> 0x00eb }
                    if (r0 != 0) goto L_0x00da
                    java.lang.Object r0 = r7.body()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope r0 = (es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope) r0     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseBody r0 = r0.getBody()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoReturn r0 = r0.getDetalleMovimientoReturn()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoReturndetail r0 = r0.getDetalleMovimientoReturndetail()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion r0 = r0.getDatosOperacion()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r2 = r4     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.dto.MovementItemDTO r2 = es.santander.justicia.utils.CommonUtils.getMovmentItemDTO(r0, r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.dto.MovementItemDTO unused = r1.movementItemDTO = r2     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    android.content.Intent r1 = r1.getIntent()     // Catch:{ IOException -> 0x00eb }
                    android.os.Bundle r1 = r1.getExtras()     // Catch:{ IOException -> 0x00eb }
                    if (r1 == 0) goto L_0x008c
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r2 = r0.getDatosExpediente()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r2 = r2.getCodExpediente()     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r3 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    android.content.Intent r3 = r3.getIntent()     // Catch:{ IOException -> 0x00eb }
                    android.os.Bundle r3 = r3.getExtras()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r4 = "extra_motive_anulation"
                    java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00eb }
                    r1.showMovementInfo(r2, r3)     // Catch:{ IOException -> 0x00eb }
                L_0x008c:
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    r2 = 2131362808(0x7f0a03f8, float:1.8345407E38)
                    android.view.View r1 = r1.findViewById(r2)     // Catch:{ IOException -> 0x00eb }
                    android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r2 = r0.getMotivoSolicitud()     // Catch:{ IOException -> 0x00eb }
                    r1.setText(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    r2 = 2131362394(0x7f0a025a, float:1.8344567E38)
                    android.view.View r1 = r1.findViewById(r2)     // Catch:{ IOException -> 0x00eb }
                    r2 = 0
                    r1.setVisibility(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    r3 = 2131362395(0x7f0a025b, float:1.834457E38)
                    android.view.View r1 = r1.findViewById(r3)     // Catch:{ IOException -> 0x00eb }
                    r1.setVisibility(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    r2 = 2131361965(0x7f0a00ad, float:1.8343697E38)
                    android.view.View r1 = r1.findViewById(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento$2$1 r2 = new es.santander.justicia.minisJusticia.ActivityDetalleMovimiento$2$1     // Catch:{ IOException -> 0x00eb }
                    r2.<init>()     // Catch:{ IOException -> 0x00eb }
                    r1.setOnClickListener(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r1 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    r2 = 2131361968(0x7f0a00b0, float:1.8343703E38)
                    android.view.View r1 = r1.findViewById(r2)     // Catch:{ IOException -> 0x00eb }
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento$2$2 r2 = new es.santander.justicia.minisJusticia.ActivityDetalleMovimiento$2$2     // Catch:{ IOException -> 0x00eb }
                    r2.<init>()     // Catch:{ IOException -> 0x00eb }
                    r1.setOnClickListener(r2)     // Catch:{ IOException -> 0x00eb }
                    goto L_0x00ea
                L_0x00da:
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r0 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x00eb }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x00eb }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x00eb }
                    r0.show()     // Catch:{ IOException -> 0x00eb }
                L_0x00ea:
                    goto L_0x00f3
                L_0x00eb:
                    r0 = move-exception
                    java.lang.String r1 = "getMoveDetail"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x00f3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.AnonymousClass2.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleMovimiento] */
    private void resolverAutorizacion(AutorizacionRetrocesionDto autorizacionRetrocesionDto, String firma) {
        TealiumHelper.trackEvent("/autorizacion_retrocesion", "autorizacion retrocesion(firmar)");
        ConnectionBuilder.getResolverAutorizacon(autorizacionRetrocesionDto, firma).enqueue(new RetrofitCallbackInterface<ResolverAutorizacionEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleMovimiento] */
            /* JADX WARNING: type inference failed for: r0v7, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleMovimiento] */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002e A[Catch:{ IOException -> 0x0065 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[Catch:{ IOException -> 0x0065 }] */
            /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(retrofit2.Call<es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope> r6, retrofit2.Response<es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope> r7) {
                /*
                    r5 = this;
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r0 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x0065 }
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x0065 }
                    java.lang.String r2 = ""
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x0065 }
                    es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope) r1     // Catch:{ IOException -> 0x0065 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0065 }
                    if (r1 == 0) goto L_0x0025
                    java.lang.Object r1 = r7.body()     // Catch:{ IOException -> 0x0065 }
                    es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope r1 = (es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope) r1     // Catch:{ IOException -> 0x0065 }
                    es.santander.justicia.minisJusticia.models.responses.BinarySecurityToken r1 = r1.getBinarySecurityToken()     // Catch:{ IOException -> 0x0065 }
                    java.lang.String r1 = r1.getSecurityToken()     // Catch:{ IOException -> 0x0065 }
                    goto L_0x0026
                L_0x0025:
                    r1 = r2
                L_0x0026:
                    int r3 = r7.code()     // Catch:{ IOException -> 0x0065 }
                    r4 = 500(0x1f4, float:7.0E-43)
                    if (r3 != r4) goto L_0x0036
                    okhttp3.ResponseBody r2 = r7.errorBody()     // Catch:{ IOException -> 0x0065 }
                    java.lang.String r2 = r2.string()     // Catch:{ IOException -> 0x0065 }
                L_0x0036:
                    boolean r0 = super.finishConnection(r0, r1, r2)     // Catch:{ IOException -> 0x0065 }
                    if (r0 == 0) goto L_0x0064
                    okhttp3.ResponseBody r0 = r7.errorBody()     // Catch:{ IOException -> 0x0065 }
                    if (r0 != 0) goto L_0x0054
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r0 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x0065 }
                    r1 = 16908290(0x1020002, float:2.3877235E-38)
                    android.view.View r1 = r0.findViewById(r1)     // Catch:{ IOException -> 0x0065 }
                    r2 = 2131886704(0x7f120270, float:1.9407994E38)
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r3 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x0065 }
                    es.santander.justicia.utils.CommonUtils.showPopUpActionDone(r0, r1, r2, r3)     // Catch:{ IOException -> 0x0065 }
                    goto L_0x0064
                L_0x0054:
                    es.santander.justicia.minisJusticia.ActivityDetalleMovimiento r0 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.this     // Catch:{ IOException -> 0x0065 }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ IOException -> 0x0065 }
                    java.lang.String r1 = "Se ha producido un error al conectar con el servidor"
                    r2 = 1
                    android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)     // Catch:{ IOException -> 0x0065 }
                    r0.show()     // Catch:{ IOException -> 0x0065 }
                L_0x0064:
                    goto L_0x006d
                L_0x0065:
                    r0 = move-exception
                    java.lang.String r1 = "getConfOpPteConf"
                    java.lang.String r2 = "IOException"
                    android.util.Log.e(r1, r2, r0)
                L_0x006d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.AnonymousClass3.onResponse(retrofit2.Call, retrofit2.Response):void");
            }
        });
    }
}
