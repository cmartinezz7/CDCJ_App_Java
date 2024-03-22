package es.santander.justicia.minisJusticia.dto;

import java.io.Serializable;

public class ListaMovimientosDTO implements Serializable {
    private String fecha;
    private String importe;
    private String mandamientoPago;
    private String status;
    private String tipoMovimiento;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento2) {
        this.tipoMovimiento = tipoMovimiento2;
    }

    public String getMandamientoPago() {
        return this.mandamientoPago;
    }

    public void setMandamientoPago(String mandamientoPago2) {
        this.mandamientoPago = mandamientoPago2;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha2) {
        this.fecha = fecha2;
    }

    public String getImporte() {
        return this.importe;
    }

    public void setImporte(String importe2) {
        this.importe = importe2;
    }

    public ListaMovimientosDTO(String status2, String tipoMovimiento2, String mandamientoPago2, String fecha2, String importe2) {
        this.status = status2;
        this.tipoMovimiento = tipoMovimiento2;
        this.mandamientoPago = mandamientoPago2;
        this.fecha = fecha2;
        this.importe = importe2;
    }
}
