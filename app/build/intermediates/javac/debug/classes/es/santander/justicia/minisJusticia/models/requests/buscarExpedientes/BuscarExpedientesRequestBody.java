package es.santander.justicia.minisJusticia.models.requests.buscarExpedientes;

import org.simpleframework.xml.Element;

public class BuscarExpedientesRequestBody {
   @Element(
      name = "wsj:buscarExpedientes"
   )
   private BuscarExpedientesArg0 buscarExpedientesArg0;

   public BuscarExpedientesRequestBody(BuscarExpedientesArg0 buscarExpedientesArg0) {
      this.buscarExpedientesArg0 = buscarExpedientesArg0;
   }
}
