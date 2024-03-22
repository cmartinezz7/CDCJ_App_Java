package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   strict = false
)
public class ServicioComerciable {
   @Element(
      name = "servicioComerciable",
      required = false
   )
   private String servicioComerciable;

   public String getServicioComerciable() {
      return this.servicioComerciable;
   }
}
