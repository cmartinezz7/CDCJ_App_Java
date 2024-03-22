package es.santander.justicia.minisJusticia.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.EntradaXmlBuscarExpediente;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcessoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosFiltrado;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.NetworkUtils;
import java.io.IOException;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class ExpedientDetailsTask extends AsyncTask<Object, Object, Object> {
    public String ENV;
    private Context context;
    public DatosAcessoProfesionales datosAcessoProfesionales;
    public DatosFiltrado datosFiltrado;
    public DatosPaginacion datosPaginacion;
    public EntradaXmlBuscarExpediente entradaXmlBuscarExpediente;
    public List<SoapObject> expedientes;
    public ExpedienteDTO miEsp;
    private ProgressDialog progressDialog;
    public SoapObject response;
    public String tokenServ;
    public String url;

    public ExpedientDetailsTask(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        this.tokenServ = LoginManager.getInstance().getToken();
        String nameSpace = Constants.ConstantesBuscarDetalleExpediente_LS.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
        this.url = wsSettings.getUrl();
        this.datosAcessoProfesionales = new DatosAcessoProfesionales("");
        SoapObject request = new SoapObject("", Constants.ConstantesBuscarDetalleExpediente_LS.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:sup", nameSpace);
        PropertyInfo arg = new PropertyInfo();
        arg.setName("arg0");
        arg.setValue(this.entradaXmlBuscarExpediente);
        arg.setType(this.entradaXmlBuscarExpediente.getClass());
        request.addProperty(arg);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        Element[] header = {new Element().createElement("", "wsse:Security")};
        header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        Element pass = new Element().createElement("", "BinarySecurityToken");
        pass.addChild(4, this.tokenServ);
        header[0].addChild(2, pass);
        envelope.headerOut = header;
        envelope.setOutputSoapObject(request);
        new MarshalFloat().register(envelope);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        try {
            NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), nameSpace + Constants.ConstantesBuscarExpediente_LS.NOMBRE_SERVICIO.valor(), envelope, wsSettings.getConnectionTimeout());
            this.response = (SoapObject) envelope.getResponse();
            try {
                LoginManager.getInstance().setToken((String) envelope.headerIn[0].getChild(0));
            } catch (Exception e) {
                Log.e("ExpedientDetailsTask", "Error al refrescar el token", e);
            }
        } catch (SoapFault soapFault) {
            return soapFault;
        } catch (XmlPullParserException e2) {
            Log.e("ExpedientDetailsTask", "XmlPullParserException", e2);
        } catch (HttpResponseException e3) {
            Log.e("ExpedientDetailsTask", "HttpResponseException", e3);
        } catch (IOException e4) {
            Log.e("ExpedientDetailsTask", "IOException", e4);
        }
        return this.response;
    }

    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response2) {
    }
}
