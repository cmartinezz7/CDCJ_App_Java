package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;

public class InfoDetail {
   @Element(
      name = "errorCode",
      required = false
   )
   private Integer erroCode;
   @Element(
      name = "token",
      required = false
   )
   private String token;

   public Integer getErroCode() {
      return this.erroCode;
   }

   public String getToken() {
      return this.token;
   }
}
