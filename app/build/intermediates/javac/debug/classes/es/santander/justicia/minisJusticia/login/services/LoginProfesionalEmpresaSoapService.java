package es.santander.justicia.minisJusticia.login.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.DatosCabeceraRealizarLogonParams;
import es.santander.justicia.soap.service.login.DatosConexionRealziarLoginParams;
import es.santander.justicia.soap.service.login.DocumentoPersonaRealizarLoginParams;
import es.santander.justicia.soap.service.login.EntradaRealizarLoginParams;
import es.santander.justicia.soap.service.login.ErrorResponseLoginProfesionalesEmpresa;
import es.santander.justicia.soap.service.login.IdiomaRealizarLogonPrams;
import es.santander.justicia.soap.service.login.RealizarLoginLA;
import es.santander.justicia.soap.service.login.RealizarLoginResponse;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.Constants.ConstantesRealizarLogonLA;
import es.santander.justicia.utils.Constants.ServiciosComerciales;
import java.io.IOException;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

public class LoginProfesionalEmpresaSoapService {
   public String login(String typeDocu, String documento, String code, String pass) {
      String error = null;
      RealizarLoginLA realizarLoginLA = new RealizarLoginLA();
      DocumentoPersonaRealizarLoginParams documentoPersonaRealizarLoginParams = new DocumentoPersonaRealizarLoginParams(typeDocu, documento);
      EntradaRealizarLoginParams entradaLogin = new EntradaRealizarLoginParams();
      entradaLogin.setAlias(code);
      entradaLogin.setPassword(pass);
      entradaLogin.setDocumentoPersona(documentoPersonaRealizarLoginParams);
      realizarLoginLA.setEntrada(entradaLogin);
      String nameSpace = ConstantesRealizarLogonLA.NAMESPACE.valor();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsLoginLA", MainApplication.getAppContext().getEnvironment());
      DocumentoPersonaRealizarLoginParams documentoPersona = new DocumentoPersonaRealizarLoginParams(realizarLoginLA.getEntrada().getDocumentoPersona().getTIPO_DOCUMENTO_OFIC(), realizarLoginLA.getEntrada().getDocumentoPersona().getCODIGO_DE_DOCUMENTO());
      EntradaRealizarLoginParams entradaRealizarLoginParams = new EntradaRealizarLoginParams(realizarLoginLA.getEntrada().getAlias(), realizarLoginLA.getEntrada().getPassword(), ServiciosComerciales.DEFAULT.valor(), documentoPersona);
      DatosConexionRealziarLoginParams datosConexionRealziarLoginParams = new DatosConexionRealziarLoginParams("EMP", "0049");
      IdiomaRealizarLogonPrams idiomaRealizarLogonPrams = new IdiomaRealizarLogonPrams("es", "ES");
      DatosCabeceraRealizarLogonParams datosCabeceraRealizarLogonParams = new DatosCabeceraRealizarLogonParams(idiomaRealizarLogonPrams);
      SoapObject request = new SoapObject(nameSpace, ConstantesRealizarLogonLA.NOMBRE_SERVICIO.valor());
      request.addAttribute("facade", "ACEMPMOVContratos");
      PropertyInfo entrada = new PropertyInfo();
      entrada.setName("entrada");
      entrada.setValue(entradaRealizarLoginParams);
      entrada.setType(entradaRealizarLoginParams.getClass());
      request.addProperty(entrada);
      PropertyInfo datosConexion = new PropertyInfo();
      datosConexion.setName("datosConexion");
      datosConexion.setValue(datosConexionRealziarLoginParams);
      datosConexion.setType(datosConexionRealziarLoginParams.getClass());
      request.addProperty(datosConexion);
      PropertyInfo datosCabecera = new PropertyInfo();
      datosCabecera.setName("datosCabecera");
      datosCabecera.setValue(datosCabeceraRealizarLogonParams);
      datosCabecera.setType(datosCabeceraRealizarLogonParams.getClass());
      request.addProperty(datosCabecera);
      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      envelope.setOutputSoapObject(request);
      Marshal floatMarshal = new MarshalFloat();
      floatMarshal.register(envelope);
      envelope.dotNet = true;
      envelope.implicitTypes = true;
      String soapAction = nameSpace + ConstantesRealizarLogonLA.NOMBRE_SERVICIO.valor();

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();
         RealizarLoginResponse realizarLoginResponse = new RealizarLoginResponse(response);
         if (realizarLoginResponse.tieneAccesoAlServicioComercial(ServiciosComerciales.JUSTICIA)) {
            LoginManager.getInstance().setTokenConTemp(realizarLoginResponse.getToken());
            LoginManager.getInstance().setCodClienteTemp(realizarLoginResponse.getTipoPersona() + "-" + realizarLoginResponse.getCodigoPersona());
            LoginManager.getInstance().setNombreUsuario(realizarLoginResponse.getNombreTitular());
         } else {
            error = "El usuario no tiene acceso al servicio de justicia, no " + ServiciosComerciales.JUSTICIA;
         }
      } catch (SoapFault var25) {
         error = "soapFault";
         ErrorResponseLoginProfesionalesEmpresa errorResponse = new ErrorResponseLoginProfesionalesEmpresa(var25);
         if (errorResponse.getErrorDesc() != null) {
            error = "ERROR_PROFESIONAL_EMPRESA" + errorResponse.getErrorDesc().trim();
         }
      } catch (XmlPullParserException var26) {
         Log.e("JusticiaSoapService", "XmlPullParserException", var26);
         error = "XmlPullParserException : " + var26.getMessage();
      } catch (HttpResponseException var27) {
         Log.e("JusticiaSoapService", "HttpResponseException", var27);
         error = "HttpResponseException : " + var27.getMessage();
      } catch (IOException var28) {
         Log.e("JusticiaSoapService", "IOException", var28);
         error = "IOException : " + var28.getMessage();
      } catch (Exception var29) {
         Log.e("JusticiaSoapService", "Exception", var29);
         error = "Throwable : " + var29.getMessage();
      }

      if (error != null) {
         Log.i("LoginProfEmpSoapService", error);
      } else {
         Log.i("LoginProfEmpSoapService", "Login OK: " + documento);
      }

      return error;
   }
}
