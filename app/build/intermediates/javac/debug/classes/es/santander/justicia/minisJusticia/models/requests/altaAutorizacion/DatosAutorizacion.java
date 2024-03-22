package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class DatosAutorizacion {
   @Element(
      name = "codNumDocumento",
      required = false
   )
   private String codNumDocumento;
   @Element(
      name = "codOrganismo",
      required = false
   )
   private String codOrganismo;
   @Element(
      name = "codTipoDocumento",
      required = false
   )
   private String codTipoDocumento;
   @Element(
      name = "fechaFinal",
      required = false
   )
   private String fechaFinal;
   @Element(
      name = "fechaInicial",
      required = false
   )
   private String fechaInicial;

   public DatosAutorizacion(String codNumDocumento, String codOrganismo, String fechaInicial, String fechaFinal, String docType) {
      this.codNumDocumento = codNumDocumento;
      this.codOrganismo = codOrganismo;
      this.codTipoDocumento = docType;
      this.fechaInicial = fechaInicial;
      this.fechaFinal = fechaFinal;
   }
}
