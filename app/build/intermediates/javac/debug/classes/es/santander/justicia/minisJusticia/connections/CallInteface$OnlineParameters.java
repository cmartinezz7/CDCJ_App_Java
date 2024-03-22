package es.santander.justicia.minisJusticia.connections;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CallInteface$OnlineParameters {
   @GET("./files/apps/Justicia/onlineparameters.json")
   Call<ResponseBody> onlineParameters();
}
