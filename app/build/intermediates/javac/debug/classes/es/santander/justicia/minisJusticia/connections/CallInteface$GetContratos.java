package es.santander.justicia.minisJusticia.connections;

import es.santander.justicia.minisJusticia.models.requests.GlobalContratosRequestEnvelope;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosParaguasResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CallInteface$GetContratos {
   @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
   @POST("./SCH_EMPMOV_CONTRATOS_ENS/ws/BAMOBI_WS_Def_Listener")
   Call<ContratosParaguasResponseEnvelope> requestStateInfo(@Body GlobalContratosRequestEnvelope var1);
}
