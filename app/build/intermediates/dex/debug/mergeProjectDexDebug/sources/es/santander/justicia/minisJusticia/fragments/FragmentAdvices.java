package es.santander.justicia.minisJusticia.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterAdvices;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.responses.avisos.Avisos;
import es.santander.justicia.minisJusticia.models.responses.avisos.AvisosResponseEnvelop;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentAdvices extends ActivityHomeLetrados.PlaceholderFragment implements AdapterAbstractRecycler.OnRecyclerClickListener {
    /* access modifiers changed from: private */
    public List<Avisos> mAvisosList;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (FragmentAdvices.this.mAvisosList == null) {
                FragmentAdvices.this.getCall();
            }
        }
    };
    /* access modifiers changed from: private */
    public RecyclerView mRecycler;
    /* access modifiers changed from: private */
    public RelativeLayout mRelativeNoAdvices;
    private boolean makeConn = true;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_advices, container, false);
        initUi(rootView);
        this.mRelativeNoAdvices = (RelativeLayout) rootView.findViewById(R.id.relative_no_advices);
        RecyclerView findViewById = rootView.findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(true);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.mMessageReceiver, new IntentFilter(ActivityHomeLetrados.USER_DETAIL_READY));
        return rootView;
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/avisos");
    }

    public void onResume() {
        super.onResume();
        if (!getActivity().mConnIsRunning) {
            getCall();
        }
        getActivity().findViewById(R.id.img_edit).setVisibility(0);
    }

    public void onDestroy() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.mMessageReceiver);
        super.onDestroy();
    }

    private void initUi(View rootView) {
        String value = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea1");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QFontTextView) rootView.findViewById(R.id.text_cau_santaner)).setText(String.format(getString(R.string.cau_santander), new Object[]{value}));
        }
        String value2 = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea2");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QFontTextView) rootView.findViewById(R.id.text_cau_justicia)).setText(String.format(getString(R.string.cau_justice_minister), new Object[]{value2}));
        }
    }

    /* access modifiers changed from: private */
    public void getCall() {
        ConnectionBuilder.getAdvicesCall(PreferencesHelper.newInstance(getActivity()).getString(Constants.PREFERECENCE_COD_UO)).enqueue(new RetrofitCallbackInterface<AvisosResponseEnvelop>(getActivity(), true, true) {
            public void onResponse(Call<AvisosResponseEnvelop> call, Response<AvisosResponseEnvelop> response) {
                try {
                    FragmentActivity activity = FragmentAdvices.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((AvisosResponseEnvelop) response.body()).getBinarySecurityToken() == null) ? null : ((AvisosResponseEnvelop) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(activity, securityToken, str)) {
                        try {
                            List unused = FragmentAdvices.this.mAvisosList = ((AvisosResponseEnvelop) response.body()).getBody().getAvisosReturnResponse().getAvisos();
                        } catch (Exception e) {
                            Log.d("FragmentAdvices", "error mAvisosList");
                        }
                        if (FragmentAdvices.this.mAvisosList == null || FragmentAdvices.this.mAvisosList.isEmpty()) {
                            FragmentAdvices.this.mRelativeNoAdvices.setVisibility(0);
                            FragmentAdvices.this.mRecycler.setVisibility(8);
                            return;
                        }
                        FragmentAdvices.this.mRelativeNoAdvices.setVisibility(8);
                        FragmentAdvices.this.mRecycler.setVisibility(0);
                        RecyclerView access$300 = FragmentAdvices.this.mRecycler;
                        FragmentActivity activity2 = FragmentAdvices.this.getActivity();
                        FragmentAdvices fragmentAdvices = FragmentAdvices.this;
                        access$300.setAdapter(new AdapterAdvices(activity2, fragmentAdvices, fragmentAdvices.mAvisosList));
                        return;
                    }
                    FragmentAdvices.this.mRelativeNoAdvices.setVisibility(0);
                    FragmentAdvices.this.mRecycler.setVisibility(8);
                } catch (IOException e2) {
                    Log.e("FragmentAdvices", "IOException", e2);
                }
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClickListener(int r14) {
        /*
            r13 = this;
            r0 = 0
            java.util.List<es.santander.justicia.minisJusticia.models.responses.avisos.Avisos> r1 = r13.mAvisosList
            java.lang.Object r1 = r1.get(r14)
            es.santander.justicia.minisJusticia.models.responses.avisos.Avisos r1 = (es.santander.justicia.minisJusticia.models.responses.avisos.Avisos) r1
            java.lang.String r1 = r1.getCodAviso()
            int r2 = r1.hashCode()
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r2) {
                case 65214: goto L_0x004c;
                case 66568: goto L_0x0042;
                case 66572: goto L_0x0038;
                case 66574: goto L_0x002e;
                case 68424: goto L_0x0024;
                case 81857: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x0056
        L_0x001a:
            java.lang.String r2 = "SAO"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = r3
            goto L_0x0057
        L_0x0024:
            java.lang.String r2 = "EBE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = 0
            goto L_0x0057
        L_0x002e:
            java.lang.String r2 = "CDO"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = r7
            goto L_0x0057
        L_0x0038:
            java.lang.String r2 = "CDM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = r4
            goto L_0x0057
        L_0x0042:
            java.lang.String r2 = "CDI"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = r5
            goto L_0x0057
        L_0x004c:
            java.lang.String r2 = "AVS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0019
            r1 = r6
            goto L_0x0057
        L_0x0056:
            r1 = -1
        L_0x0057:
            if (r1 == 0) goto L_0x010f
            java.lang.String r2 = "extra_operacion_seleccionada"
            java.lang.String r8 = "EUR"
            java.lang.String r9 = "extra_moneda"
            java.lang.String r10 = "preference_cod_uo"
            java.lang.String r11 = "extra_juzdestino"
            java.lang.String r12 = "extra_operacion"
            if (r1 == r7) goto L_0x00e3
            if (r1 == r6) goto L_0x00d9
            if (r1 == r5) goto L_0x00ad
            if (r1 == r4) goto L_0x00a2
            if (r1 == r3) goto L_0x0071
            goto L_0x0126
        L_0x0071:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r13.getActivity()
            java.lang.Class<es.santander.justicia.minisJusticia.ActivityDetalleMovimiento> r3 = es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.class
            r1.<init>(r2, r3)
            r0 = r1
            java.util.List<es.santander.justicia.minisJusticia.models.responses.avisos.Avisos> r1 = r13.mAvisosList
            java.lang.Object r1 = r1.get(r14)
            es.santander.justicia.minisJusticia.models.responses.avisos.Avisos r1 = (es.santander.justicia.minisJusticia.models.responses.avisos.Avisos) r1
            java.lang.String r1 = r1.getCodOperacion()
            r0.putExtra(r12, r1)
            java.util.List<es.santander.justicia.minisJusticia.models.responses.avisos.Avisos> r1 = r13.mAvisosList
            java.lang.Object r1 = r1.get(r14)
            es.santander.justicia.minisJusticia.models.responses.avisos.Avisos r1 = (es.santander.justicia.minisJusticia.models.responses.avisos.Avisos) r1
            java.lang.String r1 = r1.getCodOrganismo()
            java.lang.String r2 = "extra_organismo"
            r0.putExtra(r2, r1)
            r13.startActivity(r0)
            goto L_0x0126
        L_0x00a2:
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            es.santander.justicia.minisJusticia.ActivityHomeLetrados r1 = (es.santander.justicia.minisJusticia.ActivityHomeLetrados) r1
            r1.loadOperationsFromAdvices()
            goto L_0x0126
        L_0x00ad:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            java.lang.Class<es.santander.justicia.minisJusticia.ActivityDetalleOperacion> r4 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.class
            r1.<init>(r3, r4)
            r0 = r1
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            es.santander.justicia.utils.PreferencesHelper r1 = es.santander.justicia.utils.PreferencesHelper.newInstance(r1)
            java.lang.String r1 = r1.getString(r10)
            r0.putExtra(r11, r1)
            r0.putExtra(r9, r8)
            java.lang.String r1 = "PTE_ING"
            r0.putExtra(r12, r1)
            java.lang.String r1 = "INGRESOS"
            r0.putExtra(r2, r1)
            r13.startActivity(r0)
            goto L_0x0126
        L_0x00d9:
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            es.santander.justicia.minisJusticia.ActivityHomeLetrados r1 = (es.santander.justicia.minisJusticia.ActivityHomeLetrados) r1
            r1.loadAuthFromAdvices()
            goto L_0x0126
        L_0x00e3:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            java.lang.Class<es.santander.justicia.minisJusticia.ActivityDetalleOperacion> r4 = es.santander.justicia.minisJusticia.ActivityDetalleOperacion.class
            r1.<init>(r3, r4)
            r0 = r1
            androidx.fragment.app.FragmentActivity r1 = r13.getActivity()
            es.santander.justicia.utils.PreferencesHelper r1 = es.santander.justicia.utils.PreferencesHelper.newInstance(r1)
            java.lang.String r1 = r1.getString(r10)
            r0.putExtra(r11, r1)
            r0.putExtra(r9, r8)
            java.lang.String r1 = "PTE_CON"
            r0.putExtra(r12, r1)
            java.lang.String r1 = "CONFIRMACIONES"
            r0.putExtra(r2, r1)
            r13.startActivity(r0)
            goto L_0x0126
        L_0x010f:
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r13.getActivity()
            java.lang.Class<es.santander.justicia.minisJusticia.ActivitySeizures> r3 = es.santander.justicia.minisJusticia.ActivitySeizures.class
            r1.<init>(r2, r3)
            r0 = r1
            java.lang.String r1 = "extra_estado_embargo"
            java.lang.String r2 = "EN"
            r0.putExtra(r1, r2)
            r13.startActivity(r0)
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.fragments.FragmentAdvices.onItemClickListener(int):void");
    }
}
