package es.santander.justicia.http.beans;

import es.santander.justicia.http.enums.SoapWebServicesEnum;
import org.ksoap2.serialization.PropertyInfo;

public class SoapClientSettings {
    private PropertyInfo body;
    private String environment;
    private String initConfigName;
    private SoapWebServicesEnum soapWebServicesEnum;

    public PropertyInfo getBody() {
        return this.body;
    }

    public void setBody(PropertyInfo body2) {
        this.body = body2;
    }

    public SoapWebServicesEnum getSoapWebServicesEnum() {
        return this.soapWebServicesEnum;
    }

    public void setSoapWebServicesEnum(SoapWebServicesEnum soapWebServicesEnum2) {
        this.soapWebServicesEnum = soapWebServicesEnum2;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment2) {
        this.environment = environment2;
    }

    public String getInitConfigName() {
        return this.initConfigName;
    }

    public void setInitConfigName(String initConfigName2) {
        this.initConfigName = initConfigName2;
    }
}
