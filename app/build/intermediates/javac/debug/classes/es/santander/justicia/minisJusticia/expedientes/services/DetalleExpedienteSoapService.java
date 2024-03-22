package es.santander.justicia.minisJusticia.expedientes.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.EntradaXmlDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ResponseDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente.DatosAccesoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.Constants.ConstantesBuscarDetalleExpediente_LS;
import java.io.IOException;
import java.util.ArrayList;
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

public class DetalleExpedienteSoapService {
   public ExpedienteDTO getDetalleExpediente(ExpedienteDTO expedienteDTO) {
      String tokenServ = LoginManager.getInstance().getToken();
      String nameSpace = ConstantesBuscarDetalleExpediente_LS.NAMESPACE.valor();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
      DatosExpediente datosExpediente = new DatosExpediente(expedienteDTO.getJuzga(), expedienteDTO.getJuzgori(), expedienteDTO.getJnumexp(), expedienteDTO.getJproced(), expedienteDTO.getJanoapex());
      DatosAccesoProfesionales datosAccesoProfesionales = new DatosAccesoProfesionales(datosExpediente);
      EntradaXmlDetalleExpediente entradaXmlDetalleExpediente = new EntradaXmlDetalleExpediente(datosAccesoProfesionales);
      SoapObject request = new SoapObject("", ConstantesBuscarDetalleExpediente_LS.NOMBRE_SERVICIO.valor());
      request.addAttribute("xmlns:sup", nameSpace);
      PropertyInfo arg = new PropertyInfo();
      arg.setName("arg0");
      arg.setValue(entradaXmlDetalleExpediente);
      arg.setType(entradaXmlDetalleExpediente.getClass());
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
      String soapAction = nameSpace + ConstantesBuscarDetalleExpediente_LS.NOMBRE_SERVICIO.valor();

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();

         try {
            header = envelope.headerIn;
            String newToken = (String)header[0].getChild(0);
            LoginManager.getInstance().setToken(newToken);
         } catch (Exception var23) {
            Log.e("DetalleExpSoapService", "Error al refrescar el token", var23);
         }

         ResponseDetalleExpediente responseDetalleExpediente = new ResponseDetalleExpediente(response);
         SoapObject expedienteDetail = responseDetalleExpediente.getDatosExpediente();
         List<SaldoDTO> saldos = new ArrayList();

         for(int i = 0; i < expedienteDetail.getPropertyCount(); ++i) {
            PropertyInfo saldoSoapProperty = expedienteDetail.getPropertyInfo(i);
            if ("saldos".equals(saldoSoapProperty.getName()) && saldoSoapProperty.getValue() instanceof SoapObject) {
               SaldoDTO saldoDTO = new SaldoDTO();
               SoapObject saldoSoapObject = (SoapObject)saldoSoapProperty.getValue();
               saldoDTO.setCodmon(saldoSoapObject.getProperty("codmon").toString());
               saldoDTO.setIngpendconso(saldoSoapObject.getProperty("ingpendconso").toString());
               saldoDTO.setMoneda(saldoSoapObject.getProperty("moneda").toString());
               saldoDTO.setPagopendconf(saldoSoapObject.getProperty("pagopendconf").toString());
               saldoDTO.setPagopendconso(saldoSoapObject.getProperty("pagopendconso").toString());
               saldoDTO.setSaldoconso(saldoSoapObject.getProperty("saldoconso").toString());
               saldoDTO.setSaldodia(saldoSoapObject.getProperty("saldodia").toString());
               saldoDTO.setSaldodisp(saldoSoapObject.getProperty("saldodisp").toString());
               saldoDTO.setSaldoingdeposito(saldoSoapObject.getProperty("saldoingdeposito").toString());
               saldoDTO.setSaldoingerroneo(saldoSoapObject.getProperty("saldoingerroneo").toString());
               saldoDTO.setPrincipal(saldoSoapObject.getProperty("principal").toString());
               saldos.add(saldoDTO);
            }
         }

         expedienteDTO.setSaldos(saldos);
         expedienteDTO.setDetail(true);
      } catch (SoapFault var24) {
         Log.i("DetExpSoapService", "soapFault, return null");
         return null;
      } catch (XmlPullParserException var25) {
         Log.e("DetExpSoapService", "XmlPullParserException", var25);
      } catch (HttpResponseException var26) {
         Log.e("DetExpSoapService", "HttpResponseException", var26);
      } catch (IOException var27) {
         Log.e("DetExpSoapService", "IOException", var27);
      } catch (Exception var28) {
         Log.e("DetExpSoapService", "Exception", var28);
      }

      return expedienteDTO;
   }
}
