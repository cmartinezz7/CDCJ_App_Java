package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.1;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.2;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.3;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.4;
import es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.5;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionUsuario;
import es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion.ModificarAutorizacionArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion.DetalleAutorizacion;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityDetalleAuthorizacion extends ActivityAbstractLetrados implements DialogSolicitudCalback, PopUpActionDone {
   private static TextView tetxtViewDate;
   private static ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558439);
      this.findViewById(2131362308).setVisibility(8);
      tetxtViewDate = (TextView)this.findViewById(2131362882);
      this.defineListeners();
      this.getDetalleAutorizacion();
   }

   private void showInfo(DatosJuzgado datosJuzgado) {
      ((TextView)this.findViewById(2131362844)).setText(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
      ((TextView)this.findViewById(2131362851)).setText(datosJuzgado.getNombreOrganismo());
      ((TextView)this.findViewById(2131362853)).setText(datosJuzgado.getTelefono1());
   }

   private void showInfo(DetalleAutorizacion detalleAutorizacion) {
      ((TextView)this.findViewById(2131362844)).setText(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
      ((TextView)this.findViewById(2131362845)).setText(detalleAutorizacion.getDetalleAutorizacionJuzgado().getDireccion());
      ((TextView)this.findViewById(2131362849)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getCodNumDocumento());
      ((TextView)this.findViewById(2131362850)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getNombre() + " " + detalleAutorizacion.getDetalleAutorizacionUsuario().getApellido1() + " " + detalleAutorizacion.getDetalleAutorizacionUsuario().getApellido2());
      ((TextView)this.findViewById(2131362843)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getCodigoUsuario());
      ((TextView)this.findViewById(2131362852)).setText(detalleAutorizacion.getDetalleAutorizacionUsuario().getPerfil());
      ((TextView)this.findViewById(2131362880)).setText(DateUtils.formatDate(detalleAutorizacion.getFechaInicial(), "yyyy-MM-dd HH:mm:ss"));
      tetxtViewDate.setText(DateUtils.formatDate(detalleAutorizacion.getFechaFinal(), "yyyy-MM-dd HH:mm:ss"));
   }

   private void defineListeners() {
      this.findViewById(2131362397).setOnClickListener(new 1(this));
      this.findViewById(2131362868).setOnClickListener(new 2(this));
   }

   private DetalleAutorizacionUsuario buildRequest() {
      AutorizacionesUsuario usuario = (AutorizacionesUsuario)this.getIntent().getExtras().getSerializable("extra_autorization");
      DetalleAutorizacionUsuario detalleAutorizacionUsuario = new DetalleAutorizacionUsuario();
      detalleAutorizacionUsuario.setCodNumDocumento(usuario.getCodNumDocumento());
      detalleAutorizacionUsuario.setCodTipoDocumento(usuario.getCodTipoDocumento());
      detalleAutorizacionUsuario.setCodOrganismo(PreferencesHelper.newInstance(this).getString("preference_cod_uo"));
      detalleAutorizacionUsuario.setFechaFinal(usuario.getFechaFinal());
      detalleAutorizacionUsuario.setFechaInicial(usuario.getFechaInicial());
      detalleAutorizacionUsuario.setCodUsuario(PreferencesHelper.newInstance(this).getString("preference_user"));
      modificarAutorizacionArg0Detail = new ModificarAutorizacionArg0Detail(detalleAutorizacionUsuario);
      return detalleAutorizacionUsuario;
   }

   public void showTimePickerDialog() {
      DialogFragment newFragment = new es.santander.justicia.minisJusticia.ActivityDetalleAuthorizacion.DatePickerFragment();
      newFragment.show(this.getSupportFragmentManager(), "timePicker");
   }

   private void getDetalleAutorizacion() {
      ConnectionBuilder.getDetalleAutorizacion(this.buildRequest()).enqueue(new 3(this, this));
   }

   private void getDetalleJuzgado(String juzga) {
      ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new 4(this, this));
   }

   private void modifyAutorization(String firma) {
      modificarAutorizacionArg0Detail.setFirma(firma);
      ConnectionBuilder.mdificarAutorizacion(modificarAutorizacionArg0Detail).enqueue(new 5(this, this));
   }

   public void onPopUpClosed() {
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      modificarAutorizacionArg0Detail.setFechaFinalModificacion(DateUtils.formatDateToRequest(tetxtViewDate.getText().toString(), "yyyy-MM-dd HH:mm:ss"));
      this.modifyAutorization(pass);
   }

   // $FF: synthetic method
   static TextView access$000() {
      return tetxtViewDate;
   }

   // $FF: synthetic method
   static void access$100(ActivityDetalleAuthorizacion x0, DetalleAutorizacion x1) {
      x0.showInfo(x1);
   }

   // $FF: synthetic method
   static void access$200(ActivityDetalleAuthorizacion x0, String x1) {
      x0.getDetalleJuzgado(x1);
   }

   // $FF: synthetic method
   static void access$300(ActivityDetalleAuthorizacion x0, DatosJuzgado x1) {
      x0.showInfo(x1);
   }
}
