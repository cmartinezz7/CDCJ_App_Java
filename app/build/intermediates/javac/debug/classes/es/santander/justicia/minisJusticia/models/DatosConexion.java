package es.santander.justicia.minisJusticia.models;

import org.simpleframework.xml.Element;

public class DatosConexion {
   @Element(
      name = "canalMarco",
      required = false
   )
   private String canalMarco = "EMP";
   @Element(
      name = "canal",
      required = false
   )
   private String canal;
   @Element(
      name = "empresa",
      required = false
   )
   private String empresa = "0049";

   public String getCanalMarco() {
      return this.canalMarco;
   }

   public String getEmpresa() {
      return this.empresa;
   }
}
