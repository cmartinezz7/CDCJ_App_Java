package es.santander.justicia.minisJusticia.dto;

import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import java.io.Serializable;

public class MovementItemDTO implements Serializable {
    private String codmon;
    private String concepto;
    private String desctipomod;
    private boolean detail;
    private String documento;
    private boolean esLetrado;
    private String expedienteDestino;
    private String fecha;
    private String importe;
    private String importeDetalle;
    private String importeSaldo;
    private String jFechaAnulacion;
    private String jFechaAutorizacion;
    private String jFechaCaducidad;
    private String jFechaConfirmacion;
    private String jFechaFirma;
    private String jFechaFirmeza;
    private String jResponsableAlta;
    private String jResponsableAutorizacion;
    private String jResponsableConfirmacion;
    private String jResponsableFirma;
    private String jResponsableFirmeza;
    private String jTotalAbono;
    private String jTotalCargo;
    private String jTotalImportePendiente;
    private String jfechare;
    private String jimpnomi;
    private String jnors;
    private String jnuoper;
    private String jtipomod;
    private String moneda;
    private MovementStatusEnum movementStatus;
    private String numerosr;
    private String representado;
    private String representante;
    private String seralfab;
    private String serieYMandamiento;

    public String getjTotalAbono() {
        return this.jTotalAbono;
    }

    public void setjTotalAbono(String jTotalAbono2) {
        this.jTotalAbono = jTotalAbono2;
    }

    public String getjTotalCargo() {
        return this.jTotalCargo;
    }

    public void setjTotalCargo(String jTotalCargo2) {
        this.jTotalCargo = jTotalCargo2;
    }

    public String getjTotalImportePendiente() {
        return this.jTotalImportePendiente;
    }

    public void setjTotalImportePendiente(String jTotalImportePendiente2) {
        this.jTotalImportePendiente = jTotalImportePendiente2;
    }

    public String getjResponsableConfirmacion() {
        return this.jResponsableConfirmacion;
    }

    public void setjResponsableConfirmacion(String jResponsableConfirmacion2) {
        this.jResponsableConfirmacion = jResponsableConfirmacion2;
    }

    public String getjResponsableAutorizacion() {
        return this.jResponsableAutorizacion;
    }

    public void setjResponsableAutorizacion(String jResponsableAutorizacion2) {
        this.jResponsableAutorizacion = jResponsableAutorizacion2;
    }

    public String getjResponsableFirmeza() {
        return this.jResponsableFirmeza;
    }

    public void setjResponsableFirmeza(String jResponsableFirmeza2) {
        this.jResponsableFirmeza = jResponsableFirmeza2;
    }

    public String getjResponsableFirma() {
        return this.jResponsableFirma;
    }

    public void setjResponsableFirma(String jResponsableFirma2) {
        this.jResponsableFirma = jResponsableFirma2;
    }

    public String getjResponsableAlta() {
        return this.jResponsableAlta;
    }

    public void setjResponsableAlta(String jResponsableAlta2) {
        this.jResponsableAlta = jResponsableAlta2;
    }

    public String getJtipomod() {
        return this.jtipomod;
    }

    public void setJtipomod(String jtipomod2) {
        this.jtipomod = jtipomod2;
    }

    public String getjFechaFirma() {
        return this.jFechaFirma;
    }

    public void setjFechaFirma(String jFechaFirma2) {
        this.jFechaFirma = jFechaFirma2;
    }

    public String getjFechaFirmeza() {
        return this.jFechaFirmeza;
    }

    public void setjFechaFirmeza(String jFechaFirmeza2) {
        this.jFechaFirmeza = jFechaFirmeza2;
    }

    public String getjFechaAutorizacion() {
        return this.jFechaAutorizacion;
    }

    public void setjFechaAutorizacion(String jFechaAutorizacion2) {
        this.jFechaAutorizacion = jFechaAutorizacion2;
    }

    public String getjFechaConfirmacion() {
        return this.jFechaConfirmacion;
    }

    public void setjFechaConfirmacion(String jFechaConfirmacion2) {
        this.jFechaConfirmacion = jFechaConfirmacion2;
    }

    public String getjFechaAnulacion() {
        return this.jFechaAnulacion;
    }

    public void setjFechaAnulacion(String jFechaAnulacion2) {
        this.jFechaAnulacion = jFechaAnulacion2;
    }

    public String getjFechaCaducidad() {
        return this.jFechaCaducidad;
    }

    public void setjFechaCaducidad(String jFechaCaducidad2) {
        this.jFechaCaducidad = jFechaCaducidad2;
    }

    public boolean isDetail() {
        return this.detail;
    }

    public void setDetail(boolean detail2) {
        this.detail = detail2;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String codmon2) {
        this.codmon = codmon2;
    }

    public String getDesctipomod() {
        return this.desctipomod;
    }

    public void setDesctipomod(String desctipomod2) {
        this.desctipomod = desctipomod2;
    }

    public String getJfechare() {
        return this.jfechare;
    }

    public void setJfechare(String jfechare2) {
        this.jfechare = jfechare2;
    }

    public String getJimpnomi() {
        return this.jimpnomi;
    }

    public void setJimpnomi(String jimpnomi2) {
        this.jimpnomi = jimpnomi2;
    }

    public String getJnors() {
        return this.jnors;
    }

    public void setJnors(String jnors2) {
        this.jnors = jnors2;
    }

    public String getJnuoper() {
        return this.jnuoper;
    }

    public void setJnuoper(String jnuoper2) {
        this.jnuoper = jnuoper2;
    }

    public String getImporte() {
        return this.importe;
    }

    public void setImporte(String importe2) {
        this.importe = importe2;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda2) {
        this.moneda = moneda2;
    }

    public String getNumerosr() {
        return this.numerosr;
    }

    public void setNumerosr(String numerosr2) {
        this.numerosr = numerosr2;
    }

    public String getSeralfab() {
        return this.seralfab;
    }

    public void setSeralfab(String seralfab2) {
        this.seralfab = seralfab2;
    }

    public String getSerieYMandamiento() {
        return this.serieYMandamiento;
    }

    public void setSerieYMandamiento(String serieYMandamiento2) {
        this.serieYMandamiento = serieYMandamiento2;
    }

    public MovementStatusEnum getMovementStatus() {
        return this.movementStatus;
    }

    public void setMovementStatus(MovementStatusEnum movementStatus2) {
        this.movementStatus = movementStatus2;
    }

    public String getExpedienteDestino() {
        return this.expedienteDestino;
    }

    public void setExpedienteDestino(String expedienteDestino2) {
        this.expedienteDestino = expedienteDestino2;
    }

    public String getImporteSaldo() {
        return this.importeSaldo;
    }

    public void setImporteSaldo(String importeSaldo2) {
        this.importeSaldo = importeSaldo2;
    }

    public String getRepresentado() {
        return this.representado;
    }

    public void setRepresentado(String representado2) {
        this.representado = representado2;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento2) {
        this.documento = documento2;
    }

    public String getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(String representante2) {
        this.representante = representante2;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha2) {
        this.fecha = fecha2;
    }

    public String getConcepto() {
        return this.concepto;
    }

    public void setConcepto(String concepto2) {
        this.concepto = concepto2;
    }

    public String getImporteDetalle() {
        return this.importeDetalle;
    }

    public void setImporteDetalle(String importeDetalle2) {
        this.importeDetalle = importeDetalle2;
    }

    public String toString() {
        return this.desctipomod;
    }

    public boolean isEsLetrado() {
        return this.esLetrado;
    }

    public void setEsLetrado(boolean esLetrado2) {
        this.esLetrado = esLetrado2;
    }
}
