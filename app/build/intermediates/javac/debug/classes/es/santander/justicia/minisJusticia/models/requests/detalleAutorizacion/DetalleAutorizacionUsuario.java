package es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion;

import org.simpleframework.xml.Element;

public class DetalleAutorizacionUsuario {
   @Element(
      name = "codNumDocumento"
   )
   private String codNumDocumento;
   @Element(
      name = "codOrganismo"
   )
   private String codOrganismo;
   @Element(
      name = "codTipoDocumento"
   )
   private String codTipoDocumento;
   @Element(
      name = "codUsuario"
   )
   private String codUsuario;
   @Element(
      name = "fechaFinal"
   )
   private String fechaFinal;
   @Element(
      name = "fechaInicial"
   )
   private String fechaInicial;

   public String getCodNumDocumento() {
      return this.codNumDocumento;
   }

   public void setCodNumDocumento(String codNumDocumento) {
      this.codNumDocumento = codNumDocumento;
   }

   public String getCodOrganismo() {
      return this.codOrganismo;
   }

   public void setCodOrganismo(String codOrganismo) {
      this.codOrganismo = codOrganismo;
   }

   public String getCodTipoDocumento() {
      return this.codTipoDocumento;
   }

   public void setCodTipoDocumento(String codTipoDocumento) {
      this.codTipoDocumento = codTipoDocumento;
   }

   public String getCodUsuario() {
      return this.codUsuario;
   }

   public void setCodUsuario(String codUsuario) {
      this.codUsuario = codUsuario;
   }

   public String getFechaFinal() {
      return this.fechaFinal;
   }

   public void setFechaFinal(String fechaFinal) {
      this.fechaFinal = fechaFinal;
   }

   public String getFechaInicial() {
      return this.fechaInicial;
   }

   public void setFechaInicial(String fechaInicial) {
      this.fechaInicial = fechaInicial;
   }
}
