package es.santander.justicia.minisJusticia.models.requests.authJuzgados;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import java.io.Serializable;
import org.simpleframework.xml.Element;

public class AuthJuzgadosArg0Detail implements Serializable {
   @Element(
      name = "datosPaginacion",
      required = false
   )
   private DatosPaginacionRequest datosPaginacionRequest;
   @Element(
      name = "codNumDocumento",
      required = false
   )
   private String codNumDocumento;
   @Element(
      name = "codOrganismo",
      required = false
   )
   private String codOrganismo;
   @Element(
      name = "codTipoDocumento",
      required = false
   )
   private String codTipoDocumento;
   @Element(
      name = "fechaFinal",
      required = false
   )
   private String fechaFinal;
   @Element(
      name = "fechaInicial",
      required = false
   )
   private String fechaInicial;
   @Element(
      name = "indCaducadas",
      required = false
   )
   private String indCaducadas;

   public void setDatosPaginacionRequest(DatosPaginacionRequest datosPaginacionRequest) {
      this.datosPaginacionRequest = datosPaginacionRequest;
   }

   public void setCodNumDocumento(String codNumDocumento) {
      this.codNumDocumento = codNumDocumento;
   }

   public void setCodOrganismo(String codOrganismo) {
      this.codOrganismo = codOrganismo;
   }

   public void setCodTipoDocumento(String codTipoDocumento) {
      this.codTipoDocumento = codTipoDocumento;
   }

   public void setFechaFinal(String fechaFinal) {
      this.fechaFinal = fechaFinal;
   }

   public void setFechaInicial(String fechaInicial) {
      this.fechaInicial = fechaInicial;
   }

   public void setIndCaducadas(String indCaducadas) {
      this.indCaducadas = indCaducadas;
   }

   public DatosPaginacionRequest getDatosPaginacionRequest() {
      return this.datosPaginacionRequest;
   }

   public String getCodNumDocumento() {
      return this.codNumDocumento;
   }

   public String getCodOrganismo() {
      return this.codOrganismo;
   }

   public String getCodTipoDocumento() {
      return this.codTipoDocumento;
   }

   public String getFechaFinal() {
      return this.fechaFinal;
   }

   public String getFechaInicial() {
      return this.fechaInicial;
   }

   public String getIndCaducadas() {
      return this.indCaducadas;
   }
}
