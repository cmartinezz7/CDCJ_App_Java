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
import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.FiltradoExpedientePeticiones;
import es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.ParamsRequestListPetition.DatosFiltradoPetition;
import es.santander.justicia.soap.service.login.soap.service.buscarPeticiones.ParamsRequestBuscarPeticiones.DatosAcessoProfesionalesBusqueda;
import es.santander.justicia.soap.service.login.soap.service.buscarPeticiones.ParamsRequestBuscarPeticiones.EntradaXmlBuscarPeticion;
import es.santander.justicia.soap.service.login.soap.service.buscarPeticiones.ParamsRequestBuscarPeticiones.ResponseBuscarPeticiones;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
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

public class PeticionSearchTask extends AsyncTask<Object, Object, Object> {
    private Activity activity;
    public Context context;
    public String dateToday;
    public DatosAcessoProfesionalesBusqueda datosAcessoProfesionales;
    public DatosExpediente datosExpediente;
    public DatosFiltradoPetition datosFiltradoPetition;
    public DatosPaginacion datosPaginacion;
    public EntradaXmlBuscarPeticion entradaXmlListadoPeticiones;
    public handlerDates h;
    public PeticionDTO miPet;
    public petitionService p;
    public List<SoapObject> peticiones;
    private ProgressDialog progressDialog;
    public SoapObject response;
    public String tokenServ;
    public String url;

    public PeticionSearchTask(Activity activity2) {
        this.activity = activity2;
        this.context = activity2.getBaseContext();
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        FiltradoExpedientePeticiones solicitudAccesoExpedient = params[0];
        handlerDates handlerdates = new handlerDates();
        this.h = handlerdates;
        this.dateToday = handlerdates.getDate();
        this.datosExpediente = new DatosExpediente(solicitudAccesoExpedient.getPart1(), solicitudAccesoExpedient.getPart2(), solicitudAccesoExpedient.getPart3(), solicitudAccesoExpedient.getPart4(), solicitudAccesoExpedient.getPart5());
        String tokenServ2 = LoginManager.getInstance().getToken();
        String nameSpace = Constants.ConstantesBuscarExpediente_LS.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
        this.datosAcessoProfesionales = new DatosAcessoProfesionalesBusqueda(this.datosExpediente);
        this.datosFiltradoPetition = new DatosFiltradoPetition(solicitudAccesoExpedient.getDatefrom(), solicitudAccesoExpedient.getDateto(), "1");
        this.datosPaginacion = new DatosPaginacion("1", "10");
        this.entradaXmlListadoPeticiones = new EntradaXmlBuscarPeticion(this.datosAcessoProfesionales, this.datosFiltradoPetition, this.datosPaginacion);
        SoapObject request = new SoapObject("", Constants.ConstantesBuscarPeticion_LS.NOMBRE_SERVICIO.valor());
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
        pass.addChild(4, tokenServ2);
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
                Log.e("PeticionSearchTask", "Error al refrescar el token", e);
            }
        } catch (SoapFault soapFault) {
            return soapFault;
        } catch (XmlPullParserException e2) {
            Log.e("PeticionSearchTask", "XmlPullParserException", e2);
        } catch (HttpResponseException e3) {
            Log.e("PeticionSearchTask", "HttpResponseException", e3);
        } catch (IOException e4) {
            Log.e("PeticionSearchTask", "IOException", e4);
        }
        return this.response;
    }

    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response2) {
        try {
            if (response2 instanceof SoapObject) {
                this.peticiones = new ResponseBuscarPeticiones((SoapObject) response2).getListaPeticiones();
                ArrayList<PeticionDTO> misPeticiones = new ArrayList<>();
                for (SoapObject so : this.peticiones) {
                    PeticionDTO peticionDTO = new PeticionDTO(((SoapObject) so.getProperty("datosExpediente")).getProperty("codExpediente").toString(), so.getProperty("fecacept").toString(), so.getProperty("fecpetic").toString(), so.getProperty("jestactu").toString());
                    this.miPet = peticionDTO;
                    misPeticiones.add(peticionDTO);
                }
                petitionService instance = petitionService.getInstance();
                this.p = instance;
                instance.setPeticionDTO(misPeticiones);
                Intent intent = new Intent(this.context, ListadoPeticionesActivity.class);
                intent.putExtra("peticiones", misPeticiones);
                this.context.startActivity(intent);
                ((Activity) this.context).finish();
                return;
            }
            Toast.makeText(this.activity, new ErrorResponseLoginProfesionalesEmpresa((SoapFault) response2).getErrorDesc(), 1).show();
        } catch (Exception e) {
            Toast.makeText(this.activity.getApplicationContext(), "ERROR: Se ha producido un error al conectar con el servidor", 1).show();
        }
    }
}
