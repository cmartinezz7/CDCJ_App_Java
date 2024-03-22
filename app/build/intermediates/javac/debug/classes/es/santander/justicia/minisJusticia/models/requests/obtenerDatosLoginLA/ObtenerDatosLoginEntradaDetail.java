package es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA;

import org.simpleframework.xml.Element;

public class ObtenerDatosLoginEntradaDetail {
   @Element(
      name = "alias",
      required = false
   )
   private String alias;
   @Element(
      name = "token",
      required = false
   )
   private String token;
   @Element(
      name = "usuarioRaf",
      required = false
   )
   private String usuarioRaf;
   @Element(
      name = "servicioComerciable",
      required = false
   )
   private String servicioComerciable;

   public ObtenerDatosLoginEntradaDetail(String alias, String token, String usuarioRaf, String servicioComerciable) {
      this.alias = alias;
      this.token = token;
      this.usuarioRaf = usuarioRaf;
      this.servicioComerciable = "AA";
   }
}
