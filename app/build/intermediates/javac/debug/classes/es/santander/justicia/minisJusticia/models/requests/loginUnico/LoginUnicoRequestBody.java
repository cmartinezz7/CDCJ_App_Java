package es.santander.justicia.minisJusticia.models.requests.loginUnico;

import org.simpleframework.xml.Element;

public class LoginUnicoRequestBody {
   @Element(
      name = "v1:realizarLoginUnico_LA",
      required = false
   )
   private LoginUnicoEntrada loginUnicoEntrada;

   public LoginUnicoRequestBody(LoginUnicoEntrada loginUnicoEntrada) {
      this.loginUnicoEntrada = loginUnicoEntrada;
   }
}
