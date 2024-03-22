package es.santander.justicia.minisJusticia.dto;

import java.io.Serializable;

public class SaldoDTO implements Serializable {
    private String codmon;
    private String ingpendconso;
    private String moneda;
    private String pagopendconf;
    private String pagopendconso;
    private String principal;
    private String saldoconso;
    private String saldodia;
    private String saldodisp;
    private String saldoingdeposito;
    private String saldoingerroneo;

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String codmon2) {
        this.codmon = codmon2;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String moneda2) {
        this.moneda = moneda2;
    }

    public String getIngpendconso() {
        return this.ingpendconso;
    }

    public void setIngpendconso(String ingpendconso2) {
        this.ingpendconso = ingpendconso2;
    }

    public String getPagopendconf() {
        return this.pagopendconf;
    }

    public void setPagopendconf(String pagopendconf2) {
        this.pagopendconf = pagopendconf2;
    }

    public String getPagopendconso() {
        return this.pagopendconso;
    }

    public void setPagopendconso(String pagopendconso2) {
        this.pagopendconso = pagopendconso2;
    }

    public String getSaldoconso() {
        return this.saldoconso;
    }

    public void setSaldoconso(String saldoconso2) {
        this.saldoconso = saldoconso2;
    }

    public String getSaldodia() {
        return this.saldodia;
    }

    public void setSaldodia(String saldodia2) {
        this.saldodia = saldodia2;
    }

    public String getSaldodisp() {
        return this.saldodisp;
    }

    public void setSaldodisp(String saldodisp2) {
        this.saldodisp = saldodisp2;
    }

    public String getSaldoingdeposito() {
        return this.saldoingdeposito;
    }

    public void setSaldoingdeposito(String saldoingdeposito2) {
        this.saldoingdeposito = saldoingdeposito2;
    }

    public String getSaldoingerroneo() {
        return this.saldoingerroneo;
    }

    public void setSaldoingerroneo(String saldoingerroneo2) {
        this.saldoingerroneo = saldoingerroneo2;
    }

    public String getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(String principal2) {
        this.principal = principal2;
    }
}
