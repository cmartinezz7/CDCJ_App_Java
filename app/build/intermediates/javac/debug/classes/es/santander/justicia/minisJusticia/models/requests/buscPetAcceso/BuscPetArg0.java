package es.santander.justicia.minisJusticia.models.requests.buscPetAcceso;

import org.simpleframework.xml.Element;

public class BuscPetArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private BuscPetArg0Detail buscPetArg0Detail;

   public void setBuscPetArg0Detail(BuscPetArg0Detail buscPetArg0Detail) {
      this.buscPetArg0Detail = buscPetArg0Detail;
   }
}
