package es.santander.justicia.minisJusticia.dto;

public class ExpedientDetailDTO {
   private String typMoney;
   private String BalanceDay;
   private String entryPendingConsolidate;
   private String paymentsPendingConsolidate;
   private String paymentsPendingConfirm;
   private String paymentsConsolidate;
   private String paymentsAvailable;
   private String situacion;
   private String paymentsEntryWrong;

   public ExpedientDetailDTO(String typMoney, String balanceDay, String entryPendingConsolidate, String paymentsPendingConsolidate, String paymentsPendingConfirm, String paymentsConsolidate, String paymentsAvailable, String paymentsEntryWrong) {
      this.typMoney = typMoney;
      this.BalanceDay = balanceDay;
      this.entryPendingConsolidate = entryPendingConsolidate;
      this.paymentsPendingConsolidate = paymentsPendingConsolidate;
      this.paymentsPendingConfirm = paymentsPendingConfirm;
      this.paymentsConsolidate = paymentsConsolidate;
      this.paymentsAvailable = paymentsAvailable;
      this.paymentsEntryWrong = paymentsEntryWrong;
   }

   public String getTypMoney() {
      return this.typMoney;
   }

   public void setTypMoney(String typMoney) {
      this.typMoney = typMoney;
   }

   public String getPaymentsEntryWrong() {
      return this.paymentsEntryWrong;
   }

   public void setPaymentsEntryWrong(String paymentsEntryWrong) {
      this.paymentsEntryWrong = paymentsEntryWrong;
   }

   public String getPaymentsAvailable() {
      return this.paymentsAvailable;
   }

   public void setPaymentsAvailable(String paymentsAvailable) {
      this.paymentsAvailable = paymentsAvailable;
   }

   public String getPaymentsConsolidate() {
      return this.paymentsConsolidate;
   }

   public void setPaymentsConsolidate(String paymentsConsolidate) {
      this.paymentsConsolidate = paymentsConsolidate;
   }

   public String getPaymentsPendingConfirm() {
      return this.paymentsPendingConfirm;
   }

   public void setPaymentsPendingConfirm(String paymentsPendingConfirm) {
      this.paymentsPendingConfirm = paymentsPendingConfirm;
   }

   public String getPaymentsPendingConsolidate() {
      return this.paymentsPendingConsolidate;
   }

   public void setPaymentsPendingConsolidate(String paymentsPendingConsolidate) {
      this.paymentsPendingConsolidate = paymentsPendingConsolidate;
   }

   public String getEntryPendingConsolidate() {
      return this.entryPendingConsolidate;
   }

   public void setEntryPendingConsolidate(String entryPendingConsolidate) {
      this.entryPendingConsolidate = entryPendingConsolidate;
   }

   public String getBalanceDay() {
      return this.BalanceDay;
   }

   public void setBalanceDay(String balanceDay) {
      this.BalanceDay = balanceDay;
   }
}
