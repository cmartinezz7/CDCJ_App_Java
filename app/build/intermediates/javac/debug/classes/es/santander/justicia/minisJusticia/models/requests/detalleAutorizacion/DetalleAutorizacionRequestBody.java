package es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionRequestBody {
   @Element(
      name = "wsj:detalleAutorizacion",
      required = false
   )
   private DetalleAutorizacionArg0 detalleAutorizacionArg0;

   public DetalleAutorizacionRequestBody(DetalleAutorizacionArg0 detalleAutorizacionArg0) {
      this.detalleAutorizacionArg0 = detalleAutorizacionArg0;
   }
}
