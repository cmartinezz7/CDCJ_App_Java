package es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas;

import org.simpleframework.xml.Element;

public class OperEjectArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private OperEjectArg0Detail operEjectArg0Detail;

   public OperEjectArg0(OperEjectArg0Detail operEjectArg0Detail) {
      this.operEjectArg0Detail = operEjectArg0Detail;
   }
}
