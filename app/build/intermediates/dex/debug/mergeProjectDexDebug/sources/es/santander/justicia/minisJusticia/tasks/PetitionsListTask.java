package es.santander.justicia.minisJusticia.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.ListadoPeticionesActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.sharedService.handlerDates;
import es.santander.justicia.sharedService.petitionService;
import es.santander.justicia.soap.service.login.ErrorResponseLoginProfesionalesEmpresa;
import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.EntradaXmlListadoPeticiones;
import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.ParamsRequestListPetition.DatosFiltradoPetition;
import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.ResponseListadoPeticiones;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcessoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.NetworkUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class PetitionsListTask extends AsyncTask<Object, Object, Object> {
    private Activity activity;
    private Context context;
    public String dateToday;
    public DatosAcessoProfesionales datosAcessoProfesionales;
    public DatosFiltradoPetition datosFiltradoPetition;
    public DatosPaginacion datosPaginacion;
    public EntradaXmlListadoPeticiones entradaXmlListadoPeticiones;
    public handlerDates h;
    public PeticionDTO miPet;
    public petitionService p;
    public List<SoapObject> peticiones;
    private ProgressDialog progressDialog;
    public SoapObject response;
    public String tokenServ;
    public String url;

    public PetitionsListTask(Activity activity2) {
        this.activity = activity2;
        this.context = activity2.getBaseContext();
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        this.tokenServ = LoginManager.getInstance().getToken();
        String nameSpace = Constants.ConstantesPeticionesAcceso.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
        this.url = wsSettings.getUrl();
        handlerDates handlerdates = new handlerDates();
        this.h = handlerdates;
        this.dateToday = handlerdates.getDate();
        this.datosAcessoProfesionales = new DatosAcessoProfesionales("");
        this.datosPaginacion = new DatosPaginacion("1", "1000");
        this.entradaXmlListadoPeticiones = new EntradaXmlListadoPeticiones(this.datosAcessoProfesionales, "", this.datosPaginacion);
        SoapObject request = new SoapObject("", Constants.ConstantesPeticionesAcceso.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:sup", nameSpace);
        PropertyInfo arg = new PropertyInfo();
        arg.setName("arg0");
        arg.setValue(this.entradaXmlListadoPeticiones);
        arg.setType(this.entradaXmlListadoPeticiones.getClass());
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
            NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), nameSpace + Constants.ConstantesPeticionesAcceso.NOMBRE_SERVICIO.valor(), envelope, wsSettings.getConnectionTimeout());
            this.response = (SoapObject) envelope.getResponse();
            try {
                LoginManager.getInstance().setToken((String) envelope.headerIn[0].getChild(0));
            } catch (Exception e) {
                Log.e("PetitionsListTask", "Error al refrescar el token", e);
            }
        } catch (SoapFault soapFault) {
            return soapFault;
        } catch (XmlPullParserException e2) {
            Log.e("PetitionsListTask", "XmlPullParserException", e2);
        } catch (HttpResponseException e3) {
            Log.e("PetitionsListTask", "HttpResponseException", e3);
        } catch (IOException e4) {
            Log.e("PetitionsListTask", "IOException", e4);
        }
        return this.response;
    }

    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response2) {
        try {
            if (response2 instanceof SoapObject) {
                this.peticiones = new ResponseListadoPeticiones((SoapObject) response2).getListaPeticiones();
                ArrayList<PeticionDTO> misPeticiones = new ArrayList<>();
                for (SoapObject so : this.peticiones) {
                    PeticionDTO peticionDTO = new PeticionDTO(((SoapObject) so.getProperty("datosExpediente")).getProperty("codExpediente").toString(), so.getProperty("fecacept").toString(), so.getProperty("fecpetic").toString(), so.getProperty("jestactu").toString());
                    this.miPet = peticionDTO;
                    misPeticiones.add(peticionDTO);
                }
                petitionService instance = petitionService.getInstance();
                this.p = instance;
                instance.setPeticionDTO(misPeticiones);
                Intent intent = new Intent(this.activity, ListadoPeticionesActivity.class);
                intent.putExtra("peticiones", misPeticiones);
                this.activity.startActivity(intent);
                this.activity.finish();
                return;
            }
            Toast.makeText(this.activity, new ErrorResponseLoginProfesionalesEmpresa((SoapFault) response2).getErrorDesc(), 1).show();
        } catch (Exception e) {
            ProgressDialog progressDialog2 = this.progressDialog;
            if (progressDialog2 != null && progressDialog2.isShowing()) {
                this.progressDialog.dismiss();
            }
            Toast.makeText(this.activity.getApplicationContext(), "ERROR: Se ha producido un error al conectar con el servidor", 1).show();
        }
    }
}
