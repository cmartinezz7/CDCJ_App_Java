package es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private DetalleAutorizacionArg0Detail detalleAutorizacionArg0Detail;

   public DetalleAutorizacionArg0(DetalleAutorizacionArg0Detail detalleAutorizacionArg0Detail) {
      this.detalleAutorizacionArg0Detail = detalleAutorizacionArg0Detail;
   }
}
