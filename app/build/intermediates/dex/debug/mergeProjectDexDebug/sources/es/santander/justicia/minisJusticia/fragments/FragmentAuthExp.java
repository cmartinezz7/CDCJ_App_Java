package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityBusquedaAuthExpedi;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.aceptarSolicitud.AceptarSolicitudResponseEnvelopment;
import es.santander.justicia.minisJusticia.models.responses.bajaSolicitud.BajaSolicitudResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscPetAccResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import es.santander.justicia.minisJusticia.models.responses.denegarSolicitud.DenegarSolicitudResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose.DetallePetAccReponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.modificarSolicitud.ModificarSolicitudResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import retrofit2.Call;
import retrofit2.Response;

public class FragmentAuthExp extends FragmentAbstractListados<BuscarPeticionesAcceso> implements AdapterExpaAuthExpe.OnOthersClick, DialogSolicitudCalback, PopUpActionDone {
    private static final int RQ_SEARCH = 1;
    private final int OPERATIVE_ACEPTAR = 1;
    private final int OPERATIVE_BAJA = 2;
    private final int OPERATIVE_DENEGAR = 3;
    private final int OPERATIVE_MODIFICAR = 4;
    /* access modifiers changed from: private */
    public AdapterExpaAuthExpe mAdapterExpaAuthExpe;
    /* access modifiers changed from: private */
    public int mCurrentItem;
    private Call<BuscPetAccResponseEnvelope> mLasgGetExpedientesCall;
    private View.OnClickListener mOthersClickListener;

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/autorizacion_expediente");
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            getExpedients(data.getStringExtra(Constants.EXTRA_JUZGA), data.getStringExtra(Constants.EXTRA_JUZGORI), data.getStringExtra(Constants.EXTRA_JPROCED), data.getStringExtra(Constants.EXTRA_JNUMEXP), data.getStringExtra(Constants.EXTRA_JANOAPEX), data.getStringExtra(Constants.EXTRA_STATE), false);
        }
    }

    /* access modifiers changed from: protected */
    public void initUi(View view) {
        getExpedients(PreferencesHelper.newInstance(getActivity()).getString(Constants.PREFERECENCE_COD_UO), (String) null, (String) null, (String) null, (String) null, getArguments().getString(Constants.EXTRA_FILTER, (String) null), false);
        this.mFabSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentAuthExp.this.startActivityForResult(new Intent(FragmentAuthExp.this.getActivity(), ActivityBusquedaAuthExpedi.class), 1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void initAdapter() {
        AdapterExpaAuthExpe adapterExpaAuthExpe = new AdapterExpaAuthExpe(getActivity(), this.mItems, this);
        this.mAdapterExpaAuthExpe = adapterExpaAuthExpe;
        adapterExpaAuthExpe.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            public void onParentExpanded(int parentPosition) {
                FragmentAuthExp.this.mRecycler.scrollToPosition(parentPosition);
                FragmentAuthExp.this.mAdapterExpaAuthExpe.notifyDataSetChanged();
            }

            public void onParentCollapsed(int parentPosition) {
            }
        });
        setOthersClickListener();
        this.mRecycler.setAdapter(this.mAdapterExpaAuthExpe);
    }

    private void getExpedients(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String state, boolean repeatLastConnection) {
        if (!repeatLastConnection) {
            this.mLasgGetExpedientesCall = ConnectionBuilder.getBuscPetCall(juzga, juzgori, jproced, jnumexp, janoapex, state);
        }
        this.mLasgGetExpedientesCall.clone().enqueue(new RetrofitCallbackInterface<BuscPetAccResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<BuscPetAccResponseEnvelope> call, Response<BuscPetAccResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((BuscPetAccResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((BuscPetAccResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(activity, securityToken, str)) {
                        try {
                            FragmentAuthExp.this.mItems = (ArrayList) CommonUtils.removeDatosPaginacionInBusqueda(((BuscPetAccResponseEnvelope) response.body()).getBody().getBuscPetAccResponseReturn().getBuscarPeticionesAccesos());
                        } catch (Exception e) {
                            Log.d("FragmentAuthExp", "error mItems");
                        }
                        if (FragmentAuthExp.this.mItems != null) {
                            Collections.sort(FragmentAuthExp.this.mItems, new Comparator<BuscarPeticionesAcceso>() {
                                public int compare(BuscarPeticionesAcceso o1, BuscarPeticionesAcceso o2) {
                                    return o2.getFecModificacionPeticion().compareTo(o1.getFecModificacionPeticion());
                                }
                            });
                            FragmentAuthExp.this.initAdapter();
                        }
                    }
                } catch (IOException e2) {
                    Log.e("getExpedients", "IOException", e2);
                }
                FragmentAuthExp.this.handleResultsVisibility();
            }
        });
    }

    /* access modifiers changed from: private */
    public void acceptSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
        TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (aceptar)");
        ConnectionBuilder.getAceptSoliCall(detallePetAcceDetail).enqueue(new RetrofitCallbackInterface<AceptarSolicitudResponseEnvelopment>(getActivity(), true, true) {
            public void onResponse(Call<AceptarSolicitudResponseEnvelopment> call, Response<AceptarSolicitudResponseEnvelopment> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((AceptarSolicitudResponseEnvelopment) response.body()).getBinarySecurityToken() == null) ? null : ((AceptarSolicitudResponseEnvelopment) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        CommonUtils.showPopUpActionDone(FragmentAuthExp.this.getActivity(), FragmentAuthExp.this.getView(), R.string.pop_up_finish_operation, FragmentAuthExp.this);
                    } else {
                        Toast.makeText(FragmentAuthExp.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("acceptSolicitud", "IOException", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void denegarSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
        TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (denegar)");
        ConnectionBuilder.getDeniedSoliCall(detallePetAcceDetail).enqueue(new RetrofitCallbackInterface<DenegarSolicitudResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<DenegarSolicitudResponseEnvelope> call, Response<DenegarSolicitudResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((DenegarSolicitudResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DenegarSolicitudResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        CommonUtils.showPopUpActionDone(FragmentAuthExp.this.getActivity(), FragmentAuthExp.this.getView(), R.string.pop_up_finish_operation, FragmentAuthExp.this);
                    } else {
                        Toast.makeText(FragmentAuthExp.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("denegarSolicitud", "IOException", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void bajaSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
        TealiumHelper.trackEvent("/autorizacion_expediente", "autorizacion_expediente (baja)");
        ConnectionBuilder.getBajaSoliCall(detallePetAcceDetail).enqueue(new RetrofitCallbackInterface<BajaSolicitudResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<BajaSolicitudResponseEnvelope> call, Response<BajaSolicitudResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((BajaSolicitudResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((BajaSolicitudResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        CommonUtils.showPopUpActionDone(FragmentAuthExp.this.getActivity(), FragmentAuthExp.this.getView(), R.string.pop_up_finish_operation, FragmentAuthExp.this);
                    } else {
                        Toast.makeText(FragmentAuthExp.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("bajaSolicitud", "IOException", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void modificarSolicitud(OperativasGlobalArg0Detail detallePetAcceDetail) {
        TealiumHelper.trackEvent("/autorizacion_cuenta_expediente", "modificar_solicitud");
        ConnectionBuilder.getModificarSoliCall(detallePetAcceDetail).enqueue(new RetrofitCallbackInterface<ModificarSolicitudResponseEnvelope>(getActivity(), true, true) {
            public void onResponse(Call<ModificarSolicitudResponseEnvelope> call, Response<ModificarSolicitudResponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((ModificarSolicitudResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((ModificarSolicitudResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        CommonUtils.showPopUpActionDone(FragmentAuthExp.this.getActivity(), FragmentAuthExp.this.getView(), R.string.pop_up_finish_operation, FragmentAuthExp.this);
                    } else {
                        Toast.makeText(FragmentAuthExp.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                    }
                } catch (IOException e) {
                    Log.e("modificarSolicitud", "IOException", e);
                }
            }
        });
    }

    private void getDetailSolicitud(String anioAp, String codDoc, String cdExp, String codTipDoc, String fechaReg, int nexOperation, String motivo, String pass) {
        final String str = motivo;
        final String str2 = pass;
        final int i = nexOperation;
        ConnectionBuilder.getDetallePetAcc(anioAp, codDoc, cdExp, codTipDoc, fechaReg).enqueue(new RetrofitCallbackInterface<DetallePetAccReponseEnvelope>(getActivity(), 1, true) {
            public void onResponse(Call<DetallePetAccReponseEnvelope> call, Response<DetallePetAccReponseEnvelope> response) {
                try {
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    String str = null;
                    String securityToken = (response.body() == null || ((DetallePetAccReponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetallePetAccReponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(activity, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        OperativasGlobalArg0Detail detail = ((DetallePetAccReponseEnvelope) response.body()).getBody().getDetallePetAccesReturn().getOperativasGlobalArg0Detail();
                        String str2 = str;
                        if (str2 != null) {
                            detail.setComentariosSecretario(str2);
                        }
                        detail.setFirma(str2);
                        detail.setFecDeLaPeticion(CommonUtils.getCurrentDateToOperations());
                        int i = i;
                        if (i == 1) {
                            FragmentAuthExp.this.acceptSolicitud(detail);
                        } else if (i == 2) {
                            FragmentAuthExp.this.bajaSolicitud(detail);
                        } else if (i == 3) {
                            FragmentAuthExp.this.denegarSolicitud(detail);
                        } else if (i == 4) {
                            FragmentAuthExp.this.modificarSolicitud(detail);
                        }
                        return;
                    }
                    Toast.makeText(FragmentAuthExp.this.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
                } catch (IOException e) {
                    Log.e("getDetailSolicitud", "IOException", e);
                }
            }
        });
    }

    public void setOthersClickListener() {
        this.mOthersClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                int id = view.getId();
                if (id == 2131362858) {
                    ((RelativeLayout) view.getParent().getParent()).performClick();
                    FragmentActivity activity = FragmentAuthExp.this.getActivity();
                    View view2 = FragmentAuthExp.this.getView();
                    FragmentAuthExp fragmentAuthExp = FragmentAuthExp.this;
                    CommonUtils.showOperativaPopUp(activity, view2, fragmentAuthExp, true, R.string.popup_solicitud_accept, fragmentAuthExp.mCurrentItem);
                } else if (id == 2131362866) {
                    ((RelativeLayout) view.getParent().getParent()).performClick();
                    FragmentActivity activity2 = FragmentAuthExp.this.getActivity();
                    View view3 = FragmentAuthExp.this.getView();
                    FragmentAuthExp fragmentAuthExp2 = FragmentAuthExp.this;
                    CommonUtils.showOperativaPopUp(activity2, view3, fragmentAuthExp2, false, R.string.popup_solicitud_baja, fragmentAuthExp2.mCurrentItem);
                } else if (id == 2131362883) {
                    ((RelativeLayout) view.getParent().getParent()).performClick();
                    FragmentActivity activity3 = FragmentAuthExp.this.getActivity();
                    View view4 = FragmentAuthExp.this.getView();
                    FragmentAuthExp fragmentAuthExp3 = FragmentAuthExp.this;
                    CommonUtils.showOperativaPopUp(activity3, view4, fragmentAuthExp3, true, R.string.popup_solicitud_denie, fragmentAuthExp3.mCurrentItem);
                }
            }
        };
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        switch (textResource) {
            case R.string.popup_solicitud_accept:
                getDetailSolicitud(((BuscarPeticionesAcceso) this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso) this.mItems.get(position)).getFecDeLaPeticion()), 1, motive, pass);
                break;
            case R.string.popup_solicitud_baja:
                getDetailSolicitud(((BuscarPeticionesAcceso) this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso) this.mItems.get(position)).getFecDeLaPeticion()), 2, motive, pass);
                break;
            case R.string.popup_solicitud_denie:
                getDetailSolicitud(((BuscarPeticionesAcceso) this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso) this.mItems.get(position)).getFecDeLaPeticion()), 3, motive, pass);
                break;
            case R.string.popup_solicitud_modify:
                getDetailSolicitud(((BuscarPeticionesAcceso) this.mItems.get(position)).getAnioApertura(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodDocumento(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodCompletoExpediente(), ((BuscarPeticionesAcceso) this.mItems.get(position)).getCodTipoDocumento(), CommonUtils.getDateFromExpToSend(((BuscarPeticionesAcceso) this.mItems.get(position)).getFecDeLaPeticion()), 4, motive, pass);
                break;
        }
        Log.d("Silos", motive == null ? "motive null" : motive);
        Log.d("Silos", pass == null ? "pass null" : pass);
    }

    public void onItemClickListener(int opeartive, int position) {
        this.mCurrentItem = position;
        if (opeartive == 0) {
            CommonUtils.showOperativaPopUp(getActivity(), getView(), this, true, R.string.popup_solicitud_accept, position);
        } else if (opeartive == 1) {
            CommonUtils.showOperativaPopUp(getActivity(), getView(), this, true, R.string.popup_solicitud_denie, position);
        } else if (opeartive == 2) {
            CommonUtils.showOperativaPopUp(getActivity(), getView(), this, false, R.string.popup_solicitud_baja, position);
        } else if (opeartive == 3) {
            CommonUtils.showOperativaPopUp(getActivity(), getView(), this, true, R.string.popup_solicitud_modify, position);
        } else if (opeartive == 4) {
            CommonUtils.showOptionsPopUp(getActivity(), getView(), this.mOthersClickListener);
        }
    }

    public void onPopUpClosed() {
        getExpedients((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, true);
    }
}
