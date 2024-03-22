package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuarioEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import es.santander.justicia.utils.safetynet.ComparadorAutorizacionesUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentAuhtJuzgados extends FragmentAbstractListados<AutorizacionesUsuario> implements AdapterAbstractRecycler.OnRecyclerClickListener {
    private static final int RQ_MODIFY = 33;
    private static final int RQ_SEARCH = 32;

    /* access modifiers changed from: protected */
    public void initUi(View view) {
        setButtons();
        getDefaultExpedients();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        if (requestCode != 32) {
            if (requestCode == 33) {
                getDefaultExpedients();
            }
        } else if (data.getExtras().getSerializable(Constants.EXTRA_AUTORIZATION) != null) {
            AuthJuzgadosArg0Detail authJuzgadosArg0Detail = (AuthJuzgadosArg0Detail) data.getExtras().getSerializable(Constants.EXTRA_AUTORIZATION);
            getExpedients(authJuzgadosArg0Detail.getCodNumDocumento(), PreferencesHelper.newInstance(getContext()).getString(Constants.PREFERECENCE_COD_UO), authJuzgadosArg0Detail.getCodTipoDocumento(), authJuzgadosArg0Detail.getFechaFinal(), authJuzgadosArg0Detail.getFechaInicial(), authJuzgadosArg0Detail.getIndCaducadas());
        }
    }

    private void getDefaultExpedients() {
        getExpedients("", PreferencesHelper.newInstance(getContext()).getString(Constants.PREFERECENCE_COD_UO), "N", DateUtils.formatDateToRequest(CommonUtils.getDateNextMonthToShow()), DateUtils.formatDateToRequest(CommonUtils.getCurrentDateToShow()), "0");
    }

    private void setButtons() {
        this.mFabSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FragmentAuhtJuzgados.this.getActivity(), ActivityAltaAutorizacion.class);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.EXTRA_SEARCH, Constants.EXTRA_SEARCH);
                intent.putExtras(bundle);
                FragmentAuhtJuzgados.this.startActivityForResult(intent, 32);
            }
        });
        this.mButtonNew.setVisibility(0);
        this.mButtonNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentAuhtJuzgados.this.startActivity(new Intent(FragmentAuhtJuzgados.this.getActivity(), ActivityAltaAutorizacion.class));
            }
        });
    }

    private void getExpedients(String docuemnt, String organismo, String tipoDoc, String fechaFinal, String fechaInicial, String caducadas) {
        ConnectionBuilder.getAutorizacionesJuzagado(docuemnt, organismo, tipoDoc, fechaFinal, fechaInicial, caducadas).clone().enqueue(new RetrofitCallbackInterface<AutorizacionesUsuarioEnvelope>(getActivity()) {
            public void onResponse(Call<AutorizacionesUsuarioEnvelope> call, Response<AutorizacionesUsuarioEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuhtJuzgados.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((AutorizacionesUsuarioEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((AutorizacionesUsuarioEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(activity, securityToken, str)) {
                        FragmentAuhtJuzgados.this.mItems = (ArrayList) CommonUtils.removeDatosPaginacionInAutorizacionUsuario(((AutorizacionesUsuarioEnvelope) response.body()).getBody().getAutorizacionesUsuarioReturn().autorizacionesUsuarios());
                        if (FragmentAuhtJuzgados.this.mItems.size() == 0) {
                            FragmentAuhtJuzgados.this.mButtonNew.setVisibility(8);
                        } else {
                            FragmentAuhtJuzgados.this.mButtonNew.setVisibility(0);
                        }
                        Collections.sort(FragmentAuhtJuzgados.this.mItems, new ComparadorAutorizacionesUsuario());
                        RecyclerView recyclerView = FragmentAuhtJuzgados.this.mRecycler;
                        FragmentActivity activity2 = FragmentAuhtJuzgados.this.getActivity();
                        FragmentAuhtJuzgados fragmentAuhtJuzgados = FragmentAuhtJuzgados.this;
                        recyclerView.setAdapter(new AdapterAuthCourts(activity2, fragmentAuhtJuzgados, fragmentAuhtJuzgados.mItems));
                    }
                } catch (IOException e) {
                    Log.e("getExpedients", "IOException", e);
                }
                FragmentAuhtJuzgados.this.handleResultsVisibility();
            }

            public void onFailure(Call<AutorizacionesUsuarioEnvelope> call, Throwable t) {
                super.onFailure(call, t);
                FragmentAuhtJuzgados.this.mButtonNew.setVisibility(8);
            }
        });
    }

    public void onItemClickListener(int position) {
        Intent intent = new Intent(getActivity(), ActivityDetalleAuthorizacion.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.EXTRA_AUTORIZATION, (Serializable) this.mItems.get(position));
        intent.putExtras(bundle);
        startActivityForResult(intent, 33);
    }
}
