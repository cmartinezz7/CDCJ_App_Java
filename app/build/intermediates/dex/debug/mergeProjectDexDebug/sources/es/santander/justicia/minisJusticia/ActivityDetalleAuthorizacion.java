package es.santander.justicia.minisJusticia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionUsuario;
import es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion.ModificarAutorizacionArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion.DetalleAutorizacion;
import es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion.DetalleAutorizacionEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.Calendar;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityDetalleAuthorizacion extends ActivityAbstractLetrados implements DialogSolicitudCalback, PopUpActionDone {
    private static ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail;
    /* access modifiers changed from: private */
    public static TextView tetxtViewDate;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_auth);
        findViewById(R.id.img_edit).setVisibility(8);
        tetxtViewDate = (TextView) findViewById(R.id.text_date_to);
        defineListeners();
        getDetalleAutorizacion();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    /* access modifiers changed from: private */
    public void showInfo(DatosJuzgado datosJuzgado) {
        ((TextView) findViewById(R.id.textViewCuenta)).setText(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
        ((TextView) findViewById(R.id.textViewNombre)).setText(datosJuzgado.getNombreOrganismo());
        ((TextView) findViewById(R.id.textViewTelefono)).setText(datosJuzgado.getTelefono1());
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    /* access modifiers changed from: private */
    public void showInfo(DetalleAutorizacion detalleAutorizacion) {
        ((TextView) findViewById(R.id.textViewCuenta)).setText(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
        ((TextView) findViewById(R.id.textViewDireccion)).setText(detalleAutorizacion.getDetalleAutorizacionJuzgado().getDireccion());
        ((TextView) findViewById(R.id.textViewNDoc)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getCodNumDocumento());
        ((TextView) findViewById(R.id.textViewName2)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getNombre() + " " + detalleAutorizacion.getDetalleAutorizacionUsuario().getApellido1() + " " + detalleAutorizacion.getDetalleAutorizacionUsuario().getApellido2());
        ((TextView) findViewById(R.id.textViewCode)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getCodigoUsuario());
        ((TextView) findViewById(R.id.textViewProfile)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getPerfil());
        ((TextView) findViewById(R.id.text_date_from)).setText(DateUtils.formatDate(detalleAutorizacion.getFechaInicial(), Constants.DATE_FORMAT_AUTORIZATIONS));
        tetxtViewDate.setText(DateUtils.formatDate(detalleAutorizacion.getFechaFinal(), Constants.DATE_FORMAT_AUTORIZATIONS));
    }

    private void defineListeners() {
        findViewById(R.id.linearDateTo).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityDetalleAuthorizacion.this.showTimePickerDialog();
            }
        });
        findViewById(R.id.text_btn_mod).setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
            public void onClick(View view) {
                ? r0 = ActivityDetalleAuthorizacion.this;
                CommonUtils.showOperativaPopUp(r0, r0.findViewById(16908290), ActivityDetalleAuthorizacion.this, false, R.string.confirmar_swype, 0);
            }
        });
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    private DetalleAutorizacionUsuario buildRequest() {
        AutorizacionesUsuario usuario = (AutorizacionesUsuario) getIntent().getExtras().getSerializable(Constants.EXTRA_AUTORIZATION);
        DetalleAutorizacionUsuario detalleAutorizacionUsuario = new DetalleAutorizacionUsuario();
        detalleAutorizacionUsuario.setCodNumDocumento(usuario.getCodNumDocumento());
        detalleAutorizacionUsuario.setCodTipoDocumento(usuario.getCodTipoDocumento());
        detalleAutorizacionUsuario.setCodOrganismo(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
        detalleAutorizacionUsuario.setFechaFinal(usuario.getFechaFinal());
        detalleAutorizacionUsuario.setFechaInicial(usuario.getFechaInicial());
        detalleAutorizacionUsuario.setCodUsuario(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_USER));
        modificarAutorizacionArg0Detail = new ModificarAutorizacionArg0Detail(detalleAutorizacionUsuario);
        return detalleAutorizacionUsuario;
    }

    public void showTimePickerDialog() {
        new DatePickerFragment().show(getSupportFragmentManager(), "timePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar c = DateUtils.calendarFromString(ActivityDetalleAuthorizacion.tetxtViewDate.getText().toString());
            return new DatePickerDialog(getActivity(), this, c.get(1), c.get(2), c.get(5));
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            int month2 = month + 1;
            ActivityDetalleAuthorizacion.tetxtViewDate.setText((day < 10 ? "0" + day : String.valueOf(day)) + "/" + (month2 < 10 ? "0" + month2 : String.valueOf(month2)) + "/" + year);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    private void getDetalleAutorizacion() {
        ConnectionBuilder.getDetalleAutorizacion(buildRequest()).enqueue(new RetrofitCallbackInterface<DetalleAutorizacionEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
            public void onResponse(Call<DetalleAutorizacionEnvelope> call, Response<DetalleAutorizacionEnvelope> response) {
                try {
                    ? r0 = ActivityDetalleAuthorizacion.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((DetalleAutorizacionEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetalleAutorizacionEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        ActivityDetalleAuthorizacion.this.showInfo(((DetalleAutorizacionEnvelope) response.body()).getBody().getDetalleAutorizacionReturn().getDetalleAutorizacion());
                        ActivityDetalleAuthorizacion.this.getDetalleJuzgado(((DetalleAutorizacionEnvelope) response.body()).getBody().getDetalleAutorizacionReturn().getDetalleAutorizacion().getDetalleAutorizacionJuzgado().getCodOrganismo());
                    }
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    /* access modifiers changed from: private */
    public void getDetalleJuzgado(String juzga) {
        ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new RetrofitCallbackInterface<DetalleJuzgadosResponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
            public void onResponse(Call<DetalleJuzgadosResponseEnvelope> call, Response<DetalleJuzgadosResponseEnvelope> response) {
                try {
                    ? r0 = ActivityDetalleAuthorizacion.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        ActivityDetalleAuthorizacion.this.showInfo(((DetalleJuzgadosResponseEnvelope) response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados().get(0));
                    }
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
    private void modifyAutorization(String firma) {
        modificarAutorizacionArg0Detail.setFirma(firma);
        ConnectionBuilder.mdificarAutorizacion(modificarAutorizacionArg0Detail).enqueue(new RetrofitCallbackInterface<GlobalReponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion] */
            public void onResponse(Call<GlobalReponseEnvelope> call, Response<GlobalReponseEnvelope> response) {
                try {
                    ? r0 = ActivityDetalleAuthorizacion.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((GlobalReponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((GlobalReponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        ActivityDetalleAuthorizacion.this.setResult(-1, new Intent());
                        ActivityDetalleAuthorizacion.this.finish();
                    }
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    public void onPopUpClosed() {
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        modificarAutorizacionArg0Detail.setFechaFinalModificacion(DateUtils.formatDateToRequest(tetxtViewDate.getText().toString(), Constants.DATE_FORMAT_AUTORIZATIONS));
        modifyAutorization(pass);
    }
}
