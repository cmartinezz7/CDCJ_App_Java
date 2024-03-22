package es.santander.justicia.minisJusticia.models.requests.advices;

import org.simpleframework.xml.Element;

public class AdvicesArg0Detail {
   @Element(
      name = "codUo",
      required = false
   )
   private String codUo;

   public String getCodUo() {
      return this.codUo;
   }

   public void setData(String codUo) {
      this.codUo = codUo;
   }
}
