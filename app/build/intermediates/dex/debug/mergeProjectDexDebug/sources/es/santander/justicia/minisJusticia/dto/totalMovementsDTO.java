package es.santander.justicia.minisJusticia.dto;

public class totalMovementsDTO {
    private String codmod;
    private String currency;
    private String importCharge;
    private String importPayment;
    private String importPending;

    public String getCodmod() {
        return this.codmod;
    }

    public void setCodmod(String codmod2) {
        this.codmod = codmod2;
    }

    public String getImportPayment() {
        return this.importPayment;
    }

    public void setImportPayment(String importPayment2) {
        this.importPayment = importPayment2;
    }

    public String getImportCharge() {
        return this.importCharge;
    }

    public void setImportCharge(String importCharge2) {
        this.importCharge = importCharge2;
    }

    public String getImportPending() {
        return this.importPending;
    }

    public void setImportPending(String importPending2) {
        this.importPending = importPending2;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency2) {
        this.currency = currency2;
    }
}
