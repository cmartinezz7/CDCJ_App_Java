package es.santander.justicia.minisJusticia.common.dto;

import java.io.Serializable;

public class SaldoExpedientDTO implements Serializable {
    private String codmon;
    private String impSaldo;
    private String moneda;

    public SaldoExpedientDTO(String impSaldo2, String codmon2, String moneda2) {
        this.impSaldo = impSaldo2;
        this.codmon = codmon2;
        this.moneda = moneda2;
    }

    public String getCodmon() {
        return this.codmon;
    }

    public String getImpSaldo() {
        return this.impSaldo;
    }

    public String getMoneda() {
        return this.moneda;
    }
}
