package es.santander.justicia.http.interfaces;

public interface WsResponse {
    void onWsError(int i, String str);

    void onWsSuccess(int i, String str);
}
