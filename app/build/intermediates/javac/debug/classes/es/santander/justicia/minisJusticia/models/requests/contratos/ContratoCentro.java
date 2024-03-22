package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoCentro {
   @Element(
      name = "EMPRESA",
      required = false
   )
   private String empresa;
   @Element(
      name = "CENTRO",
      required = false
   )
   private String centro;

   public String getEmpresa() {
      return this.empresa;
   }

   public String getCentro() {
      return this.centro;
   }

   public void setEmpresa(String empresa) {
      this.empresa = empresa;
   }

   public void setCentro(String centro) {
      this.centro = centro;
   }
}
