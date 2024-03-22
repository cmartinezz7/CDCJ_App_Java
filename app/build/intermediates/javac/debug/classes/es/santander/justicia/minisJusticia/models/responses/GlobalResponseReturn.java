package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;

public class GlobalResponseReturn {
   @Element(
      name = "return",
      required = false
   )
   private GlobalResponseResultDetail responseResultDetail;

   public GlobalResponseResultDetail getResponseResultDetail() {
      return this.responseResultDetail;
   }
}
