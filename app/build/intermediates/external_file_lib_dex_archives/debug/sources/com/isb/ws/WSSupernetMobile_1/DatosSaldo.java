package com.isb.ws.WSSupernetMobile_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosSaldo", propOrder = {"codmon", "impsaldo", "ingpendconso", "jimpnomi", "jtipomod", "moneda", "pagopendconf", "pagopendconso", "saldoconso", "saldodia", "saldodisp", "saldoingdeposito", "saldoingerroneo"})
public class DatosSaldo {
    protected String codmon;
    protected BigDecimal impsaldo;
    protected BigDecimal ingpendconso;
    protected BigDecimal jimpnomi;
    protected String jtipomod;
    protected String moneda;
    protected BigDecimal pagopendconf;
    protected BigDecimal pagopendconso;
    protected BigDecimal saldoconso;
    protected BigDecimal saldodia;
    protected BigDecimal saldodisp;
    protected BigDecimal saldoingdeposito;
    protected BigDecimal saldoingerroneo;

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String str) {
        this.codmon = str;
    }

    public BigDecimal getImpsaldo() {
        return this.impsaldo;
    }

    public void setImpsaldo(BigDecimal bigDecimal) {
        this.impsaldo = bigDecimal;
    }

    public BigDecimal getIngpendconso() {
        return this.ingpendconso;
    }

    public void setIngpendconso(BigDecimal bigDecimal) {
        this.ingpendconso = bigDecimal;
    }

    public BigDecimal getJimpnomi() {
        return this.jimpnomi;
    }

    public void setJimpnomi(BigDecimal bigDecimal) {
        this.jimpnomi = bigDecimal;
    }

    public String getJtipomod() {
        return this.jtipomod;
    }

    public void setJtipomod(String str) {
        this.jtipomod = str;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String str) {
        this.moneda = str;
    }

    public BigDecimal getPagopendconf() {
        return this.pagopendconf;
    }

    public void setPagopendconf(BigDecimal bigDecimal) {
        this.pagopendconf = bigDecimal;
    }

    public BigDecimal getPagopendconso() {
        return this.pagopendconso;
    }

    public void setPagopendconso(BigDecimal bigDecimal) {
        this.pagopendconso = bigDecimal;
    }

    public BigDecimal getSaldoconso() {
        return this.saldoconso;
    }

    public void setSaldoconso(BigDecimal bigDecimal) {
        this.saldoconso = bigDecimal;
    }

    public BigDecimal getSaldodia() {
        return this.saldodia;
    }

    public void setSaldodia(BigDecimal bigDecimal) {
        this.saldodia = bigDecimal;
    }

    public BigDecimal getSaldodisp() {
        return this.saldodisp;
    }

    public void setSaldodisp(BigDecimal bigDecimal) {
        this.saldodisp = bigDecimal;
    }

    public BigDecimal getSaldoingdeposito() {
        return this.saldoingdeposito;
    }

    public void setSaldoingdeposito(BigDecimal bigDecimal) {
        this.saldoingdeposito = bigDecimal;
    }

    public BigDecimal getSaldoingerroneo() {
        return this.saldoingerroneo;
    }

    public void setSaldoingerroneo(BigDecimal bigDecimal) {
        this.saldoingerroneo = bigDecimal;
    }
}
