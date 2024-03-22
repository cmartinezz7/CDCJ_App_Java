package es.santander.justicia.http.beans;

import android.util.Pair;
import java.net.URL;
import java.util.List;

public class HttpClientSettings {
    private List<Pair<String, String>> headers;
    private List<Pair<String, String>> params;
    private String requestType;
    private URL url;

    public List<Pair<String, String>> getParams() {
        return this.params;
    }

    public void setParams(List<Pair<String, String>> params2) {
        this.params = params2;
    }

    public List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(List<Pair<String, String>> headers2) {
        this.headers = headers2;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url2) {
        this.url = url2;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String requestType2) {
        this.requestType = requestType2;
    }
}
