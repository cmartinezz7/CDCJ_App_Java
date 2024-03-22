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
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class WSSoapClientUtility extends AsyncTask<SoapClientSettings, Void, Object> {
    private SoapObject response;
    private WsSoapResponse soapResponse;
    private SoapWebServicesEnum soapWebServiceEnum;

    public WSSoapClientUtility(WsSoapResponse soapResponse2) {
        this.soapResponse = soapResponse2;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(SoapClientSettings... params) {
        SoapClientSettings soapSettings = params[0];
        this.soapWebServiceEnum = soapSettings.getSoapWebServicesEnum();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(soapSettings.getInitConfigName(), soapSettings.getEnvironment());
        String nameSpace = this.soapWebServiceEnum.getNameSpace();
        String method = this.soapWebServiceEnum.getMethodName();
        String soapAction = this.soapWebServiceEnum.getSoapAction();
        SoapObject request = new SoapObject("", method);
        addRequestAttributes(request, this.soapWebServiceEnum.getAttributes());
        request.addProperty(soapSettings.getBody());
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        Element[] header = {new Element().createElement("", "wsse:Security")};
        header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        Element pass = new Element().createElement("", "BinarySecurityToken");
        pass.addChild(4, LoginManager.getInstance().getToken());
        header[0].addChild(2, pass);
        envelope.headerOut = header;
        envelope.setOutputSoapObject(request);
        new MarshalFloat().register(envelope);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        try {
            SoapClientSettings soapClientSettings = soapSettings;
            try {
                NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
                this.response = (SoapObject) envelope.getResponse();
                try {
                    LoginManager.getInstance().setToken((String) envelope.headerIn[0].getChild(0));
                } catch (Exception e) {
                    Log.e("WSSoapClientUtility", "Error al refrescar el token", e);
                }
            } catch (SoapFault soapFault) {
                return soapFault;
            } catch (XmlPullParserException e2) {
                e = e2;
                Log.e("WSSoapClientUtility", "XmlPullParserException", e);
                return this.response;
            } catch (HttpResponseException e3) {
                e = e3;
                Log.e("WSSoapClientUtility", "HttpResponseException", e);
                return this.response;
            } catch (IOException e4) {
                e = e4;
                Log.e("WSSoapClientUtility", "IOException", e);
                return this.response;
            }
        } catch (SoapFault soapFault2) {
            SoapClientSettings soapClientSettings2 = soapSettings;
            return soapFault2;
        } catch (XmlPullParserException e5) {
            e = e5;
            SoapClientSettings soapClientSettings3 = soapSettings;
            Log.e("WSSoapClientUtility", "XmlPullParserException", e);
            return this.response;
        } catch (HttpResponseException e6) {
            e = e6;
            SoapClientSettings soapClientSettings4 = soapSettings;
            Log.e("WSSoapClientUtility", "HttpResponseException", e);
            return this.response;
        } catch (IOException e7) {
            e = e7;
            SoapClientSettings soapClientSettings5 = soapSettings;
            Log.e("WSSoapClientUtility", "IOException", e);
            return this.response;
        }
        return this.response;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response2) {
        super.onPostExecute(response2);
        if (response2 == null || (response2 instanceof SoapFault)) {
            this.soapResponse.onWsSoapError(this.soapWebServiceEnum, response2);
        } else {
            this.soapResponse.onWsSoapSuccess(this.soapWebServiceEnum, response2);
        }
    }

    private void addRequestAttributes(SoapObject request, ArrayList<Pair<String, String>> attributes) {
        if (!attributes.isEmpty()) {
            Iterator<Pair<String, String>> it = attributes.iterator();
            while (it.hasNext()) {
                Pair<String, String> attribute = (Pair) it.next();
                request.addAttribute((String) attribute.first, attribute.second);
            }
        }
    }
}
