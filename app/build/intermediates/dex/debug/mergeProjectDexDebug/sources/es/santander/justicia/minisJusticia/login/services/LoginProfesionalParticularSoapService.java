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

public class LoginProfesionalParticularSoapService {
    private static final String USER_ADDRESS = "";

    public String login(String typeDocu, String documento, String pass) {
        CrearLoginDocumento crearLoginDocumento;
        CrearLoginAlias crearLoginAlias;
        String str = typeDocu;
        String str2 = documento;
        String str3 = pass;
        String error = null;
        String nameSpace = Constants.ConstantesLoginDocumento.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(InitConfigConstants.WS_LOGIN_ALIAS, MainApplication.getAppContext().getEnvironment());
        if (str == null) {
            crearLoginDocumento = null;
            crearLoginAlias = new CrearLoginAlias(str2, str3);
        } else {
            crearLoginDocumento = new CrearLoginDocumento(new DocumentoLogin(str2, str), str3);
            crearLoginAlias = null;
        }
        SoapObject request = new SoapObject(USER_ADDRESS, Constants.ConstantesLoginDocumento.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:v1", nameSpace);
        request.addAttribute("facade", Constants.ConstantesLoginDocumento.FACADE.valor());
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
        new MarshalFloat().register(envelope);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        try {
            NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), nameSpace + Constants.ConstantesLoginDocumento.NOMBRE_SERVICIO.valor(), envelope, wsSettings.getConnectionTimeout());
            SoapObject response = (SoapObject) envelope.getResponse();
            SoapObject soapObject = response;
            LoginManager.getInstance().setTokenConTemp(new ResponseLoginDocumento(response).getTokenDocu());
        } catch (SoapFault soapFault) {
            ErrorResponseLoginProfesionalesParticular errorResponse = new ErrorResponseLoginProfesionalesParticular(soapFault);
            if (errorResponse.getErrorCode() != null) {
                error = errorResponse.getErrorCode().trim();
            } else {
                error = "soapFault";
            }
        } catch (XmlPullParserException e) {
            error = "XmlPullParserException : " + e.getMessage();
        } catch (HttpResponseException e2) {
            error = "HttpResponseException : " + e2.getMessage();
        } catch (IOException e3) {
            error = "IOException : " + e3.getMessage();
        } catch (Exception e4) {
            error = "Throwable : " + e4.getMessage();
        }
        if (error == null) {
            Log.i("LoginProfParSoapService", "Login OK: " + str2);
        }
        return error;
    }
}
