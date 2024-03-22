package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.responses.detalleUsuario.DetalleUsuario;
import es.santander.justicia.minisJusticia.models.responses.detalleUsuario.DetalleUsuarioResponseEnvelop;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityLoginLetrados$9 extends RetrofitCallbackInterface<DetalleUsuarioResponseEnvelop> {
   // $FF: synthetic field
   final boolean val$loginOk;
   // $FF: synthetic field
   final ActivityLoginLetrados this$0;

   ActivityLoginLetrados$9(ActivityLoginLetrados this$0, Context context, Boolean show, Boolean dismiss, boolean var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$loginOk = var5;
   }

   public void onResponse(Call<DetalleUsuarioResponseEnvelop> call, Response<DetalleUsuarioResponseEnvelop> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleUsuarioResponseEnvelop)response.body()).getBinarySecurityToken() != null ? ((DetalleUsuarioResponseEnvelop)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               DetalleUsuario detalleUsuario = ((DetalleUsuarioResponseEnvelop)response.body()).getBody().getDetalleUsuarioResponseReturn().getDetalleUsuario();
               PreferencesHelper.newInstance(this.this$0).setString("preference_organism", detalleUsuario.getCodOrganismo());
               PreferencesHelper.newInstance(this.this$0).setString("preference_user", detalleUsuario.getCodUsuario());
               PreferencesHelper.newInstance(this.this$0).setString("preference_cod_uo", detalleUsuario.getCodUoPadre());
               PreferencesHelper.newInstance(this.this$0).setString("preference_user_login_name", detalleUsuario.getNombreUsuario() + " " + (CommonUtils.isNotNullNotBlackNotStringNull(detalleUsuario.getApellidoPrimero()) ? detalleUsuario.getApellidoPrimero() : ""));
               LoginManager.getInstance().loginLetrados(((DetalleUsuarioResponseEnvelop)response.body()).getBinarySecurityToken().getSecurityToken(), detalleUsuario.getNombreUsuario() + " " + (CommonUtils.isNotNullNotBlackNotStringNull(detalleUsuario.getApellidoPrimero()) ? detalleUsuario.getApellidoPrimero() : ""), detalleUsuario.getCodigoTipoPersona() + "-" + detalleUsuario.getNumeroPersona());
               this.this$0.updateHeader();
               if (this.val$loginOk) {
                  TealiumHelper.trackEvent("/login", "login (ok)");
                  Intent intent = new Intent(this.this$0, ActivityHomeLetrados.class);
                  intent.putExtra("user_detail", detalleUsuario);
                  this.this$0.startActivity(intent);
                  this.this$0.finish();
               } else {
                  TealiumHelper.trackEvent("/login", "login (ko)");
               }
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var5) {
         Log.e("ActivityLoginLetrados", "IOException", var5);
      }

   }
}
