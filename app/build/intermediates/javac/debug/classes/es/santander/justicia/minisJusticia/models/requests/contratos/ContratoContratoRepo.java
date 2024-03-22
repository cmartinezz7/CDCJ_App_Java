package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoContratoRepo {
   @Element(
      name = "CENTRO",
      required = false
   )
   private ContratoCentro contratosCentro;
   @Element(
      name = "PRODUCTO",
      required = false
   )
   private String producto;
   @Element(
      name = "NUMERO_DE_CONTRATO",
      required = false
   )
   private String numerDeContrato;

   public ContratoCentro getContratosCentro() {
      return this.contratosCentro;
   }

   public String getProducto() {
      return this.producto;
   }

   public String getNumerDeContrato() {
      return this.numerDeContrato;
   }

   public void setContratosCentro(ContratoCentro contratosCentro) {
      this.contratosCentro = contratosCentro;
   }

   public void setProducto(String producto) {
      this.producto = producto;
   }

   public void setNumerDeContrato(String numerDeContrato) {
      this.numerDeContrato = numerDeContrato;
   }
}
