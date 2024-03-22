package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityBusquedaExpedientes;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.activarExpediente.ActivarExpedienteResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.BuscExpResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentConsultaExpNew extends FragmentAbstractListados<DatosExpedienteNew> implements AdapterConsultaExp.OnActivarClick, AdapterConsultaExp.OnExpandClick, DialogSolicitudCalback {
    private final int RQ_SEARCH = 1;
    /* access modifiers changed from: private */
    public AdapterConsultaExp mAdapterConsultaExp;
    private Call<BuscExpResponseEnvelope> mCallBuscarExp;

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/consulta_expediente");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = data;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            getExpedients(intent.getStringExtra(Constants.EXTRA_JUZGA), intent.getStringExtra(Constants.EXTRA_JUZGORI), intent.getStringExtra(Constants.EXTRA_JPROCED), intent.getStringExtra(Constants.EXTRA_JNUMEXP), intent.getStringExtra(Constants.EXTRA_JANOAPEX), intent.getStringExtra(Constants.EXTRA_MONEDA), intent.getStringExtra(Constants.EXTRA_STATE), intent.getStringExtra(Constants.EXTRA_FECHA_DESDE) != null ? intent.getStringExtra(Constants.EXTRA_FECHA_DESDE) : CommonUtils.getDateMonthAgo(), intent.getStringExtra(Constants.EXTRA_FECHA_HASTA) != null ? intent.getStringExtra(Constants.EXTRA_FECHA_HASTA) : CommonUtils.getCurrentDate(), intent.getStringExtra(Constants.EXTRA_TIPOS_SELECCION), false);
        }
    }

    /* access modifiers changed from: protected */
    public void initUi(View view) {
        getExpedients(PreferencesHelper.newInstance(getActivity()).getString(Constants.PREFERECENCE_COD_UO), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, CommonUtils.getDateMonthAgo(), CommonUtils.getCurrentDate(), (String) null, false);
        this.mFabSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentConsultaExpNew.this.startActivityForResult(new Intent(FragmentConsultaExpNew.this.getActivity(), ActivityBusquedaExpedientes.class), 1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void initAdapter() {
        this.mAdapterConsultaExp = new AdapterConsultaExp(getActivity(), this, this, this.mItems);
        this.mRecycler.setAdapter(this.mAdapterConsultaExp);
    }

    /* access modifiers changed from: private */
    public void getExpedients(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String moneda, String state, String fechaDesde, String fechaHasta, String tipoSeleccion, boolean repeatCall) {
        if (!repeatCall) {
            this.mCallBuscarExp = ConnectionBuilder.getBuscarExpedientesCall(juzga, juzgori, jproced, jnumexp, janoapex, moneda, state, fechaDesde, fechaHasta, tipoSeleccion);
        }
        this.mCallBuscarExp.clone().enqueue(new RetrofitCallbackInterface<BuscExpResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<BuscExpResponseEnvelope> call, Response<BuscExpResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentConsultaExpNew.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((BuscExpResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((BuscExpResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(activity, securityToken, str)) {
                        try {
                            FragmentConsultaExpNew fragmentConsultaExpNew = FragmentConsultaExpNew.this;
                            fragmentConsultaExpNew.mItems = fragmentConsultaExpNew.getOrderExpedientes((ArrayList) CommonUtils.removeDatosPaginacionInBuscarExp(((BuscExpResponseEnvelope) response.body()).getBody().getBuscExpResponseReturn().getDatosExpedienteResponses()));
                        } catch (Exception e) {
                            Log.d("FragmentConsultaExpNew", "Error mItems");
                        }
                        if (FragmentConsultaExpNew.this.mItems != null) {
                            FragmentConsultaExpNew.this.initAdapter();
                        }
                    }
                } catch (IOException e2) {
                    Log.e("getExpedients", "IOException", e2);
                }
                FragmentConsultaExpNew.this.handleResultsVisibility();
            }
        });
    }

    private void getDetailExpediente(int position) {
        TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (expandir)");
        final int i = position;
        ConnectionBuilder.getDetalleExpCall((DatosExpedienteNew) this.mItems.get(position)).enqueue(new RetrofitCallbackInterface<DetalleExpResponseEnvelope>(getActivity(), 1, true) {
            public void onResponse(Call<DetalleExpResponseEnvelope> call, Response<DetalleExpResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentConsultaExpNew.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((DetalleExpResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetalleExpResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        ArrayList<DetalleExpDatosExpDetail.DetalleExpSaldos> list = ((DetalleExpResponseEnvelope) response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getSaldos();
                        if (list == null || !list.isEmpty()) {
                            int contChilds = 0;
                            Iterator<DetalleExpDatosExpDetail.DetalleExpSaldos> it = ((DetalleExpResponseEnvelope) response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getSaldos().iterator();
                            while (it.hasNext()) {
                                DetalleExpDatosExpDetail.DetalleExpSaldos saldos = it.next();
                                new DatosExpedienteNew(saldos);
                                ((DatosExpedienteNew) FragmentConsultaExpNew.this.mItems.get(i)).setImpInterCostas(((DetalleExpResponseEnvelope) response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getImpInterCostas());
                                FragmentConsultaExpNew.this.mItems.add(i + contChilds + 1, new DatosExpedienteNew(saldos));
                                contChilds++;
                            }
                            FragmentConsultaExpNew.this.mAdapterConsultaExp.setExpandedCard(i);
                            FragmentConsultaExpNew.this.mAdapterConsultaExp.notifyDataSetChanged();
                        } else if (FragmentConsultaExpNew.this.getActivity() != null) {
                            CommonUtils.showAlertNoProceedingData(FragmentConsultaExpNew.this.getActivity());
                        }
                        FragmentConsultaExpNew.this.mRecycler.scrollToPosition(i);
                        return;
                    }
                    Toast.makeText(FragmentConsultaExpNew.this.getActivity(), "Error al invocar al servicio, vuelva a intentarlo", 1).show();
                } catch (IOException e) {
                    Log.e("getDetailExpediente", "IOException", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void activarExpediente(String anoAperturaExpediente, String numeroExpediente, String codigoJuzgadoDestino, String codigoJuzgadoOrigen, String codigoProcedimiento, String codigoExpediente, String codigoMoneda, String firma) {
        TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (activar)");
        ConnectionBuilder.getActivarExpedienteCall(anoAperturaExpediente, numeroExpediente, codigoJuzgadoDestino, codigoJuzgadoOrigen, codigoProcedimiento, codigoExpediente, codigoMoneda, firma).enqueue(new RetrofitCallbackInterface<ActivarExpedienteResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<ActivarExpedienteResponseEnvelope> call, Response<ActivarExpedienteResponseEnvelope> response) {
                try {
                    if (!super.finishConnection(FragmentConsultaExpNew.this.getActivity(), (response.body() == null || ((ActivarExpedienteResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((ActivarExpedienteResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken(), response.code() == 500 ? response.errorBody().string() : null)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        FragmentConsultaExpNew.this.getExpedients((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, true);
                        CommonUtils.showPopUpActionDone(FragmentConsultaExpNew.this.getActivity(), FragmentConsultaExpNew.this.getView(), R.string.pop_up_finish_operation, (PopUpActionDone) null);
                        return;
                    }
                    Toast.makeText(FragmentConsultaExpNew.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                } catch (IOException e) {
                    Log.e("activarExpediente", "IOException", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ArrayList<DatosExpedienteNew> getOrderExpedientes(ArrayList<DatosExpedienteNew> response) {
        ArrayList<DatosExpedienteNew> retValue = new ArrayList<>();
        ArrayList<DatosExpedienteNew> auxLeters = new ArrayList<>();
        ArrayList<DatosExpedienteNew> auxNormal = new ArrayList<>();
        Pattern chars = Pattern.compile("[a-zA-Z]+");
        Iterator<DatosExpedienteNew> it = response.iterator();
        while (it.hasNext()) {
            DatosExpedienteNew datosExpedienteNew = it.next();
            if (chars.matcher(datosExpedienteNew.getCodExpediente()).find()) {
                auxLeters.add(datosExpedienteNew);
            } else {
                auxNormal.add(datosExpedienteNew);
            }
        }
        Collections.sort(auxLeters, new Comparator<DatosExpedienteNew>() {
            public int compare(DatosExpedienteNew o1, DatosExpedienteNew o2) {
                return o1.getCodExpediente().compareTo(o2.getCodExpediente());
            }
        });
        retValue.addAll(auxLeters);
        Collections.sort(auxNormal, new Comparator<DatosExpedienteNew>() {
            public int compare(DatosExpedienteNew o1, DatosExpedienteNew o2) {
                return o1.getCodExpediente().compareTo(o2.getCodExpediente());
            }
        });
        retValue.addAll(auxNormal);
        return retValue;
    }

    public void onOperativaClicked(String motive, String pass, int textIdResource, int position) {
        Log.d("Silos", motive == null ? "motive null" : motive);
        Log.d("Silos", pass == null ? "pass null" : pass);
    }

    public void onItemClickListener(int position, int oldPosition) {
        int childsRemoved = 0;
        if (oldPosition != -1) {
            boolean removing = true;
            while (removing) {
                if (((DatosExpedienteNew) this.mItems.get(oldPosition)).isChild()) {
                    this.mItems.remove(oldPosition);
                    childsRemoved++;
                }
                removing = oldPosition < this.mItems.size() && ((DatosExpedienteNew) this.mItems.get(oldPosition)).isChild();
            }
            ((DatosExpedienteNew) this.mItems.get(oldPosition - childsRemoved)).setExpanded(false);
            this.mAdapterConsultaExp.notifyDataSetChanged();
        }
        if (position + 1 == oldPosition) {
            ((DatosExpedienteNew) this.mItems.get(position)).setExpanded(false);
            this.mAdapterConsultaExp.setExpandedCard(-1);
        } else if (position + 1 > oldPosition) {
            ((DatosExpedienteNew) this.mItems.get(position - childsRemoved)).setExpanded(true);
            if (!(oldPosition == -1 || position == oldPosition)) {
                ((DatosExpedienteNew) this.mItems.get(oldPosition)).setExpanded(true);
            }
            getDetailExpediente(position - childsRemoved);
        } else {
            ((DatosExpedienteNew) this.mItems.get(position)).setExpanded(true);
            getDetailExpediente(position);
        }
    }

    public void onActivarClickListener(int position) {
        CommonUtils.showOperativaPopUp(getActivity(), getView(), new DialogSolicitudCalback() {
            public void onOperativaClicked(String motive, String pass, int textResource, int position) {
                DatosExpedienteNew datosExpedienteNew = (DatosExpedienteNew) FragmentConsultaExpNew.this.mItems.get(position);
                FragmentConsultaExpNew.this.activarExpediente(datosExpedienteNew.getJanoapex(), datosExpedienteNew.getJnumexp(), datosExpedienteNew.getJuzga(), datosExpedienteNew.getJuzgori(), datosExpedienteNew.getJproced(), datosExpedienteNew.getCodExpAlt(), datosExpedienteNew.getCodmon(), pass);
            }
        }, false, R.string.active_swype, position);
    }
}
