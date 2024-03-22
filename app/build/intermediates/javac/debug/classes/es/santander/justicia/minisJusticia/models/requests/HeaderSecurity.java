package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;

public class HeaderSecurity {
   @Element(
      name = "soapenv:Header",
      required = false
   )
   private SecurityHeaderGlobal securityHeaderGlobal = new SecurityHeaderGlobal();
}
