package es.santander.justicia.soap.service.login.soap.service.buscarPeticiones.ParamsRequestBuscarPeticiones;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class ResponseBuscarPeticiones {
    private List<SoapObject> listaPeticionesFiltroBusqueda = new ArrayList();

    public ResponseBuscarPeticiones(SoapObject responseSoapObject) {
        Log.i("LoginProfesionalesTask", "RequestMJ: " + ((SoapObject) responseSoapObject.getProperty("datosAcceso")));
        for (int i = 0; i < responseSoapObject.getPropertyCount() - 1; i++) {
            this.listaPeticionesFiltroBusqueda.add((SoapObject) responseSoapObject.getProperty(i));
        }
    }

    public List<SoapObject> getListaPeticiones() {
        return this.listaPeticionesFiltroBusqueda;
    }
}
