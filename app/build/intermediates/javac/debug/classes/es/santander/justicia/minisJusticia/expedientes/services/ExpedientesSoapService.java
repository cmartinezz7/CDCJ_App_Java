package es.santander.justicia.minisJusticia.expedientes.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.EntradaXmlBuscarExpediente;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ResponseBuscarExpediente;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcessoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.Constants.ConstantesBuscarExpediente_LS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class ExpedientesSoapService {
   public ArrayList<ExpedienteDTO> getExpedientes() {
      String tokenServ = LoginManager.getInstance().getToken();
      String nameSpace = ConstantesBuscarExpediente_LS.NAMESPACE.valor();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
      DatosAcessoProfesionales datosAcessoProfesionales = new DatosAcessoProfesionales("");
      DatosPaginacion datosPaginacion = new DatosPaginacion("1", "1000");
      EntradaXmlBuscarExpediente entradaXmlBuscarExpediente = new EntradaXmlBuscarExpediente(datosAcessoProfesionales, "", datosPaginacion);
      SoapObject request = new SoapObject("", ConstantesBuscarExpediente_LS.NOMBRE_SERVICIO.valor());
      request.addAttribute("xmlns:sup", nameSpace);
      PropertyInfo arg = new PropertyInfo();
      arg.setName("arg0");
      arg.setValue(entradaXmlBuscarExpediente);
      arg.setType(entradaXmlBuscarExpediente.getClass());
      request.addProperty(arg);
      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      Element[] header = new Element[]{(new Element()).createElement("", "wsse:Security")};
      header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
      Element pass = (new Element()).createElement("", "BinarySecurityToken");
      pass.addChild(4, tokenServ);
      header[0].addChild(2, pass);
      envelope.headerOut = header;
      envelope.setOutputSoapObject(request);
      Marshal floatMarshal = new MarshalFloat();
      floatMarshal.register(envelope);
      envelope.dotNet = true;
      envelope.implicitTypes = true;
      String soapAction = nameSpace + ConstantesBuscarExpediente_LS.NOMBRE_SERVICIO.valor();

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();

         try {
            header = envelope.headerIn;
            String newToken = (String)header[0].getChild(0);
            LoginManager.getInstance().setToken(newToken);
         } catch (Exception var23) {
            Log.e("ExpedientesSoapService", "Error al refrescar el token", var23);
         }

         ResponseBuscarExpediente responseBuscarExpediente = new ResponseBuscarExpediente(response);
         List<SoapObject> expedientes = responseBuscarExpediente.getListaDatosExpediente();
         ArrayList<ExpedienteDTO> misExpedientes = new ArrayList();

         ExpedienteDTO miEsp;
         for(Iterator var18 = expedientes.iterator(); var18.hasNext(); misExpedientes.add(miEsp)) {
            SoapObject so = (SoapObject)var18.next();
            SoapObject query = (SoapObject)so.getProperty("saldos");
            String saldo = query.getProperty("impsaldo").toString();
            miEsp = new ExpedienteDTO();
            miEsp.setCodExpediente(so.getProperty("codExpediente").toString());
            miEsp.setJanoapex(so.getProperty("janoapex").toString());
            miEsp.setJnumexp(so.getProperty("jnumexp").toString());
            miEsp.setJproced(so.getProperty("jproced").toString());
            miEsp.setJuzga(so.getProperty("juzga").toString());
            miEsp.setJuzgori(so.getProperty("juzgori").toString());
            miEsp.setCodmon(so.getProperty("codmon").toString());
            miEsp.setMoneda(so.getProperty("moneda").toString());
            miEsp.setSaldo(saldo);
            miEsp.setPrimov(so.getProperty("primov").toString());
            miEsp.setSituacion(so.getProperty("situacion").toString());
            miEsp.setUltmov(so.getProperty("ultmov").toString());
            if (!"".equals(so.getProperty("impInterCostas").toString()) && !" ".equals(so.getProperty("impInterCostas").toString())) {
               miEsp.setIntCostas(so.getProperty("impInterCostas").toString());
            } else {
               miEsp.setIntCostas("0");
            }
         }

         return misExpedientes;
      } catch (SoapFault var24) {
         return null;
      } catch (XmlPullParserException var25) {
         Log.e("ExpedientesSoapService", "XmlPullParserException", var25);
      } catch (HttpResponseException var26) {
         Log.e("ExpedientesSoapService", "HttpResponseException", var26);
      } catch (IOException var27) {
         Log.e("ExpedientesSoapService", "IOException", var27);
      }

      return null;
   }
}
