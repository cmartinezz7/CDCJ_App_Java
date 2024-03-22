package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.interfaces.AccessRequestCallback;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.soap.service.login.soap.service.solicitudAcceso.XmlBodyAccessRequest;
import es.santander.justicia.soap.service.login.soap.service.solicitudAcceso.params.DatosAccesoProfesionales;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class AccessRequestController implements WsSoapResponse {
   private AccessRequestCallback callback;

   public AccessRequestController(AccessRequestCallback callback) {
      this.callback = callback;
   }

   public void sendAccessRequest(String juzga, String juzgori, String jproced, String jnumexp, String janoapex, String montsolic, String environment) {
      DatosExpediente fileData = new DatosExpediente(juzga, juzgori, jnumexp, jproced, janoapex);
      DatosAccesoProfesionales professionalsAccessData = new DatosAccesoProfesionales(fileData, montsolic);
      XmlBodyAccessRequest xmlBody = new XmlBodyAccessRequest(professionalsAccessData);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(environment);
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.ACCESS_REQUEST);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject soapObject = (SoapObject)response;
      this.callback.onFinishRequest("", "", true);
   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
      SoapFault error = (SoapFault)response;
      String faultCode = error != null ? error.faultcode : "0000";
      String faultString = error != null ? error.faultstring : "Error al invocar al servicio, vuelva a intentarlo";
      this.callback.onFinishRequest(faultCode, faultString, false);
   }
}
