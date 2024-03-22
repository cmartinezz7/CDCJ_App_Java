package es.santander.justicia.minisJusticia.connections;

import es.santander.justicia.minisJusticia.models.requests.GlobalRequestEnvelope;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscPetAccResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallInteface$BuscPetAcceso {
   @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
   @POST("./")
   Call<BuscPetAccResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope var1);
}
