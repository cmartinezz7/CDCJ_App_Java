package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class AnularOpPteConfRequesBody {
   @Element(
      name = "wsj:anularOpPteConfirmacion",
      required = false
   )
   private OperGlobalArg0 operGlobalArg0;

   public AnularOpPteConfRequesBody(OperGlobalArg0 operGlobalArg0) {
      this.operGlobalArg0 = operGlobalArg0;
   }
}
