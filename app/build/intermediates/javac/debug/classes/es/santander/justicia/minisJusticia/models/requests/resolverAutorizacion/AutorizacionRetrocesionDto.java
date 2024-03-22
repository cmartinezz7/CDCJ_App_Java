package es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion;

import org.simpleframework.xml.Element;

public class AutorizacionRetrocesionDto {
   @Element(
      name = "codOperacion",
      required = false
   )
   private String codOperacion;
   @Element(
      name = "codOrganismo",
      required = false
   )
   private String codOrganismo;
   @Element(
      name = "estado",
      required = false
   )
   private String estado;
   @Element(
      name = "motivoResolucion",
      required = false
   )
   private String motivoResolucion;

   public AutorizacionRetrocesionDto(String codOperacion, String codOrganismo, String estado, String motivoResolucion) {
      this.codOperacion = codOperacion;
      this.codOrganismo = codOrganismo;
      this.estado = estado;
      this.motivoResolucion = motivoResolucion;
   }
}
