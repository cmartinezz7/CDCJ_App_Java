package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import retrofit2.Call;
import retrofit2.Response;

class ActivityAbstractLetrados$1 extends RetrofitCallbackInterface<Void> {
   // $FF: synthetic field
   final ActivityAbstractLetrados this$0;

   ActivityAbstractLetrados$1(ActivityAbstractLetrados this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onFailure(Call<Void> call, Throwable t) {
      super.onFailure(call, t);
      Log.d("Logout", t.getMessage());
      LoginManager.getInstance().logout();
      this.this$0.forwardLogout();
   }

   public void onResponse(Call<Void> call, Response<Void> response) {
      super.onResponse(call, response);
      Log.d("Logout", "success");
      TealiumHelper.trackEvent("/menu/logout", "logout");
      LoginManager.getInstance().logout();
      this.this$0.forwardLogout();
   }
}
