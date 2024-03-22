package es.santander.justicia.minisJusticia.common.services;

import android.util.Log;
import androidx.core.util.Pair;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.utils.NetworkUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class JusticiaSoapService {
   private SoapWebServicesEnum soapWebServicesEnum;
   private String wsAccessRequest;

   public JusticiaSoapService(SoapWebServicesEnum soapWebServicesEnum, String wsAccessRequest) {
      this.soapWebServicesEnum = soapWebServicesEnum;
      this.wsAccessRequest = wsAccessRequest;
   }

   public SoapObject sendRequest(PropertyInfo body) {
      return this.sendRequest(body, LoginManager.getInstance().getToken());
   }

   public SoapObject sendRequest(PropertyInfo body, String token) {
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(this.wsAccessRequest, MainApplication.getAppContext().getEnvironment());
      String nameSpace = this.soapWebServicesEnum.getNameSpace();
      String method = this.soapWebServicesEnum.getMethodName();
      String soapAction = this.soapWebServicesEnum.getSoapAction();
      SoapObject request = new SoapObject("", method);
      this.addRequestAttributes(request, this.soapWebServicesEnum.getAttributes());
      if (body != null) {
         request.addProperty(body);
      }

      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      Element[] header = new Element[]{(new Element()).createElement("", "wsse:Security")};
      header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
      Element pass = (new Element()).createElement("", "BinarySecurityToken");
      pass.addChild(4, token);
      header[0].addChild(2, pass);
      envelope.headerOut = header;
      envelope.setOutputSoapObject(request);
      Marshal floatMarshal = new MarshalFloat();
      floatMarshal.register(envelope);
      envelope.dotNet = true;
      envelope.implicitTypes = true;
      envelope.setAddAdornments(false);

      try {
         NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
         SoapObject response = (SoapObject)envelope.getResponse();

         try {
            header = envelope.headerIn;
            String newToken = (String)header[0].getChild(0);
            LoginManager.getInstance().setToken(newToken);
         } catch (Exception var14) {
            Log.e("JusticiaSoapService", "Error al refrescar el token", var14);
         }

         return response;
      } catch (SoapFault var15) {
         Log.i("JusticiaSoapService", "soapFault, return null");
         return null;
      } catch (XmlPullParserException var16) {
         Log.e("JusticiaSoapService", "XmlPullParserException", var16);
      } catch (HttpResponseException var17) {
         Log.e("JusticiaSoapService", "HttpResponseException", var17);
      } catch (IOException var18) {
         Log.e("JusticiaSoapService", "IOException", var18);
      } catch (Exception var19) {
         Log.e("JusticiaSoapService", "Exception", var19);
      }

      return null;
   }

   private void addRequestAttributes(SoapObject request, ArrayList<Pair<String, String>> attributes) {
      if (!attributes.isEmpty()) {
         Iterator var3 = attributes.iterator();

         while(var3.hasNext()) {
            Pair<String, String> attribute = (Pair)var3.next();
            request.addAttribute((String)attribute.first, attribute.second);
         }
      }

   }
}
