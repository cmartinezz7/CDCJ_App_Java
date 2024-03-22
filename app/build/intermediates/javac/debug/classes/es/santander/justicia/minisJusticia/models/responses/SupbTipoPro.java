package es.santander.justicia.minisJusticia.models.responses;

import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoTipoProducto;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   strict = false
)
public class SupbTipoPro {
   @Element(
      name = "TIPO_DE_PRODUCTO",
      required = false
   )
   private LoginUnicoTipoProducto loginUnicoTipoProducto;

   public LoginUnicoTipoProducto getLoginUnicoTipoProducto() {
      return this.loginUnicoTipoProducto;
   }
}
