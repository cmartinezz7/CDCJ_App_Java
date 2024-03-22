package es.santander.justicia.minisJusticia.models.requests.login;

import org.simpleframework.xml.Element;

public class LoginArg0Detail {
   @Element(
      name = "coddocum",
      required = false
   )
   private String coddocum;
   @Element(
      name = "jusuario",
      required = false
   )
   private String jusuario;
   @Element(
      name = "password",
      required = false
   )
   private String password;
   @Element(
      name = "tipdoc",
      required = false
   )
   private String tipdoc;
   @Element(
      name = "version",
      required = false
   )
   private String version;

   public LoginArg0Detail(String coddocum, String jusuario, String password, String tipdoc) {
      this.coddocum = coddocum;
      this.jusuario = jusuario;
      this.password = password;
      this.tipdoc = tipdoc;
      this.version = "2.0";
   }
}
