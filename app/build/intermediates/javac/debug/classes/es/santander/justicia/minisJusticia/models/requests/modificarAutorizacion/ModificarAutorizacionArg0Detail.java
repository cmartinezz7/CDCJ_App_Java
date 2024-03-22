package es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion;

import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionUsuario;
import org.simpleframework.xml.Element;

public class ModificarAutorizacionArg0Detail {
   @Element(
      name = "autorizacionUsuario"
   )
   private DetalleAutorizacionUsuario detalleAutorizacionUsuario;
   @Element(
      name = "fechaFinalModificacion"
   )
   private String fechaFinalModificacion;
   @Element(
      name = "fechaInicialModificacion"
   )
   private String fechaInicialModificacion;
   @Element(
      name = "firma"
   )
   private String firma;

   public ModificarAutorizacionArg0Detail(DetalleAutorizacionUsuario detalleAutorizacionUsuario) {
      this.detalleAutorizacionUsuario = detalleAutorizacionUsuario;
      this.fechaInicialModificacion = "";
   }

   public void setFechaFinalModificacion(String fechaFinalModificacion) {
      this.fechaFinalModificacion = fechaFinalModificacion;
   }

   public void setFirma(String firma) {
      this.firma = firma;
   }
}
