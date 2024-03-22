package es.santander.justicia.minisJusticia.models.requests.bajaEmbargo;

import org.simpleframework.xml.Element;

public class BajaEmbargoArg0Detail {
   @Element(
      name = "codigoUnidadOrganizativa",
      required = false
   )
   private String codigoUnidadOrganizativa;
   @Element(
      name = "numeroEmbargo",
      required = false
   )
   private String numeroEmbargo;
   @Element(
      name = "firma",
      required = false
   )
   private String firma;
   @Element(
      name = "observaciones",
      required = false
   )
   private String observaciones;

   public BajaEmbargoArg0Detail(String codigoUnidadOrganizativa, String numeroEmbargo, String firma, String observaciones) {
      this.codigoUnidadOrganizativa = codigoUnidadOrganizativa;
      this.numeroEmbargo = numeroEmbargo;
      this.firma = firma;
      if (observaciones != null) {
         this.observaciones = observaciones;
      }

   }
}
