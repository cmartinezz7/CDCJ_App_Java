package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import org.simpleframework.xml.Element;

public class DatosAcceso {
   @Element(
      name = "datosExpediente",
      required = false
   )
   private DatosExpediente datosExpediente;

   public DatosAcceso(DatosExpediente datosExpediente) {
      this.datosExpediente = datosExpediente;
   }
}
