package es.santander.justicia.minisJusticia.models.requests.detallePetAcceso;

import org.simpleframework.xml.Element;

public class DetallePetAcceRequestBody {
   @Element(
      name = "wsj:detallePeticionAcceso",
      required = false
   )
   private DetallePetAccArg0 detallePetAccArg0;

   public DetallePetAcceRequestBody(DetallePetAccArg0 detallePetAccArg0) {
      this.detallePetAccArg0 = detallePetAccArg0;
   }
}
