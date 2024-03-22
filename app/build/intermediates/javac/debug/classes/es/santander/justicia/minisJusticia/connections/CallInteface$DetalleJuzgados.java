package es.santander.justicia.minisJusticia.connections;

import es.santander.justicia.minisJusticia.models.requests.GlobalRequestEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallInteface$DetalleJuzgados {
   @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
   @POST("./")
   Call<DetalleJuzgadosResponseEnvelope> requestStateInfo(@Body GlobalRequestEnvelope var1);
}
