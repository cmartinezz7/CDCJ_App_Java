package es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo;

import org.simpleframework.xml.Element;

public class CambiarOrganismoArg0Detail {
   @Element(
      name = "codUOSeleccionado"
   )
   private String codUOSeleccionado;

   public CambiarOrganismoArg0Detail(String codUOSeleccionado) {
      this.codUOSeleccionado = codUOSeleccionado;
   }
}
