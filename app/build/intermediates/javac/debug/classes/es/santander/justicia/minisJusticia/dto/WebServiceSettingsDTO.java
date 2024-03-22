package es.santander.justicia.minisJusticia.dto;

public class WebServiceSettingsDTO {
   private long id;
   private long webServiceId;
   private String environment;
   private String url;
   private int connectionTimeout;
   private int readTimeout;
   private String urlCertificate;

   public long getId() {
      return this.id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public long getWebServiceId() {
      return this.webServiceId;
   }

   public void setWebServiceId(long webServiceId) {
      this.webServiceId = webServiceId;
   }

   public String getEnvironment() {
      return this.environment;
   }

   public void setEnvironment(String environment) {
      this.environment = environment;
   }

   public String getUrl() {
      return this.url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public int getConnectionTimeout() {
      return this.connectionTimeout;
   }

   public void setConnectionTimeout(int connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
   }

   public int getReadTimeout() {
      return this.readTimeout;
   }

   public void setReadTimeout(int receiveTimeout) {
      this.readTimeout = receiveTimeout;
   }

   public String getUrlCertificate() {
      return this.urlCertificate;
   }

   public void setUrlCertificate(String urlCertificate) {
      this.urlCertificate = urlCertificate;
   }
}
