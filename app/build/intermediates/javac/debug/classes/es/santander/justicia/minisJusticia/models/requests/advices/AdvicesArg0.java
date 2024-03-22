package es.santander.justicia.minisJusticia.models.requests.advices;

import org.simpleframework.xml.Element;

public class AdvicesArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private AdvicesArg0Detail codUo;

   public AdvicesArg0Detail getCodUo() {
      return this.codUo;
   }

   public void setCodUo(AdvicesArg0Detail codUo) {
      this.codUo = codUo;
   }
}
