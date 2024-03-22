package es.santander.justicia.minisJusticia.dto;

public class WebServiceSettingsDTO {
    private int connectionTimeout;
    private String environment;
    private long id;
    private int readTimeout;
    private String url;
    private String urlCertificate;
    private long webServiceId;

    public long getId() {
        return this.id;
    }

    public void setId(long id2) {
        this.id = id2;
    }

    public long getWebServiceId() {
        return this.webServiceId;
    }

    public void setWebServiceId(long webServiceId2) {
        this.webServiceId = webServiceId2;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment2) {
        this.environment = environment2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout2) {
        this.connectionTimeout = connectionTimeout2;
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

    public void setUrlCertificate(String urlCertificate2) {
        this.urlCertificate = urlCertificate2;
    }
}
