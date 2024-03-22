package es.santander.justicia.minisJusticia.models.requests.activarExpediente;

import org.simpleframework.xml.Element;

public class ActivarExpedienteArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private ActivarExpedienteArg0Detail activarExpedienteArg0Detail;

   public ActivarExpedienteArg0(ActivarExpedienteArg0Detail activarExpedienteArg0Detail) {
      this.activarExpedienteArg0Detail = activarExpedienteArg0Detail;
   }
}
