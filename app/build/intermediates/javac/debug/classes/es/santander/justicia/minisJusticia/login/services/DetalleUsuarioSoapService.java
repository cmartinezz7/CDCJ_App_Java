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
         requestResult = this.sendRequest((PropertyInfo)null, token);
      } catch (Exception var5) {
         Log.i("DetalleMovSoapService", "Error al formatear la respuesta: " + var5.getMessage());
      }

      try {
         String name = requestResult.hasProperty("name") ? requestResult.getProperty("name").toString() : "";
         return name;
      } catch (Exception var4) {
         Log.i("DetalleMovSoapService", "Error al formatear la respuesta: " + var4.getMessage(), var4);
         return null;
      }
   }
}
