package es.santander.justicia.minisJusticia.common.services;

import androidx.core.util.Pair;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class JusticiaSoapService {
    private SoapWebServicesEnum soapWebServicesEnum;
    private String wsAccessRequest;

    public JusticiaSoapService(SoapWebServicesEnum soapWebServicesEnum2, String wsAccessRequest2) {
        this.soapWebServicesEnum = soapWebServicesEnum2;
        this.wsAccessRequest = wsAccessRequest2;
    }

    public SoapObject sendRequest(PropertyInfo body) {
        return sendRequest(body, LoginManager.getInstance().getToken());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00bb, code lost:
        android.util.Log.e("JusticiaSoapService", "Exception", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c2, code lost:
        android.util.Log.e("JusticiaSoapService", "IOException", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c9, code lost:
        android.util.Log.e("JusticiaSoapService", "HttpResponseException", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d0, code lost:
        android.util.Log.e("JusticiaSoapService", "XmlPullParserException", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d9, code lost:
        android.util.Log.i("JusticiaSoapService", "soapFault, return null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00df, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00c1 A[ExcHandler: IOException (r0v12 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c8 A[ExcHandler: HttpResponseException (r0v11 'e' org.ksoap2.transport.HttpResponseException A[CUSTOM_DECLARE]), Splitter:B:4:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cf A[ExcHandler: XmlPullParserException (r0v10 'e' org.xmlpull.v1.XmlPullParserException A[CUSTOM_DECLARE]), Splitter:B:4:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d8 A[ExcHandler: SoapFault (e org.ksoap2.SoapFault), Splitter:B:4:0x0089] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.ksoap2.serialization.SoapObject sendRequest(org.ksoap2.serialization.PropertyInfo r17, java.lang.String r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r3 = "JusticiaSoapService"
            java.lang.String r0 = r1.wsAccessRequest
            es.santander.justicia.minisJusticia.common.MainApplication r4 = es.santander.justicia.minisJusticia.common.MainApplication.getAppContext()
            java.lang.String r4 = r4.getEnvironment()
            es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO r4 = es.santander.justicia.minisJusticia.models.WebServiceModel.getWebServiceSettings(r0, r4)
            es.santander.justicia.http.enums.SoapWebServicesEnum r0 = r1.soapWebServicesEnum
            java.lang.String r5 = r0.getNameSpace()
            es.santander.justicia.http.enums.SoapWebServicesEnum r0 = r1.soapWebServicesEnum
            java.lang.String r6 = r0.getMethodName()
            es.santander.justicia.http.enums.SoapWebServicesEnum r0 = r1.soapWebServicesEnum
            java.lang.String r7 = r0.getSoapAction()
            org.ksoap2.serialization.SoapObject r0 = new org.ksoap2.serialization.SoapObject
            java.lang.String r8 = ""
            r0.<init>(r8, r6)
            r9 = r0
            es.santander.justicia.http.enums.SoapWebServicesEnum r0 = r1.soapWebServicesEnum
            java.util.ArrayList r0 = r0.getAttributes()
            r1.addRequestAttributes(r9, r0)
            if (r2 == 0) goto L_0x003c
            r9.addProperty(r2)
        L_0x003c:
            org.ksoap2.serialization.SoapSerializationEnvelope r0 = new org.ksoap2.serialization.SoapSerializationEnvelope
            r10 = 110(0x6e, float:1.54E-43)
            r0.<init>(r10)
            r10 = r0
            r0 = 1
            org.kxml2.kdom.Element[] r11 = new org.kxml2.kdom.Element[r0]
            org.kxml2.kdom.Element r12 = new org.kxml2.kdom.Element
            r12.<init>()
            java.lang.String r13 = "wsse:Security"
            org.kxml2.kdom.Element r12 = r12.createElement(r8, r13)
            r13 = 0
            r11[r13] = r12
            r12 = r11[r13]
            java.lang.String r14 = "xmlns:wsse"
            java.lang.String r15 = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"
            r12.setAttribute(r8, r14, r15)
            org.kxml2.kdom.Element r12 = new org.kxml2.kdom.Element
            r12.<init>()
            java.lang.String r14 = "BinarySecurityToken"
            org.kxml2.kdom.Element r8 = r12.createElement(r8, r14)
            r12 = 4
            r14 = r18
            r8.addChild(r12, r14)
            r12 = r11[r13]
            r15 = 2
            r12.addChild(r15, r8)
            r10.headerOut = r11
            r10.setOutputSoapObject(r9)
            org.ksoap2.serialization.MarshalFloat r12 = new org.ksoap2.serialization.MarshalFloat
            r12.<init>()
            r12.register(r10)
            r10.dotNet = r0
            r10.implicitTypes = r0
            r10.setAddAdornments(r13)
            java.lang.String r0 = r4.getUrl()     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            java.lang.String r15 = r4.getUrlCertificate()     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            int r13 = r4.getConnectionTimeout()     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            es.santander.justicia.utils.NetworkUtils.callSoapService(r0, r15, r7, r10, r13)     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            java.lang.Object r0 = r10.getResponse()     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            org.ksoap2.serialization.SoapObject r0 = (org.ksoap2.serialization.SoapObject) r0     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
            r13 = r0
            org.kxml2.kdom.Element[] r0 = r10.headerIn     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            r11 = r0
            r0 = 0
            r15 = r11[r0]     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            java.lang.Object r0 = r15.getChild(r0)     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            es.santander.justicia.minisJusticia.login.manager.LoginManager r15 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            r15.setToken(r0)     // Catch:{ Exception -> 0x00b3, SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1 }
            goto L_0x00b9
        L_0x00b3:
            r0 = move-exception
            java.lang.String r15 = "Error al refrescar el token"
            android.util.Log.e(r3, r15, r0)     // Catch:{ SoapFault -> 0x00d8, XmlPullParserException -> 0x00cf, HttpResponseException -> 0x00c8, IOException -> 0x00c1, Exception -> 0x00ba }
        L_0x00b9:
            return r13
        L_0x00ba:
            r0 = move-exception
            java.lang.String r13 = "Exception"
            android.util.Log.e(r3, r13, r0)
            goto L_0x00d6
        L_0x00c1:
            r0 = move-exception
            java.lang.String r13 = "IOException"
            android.util.Log.e(r3, r13, r0)
            goto L_0x00d5
        L_0x00c8:
            r0 = move-exception
            java.lang.String r13 = "HttpResponseException"
            android.util.Log.e(r3, r13, r0)
            goto L_0x00d5
        L_0x00cf:
            r0 = move-exception
            java.lang.String r13 = "XmlPullParserException"
            android.util.Log.e(r3, r13, r0)
        L_0x00d5:
        L_0x00d6:
            r13 = 0
            return r13
        L_0x00d8:
            r0 = move-exception
            r13 = 0
            java.lang.String r15 = "soapFault, return null"
            android.util.Log.i(r3, r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.common.services.JusticiaSoapService.sendRequest(org.ksoap2.serialization.PropertyInfo, java.lang.String):org.ksoap2.serialization.SoapObject");
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
