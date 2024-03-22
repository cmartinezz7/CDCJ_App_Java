package es.santander.justicia.minisJusticia.models.requests.detalleExp;

import org.simpleframework.xml.Element;

public class DetalleExpRequestBody {
   @Element(
      name = "wsj:detalleExpediente",
      required = false
   )
   private DetalleExpArg0 detalleExpArg0;

   public DetalleExpRequestBody(DetalleExpArg0 detalleExpArg0) {
      this.detalleExpArg0 = detalleExpArg0;
   }
}
