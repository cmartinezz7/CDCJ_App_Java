package es.santander.justicia.http;

import android.os.AsyncTask;
import android.util.Log;
import androidx.core.util.Pair;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
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

public class WSSoapClientUtility extends AsyncTask<SoapClientSettings, Void, Object> {
   private WsSoapResponse soapResponse;
   private SoapWebServicesEnum soapWebServiceEnum;
   private SoapObject response;

   public WSSoapClientUtility(WsSoapResponse soapResponse) {
      this.soapResponse = soapResponse;
   }

   protected Object doInBackground(SoapClientSettings... params) {
      SoapClientSettings soapSettings = params[0];
      this.soapWebServiceEnum = soapSettings.getSoapWebServicesEnum();
      String environment = soapSettings.getEnvironment();
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(soapSettings.getInitConfigName(), environment);
      String nameSpace = this.soapWebServiceEnum.getNameSpace();
      String method = this.soapWebServiceEnum.getMethodName();
      String soapAction = this.soapWebServiceEnum.getSoapAction();
      SoapObject request = new SoapObject("", method);
      this.addRequestAttributes(request, this.soapWebServiceEnum.getAttributes());
      PropertyInfo body = soapSettings.getBody();
      request.addProperty(body);
      SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
      Element[] header = new Element[]{(new Element()).createElement("", "wsse:Security")};
      header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
      Element pass = (new Element()).createElement("", "BinarySecurityToken");
      pass.addChild(4, LoginManager.getInstance().getToken());
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
         this.response = (SoapObject)envelope.getResponse();

         try {
            header = envelope.headerIn;
            String newToken = (String)header[0].getChild(0);
            LoginManager.getInstance().setToken(newToken);
         } catch (Exception var15) {
            Log.e("WSSoapClientUtility", "Error al refrescar el token", var15);
         }
      } catch (SoapFault var16) {
         return var16;
      } catch (XmlPullParserException var17) {
         Log.e("WSSoapClientUtility", "XmlPullParserException", var17);
      } catch (HttpResponseException var18) {
         Log.e("WSSoapClientUtility", "HttpResponseException", var18);
      } catch (IOException var19) {
         Log.e("WSSoapClientUtility", "IOException", var19);
      }

      return this.response;
   }

   protected void onPostExecute(Object response) {
      super.onPostExecute(response);
      if (response != null && !(response instanceof SoapFault)) {
         this.soapResponse.onWsSoapSuccess(this.soapWebServiceEnum, response);
      } else {
         this.soapResponse.onWsSoapError(this.soapWebServiceEnum, response);
      }

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
