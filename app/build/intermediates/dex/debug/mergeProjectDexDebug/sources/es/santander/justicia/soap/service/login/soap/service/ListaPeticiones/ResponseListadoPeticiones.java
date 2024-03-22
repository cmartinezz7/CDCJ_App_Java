package es.santander.justicia.soap.service.login.soap.service.ListaPeticiones;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class ResponseListadoPeticiones {
    private List<SoapObject> listaPeticiones = new ArrayList();

    public ResponseListadoPeticiones(SoapObject responseSoapObject) {
        Log.i("LoginProfesionalesTask", "RequestMJ: " + ((SoapObject) responseSoapObject.getProperty("datosAcceso")));
        for (int i = 0; i < responseSoapObject.getPropertyCount() - 1; i++) {
            this.listaPeticiones.add((SoapObject) responseSoapObject.getProperty(i));
        }
    }

    public List<SoapObject> getListaPeticiones() {
        return this.listaPeticiones;
    }
}
