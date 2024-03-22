package es.santander.justicia.minisJusticia.models.requests.login;

import org.simpleframework.xml.Element;

public class LoginArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private LoginArg0Detail loginArg0Detail;

   public LoginArg0(LoginArg0Detail loginArg0Detail) {
      this.loginArg0Detail = loginArg0Detail;
   }
}
