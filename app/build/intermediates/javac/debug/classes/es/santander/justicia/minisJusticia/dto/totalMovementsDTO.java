package es.santander.justicia.minisJusticia.dto;

public class totalMovementsDTO {
   private String codmod;
   private String importPayment;
   private String importCharge;
   private String importPending;
   private String currency;

   public String getCodmod() {
      return this.codmod;
   }

   public void setCodmod(String codmod) {
      this.codmod = codmod;
   }

   public String getImportPayment() {
      return this.importPayment;
   }

   public void setImportPayment(String importPayment) {
      this.importPayment = importPayment;
   }

   public String getImportCharge() {
      return this.importCharge;
   }

   public void setImportCharge(String importCharge) {
      this.importCharge = importCharge;
   }

   public String getImportPending() {
      return this.importPending;
   }

   public void setImportPending(String importPending) {
      this.importPending = importPending;
   }

   public String getCurrency() {
      return this.currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }
}
