package es.santander.justicia.minisJusticia.models.requests.cambiarOrganismo;

import org.simpleframework.xml.Element;

public class CambiarOrganismoRequestBody {
   @Element(
      name = "wsj:cambiarOrganismo",
      required = false
   )
   private CambarOrganismoAsigArg0 cambarOrganismoAsigArg0;

   public void setCambarOrganismoAsigArg0(CambarOrganismoAsigArg0 cambarOrganismoAsigArg0) {
      this.cambarOrganismoAsigArg0 = cambarOrganismoAsigArg0;
   }
}
