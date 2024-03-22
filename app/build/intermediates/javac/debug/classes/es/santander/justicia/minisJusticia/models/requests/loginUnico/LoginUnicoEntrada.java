package es.santander.justicia.minisJusticia.models.requests.loginUnico;

import es.santander.justicia.minisJusticia.models.DatosCabecera;
import es.santander.justicia.minisJusticia.models.DatosConexion;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class LoginUnicoEntrada {
   @Element(
      name = "entrada",
      required = false
   )
   private LoginUnicoEntradaDetail loginUnicoEntradaDetail;
   @Attribute(
      name = "facade"
   )
   private String facade = "ACEMPMOVContratos";
   @Element(
      name = "datosConexion",
      required = false
   )
   private DatosConexion datosConexion = new DatosConexion();
   @Element(
      name = "datosCabecera",
      required = false
   )
   private DatosCabecera datosCabecera = new DatosCabecera();

   public LoginUnicoEntrada(LoginUnicoEntradaDetail loginUnicoEntradaDetail) {
      this.loginUnicoEntradaDetail = loginUnicoEntradaDetail;
   }
}
