package es.santander.justicia.minisJusticia.dto;

import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import java.io.Serializable;

public class MovementItemDTO implements Serializable {
   private boolean detail;
   private boolean esLetrado;
   private String jResponsableFirmeza;
   private String jimpnomi;
   private String jnors;
   private String jnuoper;
   private String importe;
   private String jtipomod;
   private String moneda;
   private String numerosr;
   private String seralfab;
   private String serieYMandamiento;
   private MovementStatusEnum movementStatus;
   private String expedienteDestino;
   private String importeSaldo;
   private String representado;
   private String documento;
   private String representante;
   private String concepto;
   private String fecha;
   private String codmon;
   private String desctipomod;
   private String jfechare;
   private String importeDetalle;
   private String jFechaFirma;
   private String jFechaFirmeza;
   private String jFechaAutorizacion;
   private String jFechaConfirmacion;
   private String jFechaAnulacion;
   private String jFechaCaducidad;
   private String jResponsableAlta;
   private String jResponsableFirma;
   private String jTotalAbono;
   private String jTotalCargo;
   private String jTotalImportePendiente;
   private String jResponsableAutorizacion;
   private String jResponsableConfirmacion;

   public String getjTotalAbono() {
      return this.jTotalAbono;
   }

   public void setjTotalAbono(String jTotalAbono) {
      this.jTotalAbono = jTotalAbono;
   }

   public String getjTotalCargo() {
      return this.jTotalCargo;
   }

   public void setjTotalCargo(String jTotalCargo) {
      this.jTotalCargo = jTotalCargo;
   }

   public String getjTotalImportePendiente() {
      return this.jTotalImportePendiente;
   }

   public void setjTotalImportePendiente(String jTotalImportePendiente) {
      this.jTotalImportePendiente = jTotalImportePendiente;
   }

   public String getjResponsableConfirmacion() {
      return this.jResponsableConfirmacion;
   }

   public void setjResponsableConfirmacion(String jResponsableConfirmacion) {
      this.jResponsableConfirmacion = jResponsableConfirmacion;
   }

   public String getjResponsableAutorizacion() {
      return this.jResponsableAutorizacion;
   }

   public void setjResponsableAutorizacion(String jResponsableAutorizacion) {
      this.jResponsableAutorizacion = jResponsableAutorizacion;
   }

   public String getjResponsableFirmeza() {
      return this.jResponsableFirmeza;
   }

   public void setjResponsableFirmeza(String jResponsableFirmeza) {
      this.jResponsableFirmeza = jResponsableFirmeza;
   }

   public String getjResponsableFirma() {
      return this.jResponsableFirma;
   }

   public void setjResponsableFirma(String jResponsableFirma) {
      this.jResponsableFirma = jResponsableFirma;
   }

   public String getjResponsableAlta() {
      return this.jResponsableAlta;
   }

   public void setjResponsableAlta(String jResponsableAlta) {
      this.jResponsableAlta = jResponsableAlta;
   }

   public String getJtipomod() {
      return this.jtipomod;
   }

   public void setJtipomod(String jtipomod) {
      this.jtipomod = jtipomod;
   }

   public String getjFechaFirma() {
      return this.jFechaFirma;
   }

   public void setjFechaFirma(String jFechaFirma) {
      this.jFechaFirma = jFechaFirma;
   }

   public String getjFechaFirmeza() {
      return this.jFechaFirmeza;
   }

   public void setjFechaFirmeza(String jFechaFirmeza) {
      this.jFechaFirmeza = jFechaFirmeza;
   }

   public String getjFechaAutorizacion() {
      return this.jFechaAutorizacion;
   }

   public void setjFechaAutorizacion(String jFechaAutorizacion) {
      this.jFechaAutorizacion = jFechaAutorizacion;
   }

   public String getjFechaConfirmacion() {
      return this.jFechaConfirmacion;
   }

