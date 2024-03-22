package es.santander.justicia.minisJusticia.models.requests.detalleExp;

import org.simpleframework.xml.Element;

public class DetalleExpArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private DetalleExpArg0Detail detalleExpArg0Detail;

   public DetalleExpArg0(DetalleExpArg0Detail detalleExpArg0Detail) {
      this.detalleExpArg0Detail = detalleExpArg0Detail;
   }
}
