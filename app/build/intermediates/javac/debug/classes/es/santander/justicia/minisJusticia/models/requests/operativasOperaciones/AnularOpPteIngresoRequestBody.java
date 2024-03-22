package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class AnularOpPteIngresoRequestBody {
   @Element(
      name = "wsj:anularOpPteIngreso",
      required = false
   )
   private OperGlobalArg0 operGlobalArg0;

   public AnularOpPteIngresoRequestBody(OperGlobalArg0 operGlobalArg0) {
      this.operGlobalArg0 = operGlobalArg0;
   }
}