   public void setjFechaConfirmacion(String jFechaConfirmacion) {
      this.jFechaConfirmacion = jFechaConfirmacion;
   }

   public String getjFechaAnulacion() {
      return this.jFechaAnulacion;
   }

   public void setjFechaAnulacion(String jFechaAnulacion) {
      this.jFechaAnulacion = jFechaAnulacion;
   }

   public String getjFechaCaducidad() {
      return this.jFechaCaducidad;
   }

   public void setjFechaCaducidad(String jFechaCaducidad) {
      this.jFechaCaducidad = jFechaCaducidad;
   }

   public boolean isDetail() {
      return this.detail;
   }

   public void setDetail(boolean detail) {
      this.detail = detail;
   }

   public String getCodmon() {
      return this.codmon;
   }

   public void setCodmon(String codmon) {
      this.codmon = codmon;
   }

   public String getDesctipomod() {
      return this.desctipomod;
   }

   public void setDesctipomod(String desctipomod) {
      this.desctipomod = desctipomod;
   }

   public String getJfechare() {
      return this.jfechare;
   }

   public void setJfechare(String jfechare) {
      this.jfechare = jfechare;
   }

   public String getJimpnomi() {
      return this.jimpnomi;
   }

   public void setJimpnomi(String jimpnomi) {
      this.jimpnomi = jimpnomi;
   }

   public String getJnors() {
      return this.jnors;
   }

   public void setJnors(String jnors) {
      this.jnors = jnors;
   }

   public String getJnuoper() {
      return this.jnuoper;
   }

   public void setJnuoper(String jnuoper) {
      this.jnuoper = jnuoper;
   }

   public String getImporte() {
      return this.importe;
   }

   public void setImporte(String importe) {
      this.importe = importe;
   }

   public String getMoneda() {
      return this.moneda;
   }

   public void setMoneda(String moneda) {
      this.moneda = moneda;
   }

   public String getNumerosr() {
      return this.numerosr;
   }

   public void setNumerosr(String numerosr) {
      this.numerosr = numerosr;
   }

   public String getSeralfab() {
      return this.seralfab;
   }

   public void setSeralfab(String seralfab) {
      this.seralfab = seralfab;
   }

   public String getSerieYMandamiento() {
      return this.serieYMandamiento;
   }

   public void setSerieYMandamiento(String serieYMandamiento) {
      this.serieYMandamiento = serieYMandamiento;
   }

   public MovementStatusEnum getMovementStatus() {
      return this.movementStatus;
   }

   public void setMovementStatus(MovementStatusEnum movementStatus) {
      this.movementStatus = movementStatus;
   }

   public String getExpedienteDestino() {
      return this.expedienteDestino;
   }

   public void setExpedienteDestino(String expedienteDestino) {
      this.expedienteDestino = expedienteDestino;
   }

   public String getImporteSaldo() {
      return this.importeSaldo;
   }

   public void setImporteSaldo(String importeSaldo) {
      this.importeSaldo = importeSaldo;
   }

   public String getRepresentado() {
      return this.representado;
   }

   public void setRepresentado(String representado) {
      this.representado = representado;
   }

   public String getDocumento() {
      return this.documento;
   }

   public void setDocumento(String documento) {
      this.documento = documento;
   }

   public String getRepresentante() {
      return this.representante;
   }

   public void setRepresentante(String representante) {
      this.representante = representante;
   }

   public String getFecha() {
      return this.fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public String getConcepto() {
      return this.concepto;
   }

   public void setConcepto(String concepto) {
      this.concepto = concepto;
   }

   public String getImporteDetalle() {
      return this.importeDetalle;
   }

   public void setImporteDetalle(String importeDetalle) {
      this.importeDetalle = importeDetalle;
   }

   public String toString() {
      return this.desctipomod;
   }

   public boolean isEsLetrado() {
      return this.esLetrado;
   }

   public void setEsLetrado(boolean esLetrado) {
      this.esLetrado = esLetrado;
   }
}
