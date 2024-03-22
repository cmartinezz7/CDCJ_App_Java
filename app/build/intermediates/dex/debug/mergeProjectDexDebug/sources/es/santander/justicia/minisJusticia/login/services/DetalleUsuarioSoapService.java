package es.santander.justicia.minisJusticia.login.services;

import android.util.Log;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.minisJusticia.common.services.JusticiaSoapService;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class DetalleUsuarioSoapService extends JusticiaSoapService {
    public DetalleUsuarioSoapService() {
        super(SoapWebServicesEnum.USER_DETAIL, "wsAccessRequestLS");
    }

    public String getNombreUsuario(String token) {
        SoapObject requestResult = null;
        try {
            requestResult = sendRequest((PropertyInfo) null, token);
        } catch (Exception e) {
            Log.i("DetalleMovSoapService", "Error al formatear la respuesta: " + e.getMessage());
        }
        try {
            return requestResult.hasProperty("name") ? requestResult.getProperty("name").toString() : "";
        } catch (Exception e2) {
            Log.i("DetalleMovSoapService", "Error al formatear la respuesta: " + e2.getMessage(), e2);
            return null;
        }
    }
}
