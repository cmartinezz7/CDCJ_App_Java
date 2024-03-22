package es.santander.justicia.minisJusticia.connections;

import es.santander.justicia.minisJusticia.models.requests.login.LoginRequestEnvelope;
import es.santander.justicia.minisJusticia.models.responses.login.LoginResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallInteface$Login {
   @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
   @POST("./")
   Call<LoginResponseEnvelope> requestStateInfo(@Body LoginRequestEnvelope var1);
}
