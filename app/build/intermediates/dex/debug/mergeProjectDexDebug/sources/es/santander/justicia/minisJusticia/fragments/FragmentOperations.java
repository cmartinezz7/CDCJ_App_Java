package es.santander.justicia.minisJusticia.fragments;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterOperaciones;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.OperacionGlobal;
import es.santander.justicia.minisJusticia.models.responses.operacionesEjecutadas.OpeEjectResponseEnvelop;
import es.santander.justicia.minisJusticia.models.responses.operacionesPendientes.OpePenResponseEnvelop;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentOperations extends FragmentAbstractListados<OperacionGlobal> implements AdapterAbstractRecycler.OnRecyclerClickListener {
    public static final String COBROS = "COBROS";
    public static final String CONFIRMACIONES = "CONFIRMACIONES";
    public static final String DE = "DE";
    public static final String IN = "IN";
    public static final String INGRESOS = "INGRESOS";
    public static final String INGRESO_EJECUTADO = "PGI";
    public static final String MANDAMIENTO_DE_PAGO = "PGM";
    public static final String PTE_COB = "PTE_COB";
    public static final String PTE_CON = "PTE_CON";
    public static final String PTE_ING = "PTE_ING";

    /* access modifiers changed from: protected */
    public void initUi(View view) {
        if (getArguments().getInt(ActivityHomeLetrados.PlaceholderFragment.ARG_SECTION_NUMBER) == 2131886584) {
            TealiumHelper.trackView("/operaciones_ejecutadas");
            getDoneOperations();
        } else {
            TealiumHelper.trackView("/operaciones_pendientes");
            getPendintOperations();
        }
        view.findViewById(R.id.fab_button).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void showOperations(ArrayList<OperacionGlobal> operacionGlobals, int type) {
        this.mItems = operacionGlobals;
        this.mRecycler.setAdapter(new AdapterOperaciones(getActivity(), this, this.mItems, type));
    }

    private void getDoneOperations() {
        ConnectionBuilder.getOpeEjectConsultaCall(PreferencesHelper.newInstance(getActivity()).getString(Constants.PREFERECENCE_COD_UO), "EUR", 5).enqueue(new RetrofitCallbackInterface<OpeEjectResponseEnvelop>(getActivity(), true, true) {
            public void onResponse(Call<OpeEjectResponseEnvelop> call, Response<OpeEjectResponseEnvelop> response) {
                try {
                    FragmentActivity activity = FragmentOperations.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((OpeEjectResponseEnvelop) response.body()).getBinarySecurityToken() == null) ? null : ((OpeEjectResponseEnvelop) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        FragmentOperations.this.showOperations(((OpeEjectResponseEnvelop) response.body()).getBody().getOperacionesResponseGlobal().getOperacionGlobals(), 2);
                    } else {
                        Toast.makeText(FragmentOperations.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("getOpeEjectConsultCall", "IOException", e);
                }
            }
        });
    }

    private void getPendintOperations() {
        ConnectionBuilder.getOpePendientesConsultaCall(PreferencesHelper.newInstance(getActivity()).getString(Constants.PREFERECENCE_COD_UO)).enqueue(new RetrofitCallbackInterface<OpePenResponseEnvelop>(getActivity(), true, true) {
            public void onResponse(Call<OpePenResponseEnvelop> call, Response<OpePenResponseEnvelop> response) {
                try {
                    FragmentActivity activity = FragmentOperations.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((OpePenResponseEnvelop) response.body()).getBinarySecurityToken() == null) ? null : ((OpePenResponseEnvelop) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        FragmentOperations.this.showOperations(((OpePenResponseEnvelop) response.body()).getBody().getOperacionesResponseGlobal().getOperacionGlobals(), 1);
                    } else {
                        Toast.makeText(FragmentOperations.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("getOpePendConsultaCall", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClickListener(int r9) {
        /*
            r8 = this;
            android.content.Intent r0 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            java.lang.Class<es.santander.justicia.minisJusticia.ActivityDetalleOperacion> r2 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.class
            r0.<init>(r1, r2)
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            es.santander.justicia.utils.PreferencesHelper r1 = es.santander.justicia.utils.PreferencesHelper.newInstance(r1)
            java.lang.String r2 = "preference_cod_uo"
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "extra_juzdestino"
            r0.putExtra(r2, r1)
            java.util.ArrayList r1 = r8.mItems
            java.lang.Object r1 = r1.get(r9)
            es.santander.justicia.minisJusticia.models.responses.OperacionGlobal r1 = (es.santander.justicia.minisJusticia.models.responses.OperacionGlobal) r1
            java.lang.String r1 = r1.getCodmon()
            java.lang.String r2 = "extra_moneda"
            r0.putExtra(r2, r1)
            java.util.ArrayList r1 = r8.mItems
            java.lang.Object r1 = r1.get(r9)
            es.santander.justicia.minisJusticia.models.responses.OperacionGlobal r1 = (es.santander.justicia.minisJusticia.models.responses.OperacionGlobal) r1
            java.lang.String r1 = r1.getTipoOpe()
            int r2 = r1.hashCode()
            r3 = 2177(0x881, float:3.05E-42)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == r3) goto L_0x0083
            r3 = 2341(0x925, float:3.28E-42)
            if (r2 == r3) goto L_0x0079
            r3 = 457319128(0x1b4222d8, float:1.6058563E-22)
            if (r2 == r3) goto L_0x006f
            r3 = 457319140(0x1b4222e4, float:1.6058578E-22)
            if (r2 == r3) goto L_0x0065
            r3 = 457324868(0x1b423944, float:1.6065807E-22)
            if (r2 == r3) goto L_0x005b
        L_0x005a:
            goto L_0x008d
        L_0x005b:
            java.lang.String r2 = "PTE_ING"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005a
            r1 = r6
            goto L_0x008e
        L_0x0065:
            java.lang.String r2 = "PTE_CON"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005a
            r1 = r7
            goto L_0x008e
        L_0x006f:
            java.lang.String r2 = "PTE_COB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005a
            r1 = 0
            goto L_0x008e
        L_0x0079:
            java.lang.String r2 = "IN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005a
            r1 = r4
            goto L_0x008e
        L_0x0083:
            java.lang.String r2 = "DE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005a
            r1 = r5
            goto L_0x008e
        L_0x008d:
            r1 = -1
        L_0x008e:
            java.lang.String r2 = "extra_operacion_seleccionada"
            if (r1 == 0) goto L_0x00c4
            if (r1 == r7) goto L_0x00be
            if (r1 == r6) goto L_0x00b8
            java.lang.String r2 = "extra_operacion"
            if (r1 == r5) goto L_0x00b2
            if (r1 == r4) goto L_0x00ac
            java.util.ArrayList r1 = r8.mItems
            java.lang.Object r1 = r1.get(r9)
            es.santander.justicia.minisJusticia.models.responses.OperacionGlobal r1 = (es.santander.justicia.minisJusticia.models.responses.OperacionGlobal) r1
            java.lang.String r1 = r1.getTipoOpe()
            r0.putExtra(r2, r1)
            goto L_0x00ca
        L_0x00ac:
            java.lang.String r1 = "PGI"
            r0.putExtra(r2, r1)
            goto L_0x00ca
        L_0x00b2:
            java.lang.String r1 = "PGM"
            r0.putExtra(r2, r1)
            goto L_0x00ca
        L_0x00b8:
            java.lang.String r1 = "INGRESOS"
            r0.putExtra(r2, r1)
            goto L_0x00ca
        L_0x00be:
            java.lang.String r1 = "CONFIRMACIONES"
            r0.putExtra(r2, r1)
            goto L_0x00ca
        L_0x00c4:
            java.lang.String r1 = "COBROS"
            r0.putExtra(r2, r1)
        L_0x00ca:
            r8.startActivity(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.fragments.FragmentOperations.onItemClickListener(int):void");
    }
}
