package es.santander.justicia.minisJusticia.dto;

import java.io.Serializable;

public class ListaMovimientosDTO implements Serializable {
   private String status;
   private String tipoMovimiento;
   private String mandamientoPago;
   private String fecha;
   private String importe;

   public String getStatus() {
      return this.status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getTipoMovimiento() {
      return this.tipoMovimiento;
   }

   public void setTipoMovimiento(String tipoMovimiento) {
      this.tipoMovimiento = tipoMovimiento;
   }

   public String getMandamientoPago() {
      return this.mandamientoPago;
   }

   public void setMandamientoPago(String mandamientoPago) {
      this.mandamientoPago = mandamientoPago;
   }

   public String getFecha() {
      return this.fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public String getImporte() {
      return this.importe;
   }

   public void setImporte(String importe) {
      this.importe = importe;
   }

   public ListaMovimientosDTO(String status, String tipoMovimiento, String mandamientoPago, String fecha, String importe) {
      this.status = status;
      this.tipoMovimiento = tipoMovimiento;
      this.mandamientoPago = mandamientoPago;
      this.fecha = fecha;
      this.importe = importe;
   }
}
