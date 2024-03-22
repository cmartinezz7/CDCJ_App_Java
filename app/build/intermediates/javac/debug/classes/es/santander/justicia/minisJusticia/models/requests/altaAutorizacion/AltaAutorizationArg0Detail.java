package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class AltaAutorizationArg0Detail {
   @Element(
      name = "datosAutorizacion",
      required = false
   )
   private DatosAutorizacion datosAutorizacion;
   @Element(
      name = "firma",
      required = false
   )
   private String firma;

   public DatosAutorizacion getDatosAutorizacion() {
      return this.datosAutorizacion;
   }

   public void setDatosAutorizacion(DatosAutorizacion datosAutorizacion) {
      this.datosAutorizacion = datosAutorizacion;
   }

   public String getFirma() {
      return this.firma;
   }

   public void setFirma(String firma) {
      this.firma = firma;
   }
}
