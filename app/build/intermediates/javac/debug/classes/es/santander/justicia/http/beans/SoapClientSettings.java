package es.santander.justicia.http.beans;

import es.santander.justicia.http.enums.SoapWebServicesEnum;
import org.ksoap2.serialization.PropertyInfo;

public class SoapClientSettings {
   private PropertyInfo body;
   private SoapWebServicesEnum soapWebServicesEnum;
   private String environment;
   private String initConfigName;

   public PropertyInfo getBody() {
      return this.body;
   }

   public void setBody(PropertyInfo body) {
      this.body = body;
   }

   public SoapWebServicesEnum getSoapWebServicesEnum() {
      return this.soapWebServicesEnum;
   }

   public void setSoapWebServicesEnum(SoapWebServicesEnum soapWebServicesEnum) {
      this.soapWebServicesEnum = soapWebServicesEnum;
   }

   public String getEnvironment() {
      return this.environment;
   }

   public void setEnvironment(String environment) {
      this.environment = environment;
   }

   public String getInitConfigName() {
      return this.initConfigName;
   }

   public void setInitConfigName(String initConfigName) {
      this.initConfigName = initConfigName;
   }
}
