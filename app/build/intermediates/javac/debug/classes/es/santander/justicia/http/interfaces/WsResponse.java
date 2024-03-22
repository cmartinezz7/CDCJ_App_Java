package es.santander.justicia.http.interfaces;

public interface WsResponse {
   void onWsSuccess(int var1, String var2);

   void onWsError(int var1, String var2);
}
   