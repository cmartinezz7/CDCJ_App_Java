package es.santander.justicia.minisJusticia.dto;

public class ExpedientDetailDTO {
    private String BalanceDay;
    private String entryPendingConsolidate;
    private String paymentsAvailable;
    private String paymentsConsolidate;
    private String paymentsEntryWrong;
    private String paymentsPendingConfirm;
    private String paymentsPendingConsolidate;
    private String situacion;
    private String typMoney;

    public ExpedientDetailDTO(String typMoney2, String balanceDay, String entryPendingConsolidate2, String paymentsPendingConsolidate2, String paymentsPendingConfirm2, String paymentsConsolidate2, String paymentsAvailable2, String paymentsEntryWrong2) {
        this.typMoney = typMoney2;
        this.BalanceDay = balanceDay;
        this.entryPendingConsolidate = entryPendingConsolidate2;
        this.paymentsPendingConsolidate = paymentsPendingConsolidate2;
        this.paymentsPendingConfirm = paymentsPendingConfirm2;
        this.paymentsConsolidate = paymentsConsolidate2;
        this.paymentsAvailable = paymentsAvailable2;
        this.paymentsEntryWrong = paymentsEntryWrong2;
    }

    public String getTypMoney() {
        return this.typMoney;
    }

    public void setTypMoney(String typMoney2) {
        this.typMoney = typMoney2;
    }

    public String getPaymentsEntryWrong() {
        return this.paymentsEntryWrong;
    }

    public void setPaymentsEntryWrong(String paymentsEntryWrong2) {
        this.paymentsEntryWrong = paymentsEntryWrong2;
    }

    public String getPaymentsAvailable() {
        return this.paymentsAvailable;
    }

    public void setPaymentsAvailable(String paymentsAvailable2) {
        this.paymentsAvailable = paymentsAvailable2;
    }

    public String getPaymentsConsolidate() {
        return this.paymentsConsolidate;
    }

    public void setPaymentsConsolidate(String paymentsConsolidate2) {
        this.paymentsConsolidate = paymentsConsolidate2;
    }

    public String getPaymentsPendingConfirm() {
        return this.paymentsPendingConfirm;
    }

    public void setPaymentsPendingConfirm(String paymentsPendingConfirm2) {
        this.paymentsPendingConfirm = paymentsPendingConfirm2;
    }

    public String getPaymentsPendingConsolidate() {
        return this.paymentsPendingConsolidate;
    }

    public void setPaymentsPendingConsolidate(String paymentsPendingConsolidate2) {
        this.paymentsPendingConsolidate = paymentsPendingConsolidate2;
    }

    public String getEntryPendingConsolidate() {
        return this.entryPendingConsolidate;
    }

    public void setEntryPendingConsolidate(String entryPendingConsolidate2) {
        this.entryPendingConsolidate = entryPendingConsolidate2;
    }

    public String getBalanceDay() {
        return this.BalanceDay;
    }

    public void setBalanceDay(String balanceDay) {
        this.BalanceDay = balanceDay;
    }
}
