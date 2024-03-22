package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;

public class ErrorResponseDetail {
   @Element(
      name = "faultcode"
   )
   private String faultcode;
   @Element(
      name = "faultstring"
   )
   private String faultstring;

   public String getFaultcode() {
      return this.faultcode;
   }

   public String getFaultstring() {
      return this.faultstring;
   }
}
