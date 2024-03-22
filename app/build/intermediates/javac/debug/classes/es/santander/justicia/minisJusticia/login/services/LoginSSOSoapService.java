package es.santander.justicia.minisJusticia.login.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP.DatosArg;
import es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP.ResponseTokenSSOProfesionales;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.Constants.ConstantesLogin_TokenJZG;
import java.io.IOException;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

public class LoginSSOSoapService {
   public String loginTokenSSO(String TokenSSOP, String acceso) {
      String nameSpace = ConstantesLogin_TokenJZG.NAMESPACE.valor();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsGetProfessionalsTokenSSO", MainApplication.getAppContext().getEnvironment());
      DatosArg datosArg = new DatosArg(acceso, TokenSSOP);
      SoapObject request = new SoapObject("", ConstantesLogin_TokenJZG.NOMBRE_SERVICIO.valor());
      request.addAttribute("xmlns:wss", nameSpace);
      PropertyInfo arg = new PropertyInfo();
      arg.setName("arg0");
      arg.setValue(datosArg);
      arg.setType(datosArg.getClass());
      request.addProperty(arg);
      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      envelope.setOutputSoapObject(request);
      Marshal floatMarshal = new MarshalFloat();
      floatMarshal.register(envelope);
      envelope.dotNet = true;
      envelope.implicitTypes = true;
      String soapAction = nameSpace + ConstantesLogin_TokenJZG.NOMBRE_SERVICIO.valor();
      Log.d("SILOS", envelope.toString());

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();
         ResponseTokenSSOProfesionales responseTokenSSOProfesionales = new ResponseTokenSSOProfesionales(response);
         if (TokenSSOP != null) {
            TokenSSOP = responseTokenSSOProfesionales.getTokenSSO();
            LoginManager.getInstance().setTokenSSOTemp(TokenSSOP);
            return null;
         } else {
            return "ERROR: Token de usuario nulo";
         }
      } catch (SoapFault var13) {
         return "ERROR: Se ha producido un error al conectar con el servidor";
      } catch (XmlPullParserException var14) {
         Log.e("LoginSSOSoapService", "XmlPullParserException", var14);
         return "ERROR: Se ha producido un error al conectar con el servidor";
      } catch (HttpResponseException var15) {
         Log.e("LoginSSOSoapService", "HttpResponseException", var15);
         return "ERROR: Se ha producido un error al conectar con el servidor";
      } catch (IOException var16) {
         Log.e("LoginSSOSoapService", "IOException", var16);
         return "ERROR: Se ha producido un error al conectar con el servidor";
      }
   }
}
