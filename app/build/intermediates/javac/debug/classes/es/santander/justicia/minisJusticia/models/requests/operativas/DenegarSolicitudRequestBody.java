package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;

public class DenegarSolicitudRequestBody {
   @Element(
      name = "wsj:denegarSolicitudProfesional",
      required = false
   )
   private OperativasGlobalArg0 operativasGlobalArg0;

   public DenegarSolicitudRequestBody(OperativasGlobalArg0 operativasGlobalArg0) {
      this.operativasGlobalArg0 = operativasGlobalArg0;
   }
}
