package es.santander.justicia.minisJusticia.models.requests.activarExpediente;

import org.simpleframework.xml.Element;

public class ActivarExpedienteRequestBody {
   @Element(
      name = "wsj:activarExpediente",
      required = false
   )
   private ActivarExpedienteArg0 activarExpedienteArg0;

   public ActivarExpedienteRequestBody(ActivarExpedienteArg0 activarExpedienteArg0) {
      this.activarExpedienteArg0 = activarExpedienteArg0;
   }
}
