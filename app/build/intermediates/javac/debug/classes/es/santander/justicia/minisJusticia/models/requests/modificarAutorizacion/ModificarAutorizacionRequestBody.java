package es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion;

import org.simpleframework.xml.Element;

public class ModificarAutorizacionRequestBody {
   @Element(
      name = "wsj:modificarAutorizacion",
      required = false
   )
   private ModificarAutorizacionArg0 modificarAutorizacionArg0;

   public ModificarAutorizacionRequestBody(ModificarAutorizacionArg0 modificarAutorizacionArg0) {
      this.modificarAutorizacionArg0 = modificarAutorizacionArg0;
   }
}
