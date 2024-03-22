package es.santander.justicia.minisJusticia.login.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP.DatosArg;
import es.santander.justicia.soap.service.login.soap.service.loginTokenSSOP.ResponseTokenSSOProfesionales;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.NetworkUtils;
import java.io.IOException;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

public class LoginSSOSoapService {
    public String loginTokenSSO(String TokenSSOP, String acceso) {
        String nameSpace = Constants.ConstantesLogin_TokenJZG.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(InitConfigConstants.WS_GET_PROFESSIONALS_TOKEN_SSO, MainApplication.getAppContext().getEnvironment());
        DatosArg datosArg = new DatosArg(acceso, TokenSSOP);
        SoapObject request = new SoapObject("", Constants.ConstantesLogin_TokenJZG.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:wss", nameSpace);
        PropertyInfo arg = new PropertyInfo();
        arg.setName("arg0");
        arg.setValue(datosArg);
        arg.setType(datosArg.getClass());
        request.addProperty(arg);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(request);
        new MarshalFloat().register(envelope);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        String soapAction = nameSpace + Constants.ConstantesLogin_TokenJZG.NOMBRE_SERVICIO.valor();
        Log.d("SILOS", envelope.toString());
        try {
            NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
            ResponseTokenSSOProfesionales responseTokenSSOProfesionales = new ResponseTokenSSOProfesionales((SoapObject) envelope.getResponse());
            if (TokenSSOP == null) {
                return "ERROR: Token de usuario nulo";
            }
            LoginManager.getInstance().setTokenSSOTemp(responseTokenSSOProfesionales.getTokenSSO());
            return null;
        } catch (SoapFault e) {
            return "ERROR: Se ha producido un error al conectar con el servidor";
        } catch (XmlPullParserException e2) {
            Log.e("LoginSSOSoapService", "XmlPullParserException", e2);
            return "ERROR: Se ha producido un error al conectar con el servidor";
        } catch (HttpResponseException e3) {
            Log.e("LoginSSOSoapService", "HttpResponseException", e3);
            return "ERROR: Se ha producido un error al conectar con el servidor";
        } catch (IOException e4) {
            Log.e("LoginSSOSoapService", "IOException", e4);
            return "ERROR: Se ha producido un error al conectar con el servidor";
        }
    }
}
