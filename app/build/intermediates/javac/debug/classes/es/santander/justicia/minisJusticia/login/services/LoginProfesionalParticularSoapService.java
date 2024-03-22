package es.santander.justicia.minisJusticia.login.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.ErrorResponseLoginProfesionalesParticular;
import es.santander.justicia.soap.service.login.soap.service.loginDocumento.CrearLoginAlias;
import es.santander.justicia.soap.service.login.soap.service.loginDocumento.CrearLoginDocumento;
import es.santander.justicia.soap.service.login.soap.service.loginDocumento.DocumentoLogin;
import es.santander.justicia.soap.service.login.soap.service.loginDocumento.ResponseLoginDocumento;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.Constants.ConstantesLoginDocumento;
import java.io.IOException;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

public class LoginProfesionalParticularSoapService {
   private static final String USER_ADDRESS = "";

   public String login(String typeDocu, String documento, String pass) {
      String error = null;
      String nameSpace = ConstantesLoginDocumento.NAMESPACE.valor();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsLoginAlias", MainApplication.getAppContext().getEnvironment());
      CrearLoginAlias crearLoginAlias = null;
      CrearLoginDocumento crearLoginDocumento = null;
      if (typeDocu == null) {
         crearLoginAlias = new CrearLoginAlias(documento, pass);
      } else {
         DocumentoLogin documentoLogin = new DocumentoLogin(documento, typeDocu);
         crearLoginDocumento = new CrearLoginDocumento(documentoLogin, pass);
      }

      SoapObject request = new SoapObject("", ConstantesLoginDocumento.NOMBRE_SERVICIO.valor());
      request.addAttribute("xmlns:v1", nameSpace);
      request.addAttribute("facade", ConstantesLoginDocumento.FACADE.valor());
      PropertyInfo authenticate = new PropertyInfo();
      authenticate.setName("CB_AuthenticationData");
      if (crearLoginAlias != null) {
         authenticate.setValue(crearLoginAlias);
         authenticate.setType(crearLoginAlias.getClass());
      } else if (crearLoginDocumento != null) {
         authenticate.setValue(crearLoginDocumento);
         authenticate.setType(crearLoginDocumento.getClass());
      }

      request.addProperty(authenticate);
      PropertyInfo useradress = new PropertyInfo();
      useradress.setName("userAddress");
      useradress.setValue("172.21.230.79");
      useradress.setType(String.class);
      request.addProperty(useradress);
      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      envelope.setOutputSoapObject(request);
      Marshal floatMarshal = new MarshalFloat();
      floatMarshal.register(envelope);
      envelope.dotNet = true;
      envelope.implicitTypes = true;
      String soapAction = nameSpace + ConstantesLoginDocumento.NOMBRE_SERVICIO.valor();

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();
         ResponseLoginDocumento responseTokenSSOProfesionales = new ResponseLoginDocumento(response);
         String tokendocu = responseTokenSSOProfesionales.getTokenDocu();
         LoginManager.getInstance().setTokenConTemp(tokendocu);
      } catch (SoapFault var18) {
         error = "soapFault";
         ErrorResponseLoginProfesionalesParticular errorResponse = new ErrorResponseLoginProfesionalesParticular(var18);
         if (errorResponse.getErrorCode() != null) {
            error = errorResponse.getErrorCode().trim();
         }
      } catch (XmlPullParserException var19) {
         error = "XmlPullParserException : " + var19.getMessage();
      } catch (HttpResponseException var20) {
         error = "HttpResponseException : " + var20.getMessage();
      } catch (IOException var21) {
         error = "IOException : " + var21.getMessage();
      } catch (Exception var22) {
         error = "Throwable : " + var22.getMessage();
      }

      if (error == null) {
         Log.i("LoginProfParSoapService", "Login OK: " + documento);
      }

      return error;
   }
}
