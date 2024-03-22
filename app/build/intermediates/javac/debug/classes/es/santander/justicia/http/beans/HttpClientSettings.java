package es.santander.justicia.http.beans;   

import android.util.Pair;
import java.net.URL;
import java.util.List;

public class HttpClientSettings {
   private List<Pair<String, String>> params;
   private List<Pair<String, String>> headers;
   private URL url;
   private String requestType;

   public List<Pair<String, String>> getParams() {
      return this.params;
   }

   public void setParams(List<Pair<String, String>> params) {
      this.params = params;
   }

   public List<Pair<String, String>> getHeaders() {
      return this.headers;
   }

   public void setHeaders(List<Pair<String, String>> headers) {
      this.headers = headers;
   }

   public URL getUrl() {
      return this.url;
   }

   public void setUrl(URL url) {
      this.url = url;
   }

   public String getRequestType() {
      return this.requestType;
   }

   public void setRequestType(String requestType) {
      this.requestType = requestType;
   }
}
