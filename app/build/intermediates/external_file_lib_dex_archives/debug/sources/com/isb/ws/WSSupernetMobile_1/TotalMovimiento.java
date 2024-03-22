package com.isb.ws.WSSupernetMobile_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "totalMovimiento", propOrder = {"codmon", "jimpabono", "jimpcargo", "jimppend", "moneda"})
public class TotalMovimiento {
    protected String codmon;
    protected BigDecimal jimpabono;
    protected BigDecimal jimpcargo;
    protected BigDecimal jimppend;
    protected String moneda;

    public String getCodmon() {
        return this.codmon;
    }

    public void setCodmon(String str) {
        this.codmon = str;
    }

    public BigDecimal getJimpabono() {
        return this.jimpabono;
    }

    public void setJimpabono(BigDecimal bigDecimal) {
        this.jimpabono = bigDecimal;
    }

    public BigDecimal getJimpcargo() {
        return this.jimpcargo;
    }

    public void setJimpcargo(BigDecimal bigDecimal) {
        this.jimpcargo = bigDecimal;
    }

    public BigDecimal getJimppend() {
        return this.jimppend;
    }

    public void setJimppend(BigDecimal bigDecimal) {
        this.jimppend = bigDecimal;
    }

    public String getMoneda() {
        return this.moneda;
    }

    public void setMoneda(String str) {
        this.moneda = str;
    }
}
