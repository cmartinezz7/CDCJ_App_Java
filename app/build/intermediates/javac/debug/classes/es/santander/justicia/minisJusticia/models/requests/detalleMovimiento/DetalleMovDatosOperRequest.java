package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import org.simpleframework.xml.Element;

public class DetalleMovDatosOperRequest {
   @Element(
      name = "datosExpediente",
      required = false
   )
   private DetalleMovDatosExp detalleMovDatosExp;
   @Element(
      name = "jnuoper",
      required = false
   )
   private String jnuoper;

   public DetalleMovDatosOperRequest(DetalleMovDatosExp detalleMovDatosExp, String jnuoper) {
      this.detalleMovDatosExp = detalleMovDatosExp;
      this.jnuoper = jnuoper;
   }
}
