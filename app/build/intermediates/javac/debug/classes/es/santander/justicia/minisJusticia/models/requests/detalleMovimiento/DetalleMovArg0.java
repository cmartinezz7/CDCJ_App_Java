package es.santander.justicia.minisJusticia.models.requests.detalleMovimiento;

import org.simpleframework.xml.Element;

public class DetalleMovArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private DetalleMovArg0Detail detalleMovArg0Detail;

   public DetalleMovArg0(DetalleMovArg0Detail detalleMovArg0Detail) {
      this.detalleMovArg0Detail = detalleMovArg0Detail;
   }
}
