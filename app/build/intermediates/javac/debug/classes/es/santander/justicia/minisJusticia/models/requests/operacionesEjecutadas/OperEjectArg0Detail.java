package es.santander.justicia.minisJusticia.models.requests.operacionesEjecutadas;

import org.simpleframework.xml.Element;

public class OperEjectArg0Detail {
   @Element(
      name = "coduo"
   )
   private String coduo;
   @Element(
      name = "codMon"
   )
   private String codMon;
   @Element(
      name = "rango"
   )
   private int rango;

   public OperEjectArg0Detail(String coduo, String codMon, int rango) {
      this.coduo = coduo;
      this.codMon = codMon;
      this.rango = rango;
   }
}
