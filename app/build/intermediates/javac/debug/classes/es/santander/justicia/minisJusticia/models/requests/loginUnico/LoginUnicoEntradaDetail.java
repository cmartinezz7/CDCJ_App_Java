package es.santander.justicia.minisJusticia.models.requests.loginUnico;

import org.simpleframework.xml.Element;

public class LoginUnicoEntradaDetail {
   @Element(
      name = "usuario",
      required = false
   )
   private String usuario;
   @Element(
      name = "password",
      required = false
   )
   private String password;
   @Element(
      name = "servicioComerciable",
      required = false
   )
   private String servicioComerciable;
   @Element(
      name = "indEstadoUsuario",
      required = false
   )
   private String indEstadoUsuario;

   public LoginUnicoEntradaDetail(String usuario, String password) {
      this.usuario = usuario;
      this.password = password;
      this.servicioComerciable = "AA";
   }
}
