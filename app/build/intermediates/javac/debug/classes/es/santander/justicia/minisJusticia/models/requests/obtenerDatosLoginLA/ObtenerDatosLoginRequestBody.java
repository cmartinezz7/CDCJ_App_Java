package es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA;

import org.simpleframework.xml.Element;

public class ObtenerDatosLoginRequestBody {
   @Element(
      name = "v1:obtenerDatosLogin_LA",
      required = false
   )
   private ObtenerDatosLoginEntrada entrada;

   public ObtenerDatosLoginRequestBody(ObtenerDatosLoginEntrada entrada) {
      this.entrada = entrada;
   }
}
