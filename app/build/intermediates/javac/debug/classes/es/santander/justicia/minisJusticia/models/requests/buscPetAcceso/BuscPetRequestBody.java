package es.santander.justicia.minisJusticia.models.requests.buscPetAcceso;

import org.simpleframework.xml.Element;

public class BuscPetRequestBody {
   @Element(
      name = "wsj:buscarPeticionesAcceso",
      required = false
   )
   private BuscPetArg0 buscPetArg0;

   public void setBuscPetArg0(BuscPetArg0 buscPetArg0) {
      this.buscPetArg0 = buscPetArg0;
   }
}
