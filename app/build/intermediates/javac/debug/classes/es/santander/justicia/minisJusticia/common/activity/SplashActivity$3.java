package es.santander.justicia.minisJusticia.common.activity;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

class SplashActivity$3 extends RetrofitCallbackInterface<ResponseBody> {
   // $FF: synthetic field
   final SplashActivity this$0;

   SplashActivity$3(SplashActivity this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
      try {
         if (response.body() != null && ((ResponseBody)response.body()).string() != null) {
            SplashActivity.access$100(this.this$0, CommonUtils.validAppVersion(this.this$0, ((ResponseBody)response.body()).string()));
         } else {
            SplashActivity.access$100(this.this$0, (String)null);
         }
      } catch (IOException var4) {
         Log.d("IOException", var4.getMessage());
      }

   }

   public void onFailure(Call<ResponseBody> call, Throwable t) {
      super.onFailure(call, t);
      SplashActivity.access$100(this.this$0, (String)null);
   }
}
