package es.santander.justicia.minisJusticia.models.requests.detallePetAcceso;

import org.simpleframework.xml.Element;

public class DetallePetAccArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private DetallePetAccArg0Detail detallePetAccArg0Detail;

   public DetallePetAccArg0(DetallePetAccArg0Detail detallePetAccArg0Detail) {
      this.detallePetAccArg0Detail = detallePetAccArg0Detail;
   }
}
