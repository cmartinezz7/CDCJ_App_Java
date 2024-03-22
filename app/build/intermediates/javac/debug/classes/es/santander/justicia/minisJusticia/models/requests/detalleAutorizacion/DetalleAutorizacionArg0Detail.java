package es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionArg0Detail {
   @Element(
      name = "autorizacionUsuario"
   )
   private DetalleAutorizacionUsuario detalleAutorizacionUsuario;

   public DetalleAutorizacionArg0Detail(DetalleAutorizacionUsuario detalleAutorizacionUsuario) {
      this.detalleAutorizacionUsuario = detalleAutorizacionUsuario;
   }
}
