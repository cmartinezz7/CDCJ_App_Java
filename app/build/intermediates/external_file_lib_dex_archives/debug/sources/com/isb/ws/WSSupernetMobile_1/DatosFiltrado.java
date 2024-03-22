package com.isb.ws.WSSupernetMobile_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosFiltrado", propOrder = {"jfechareDe", "jfechareHasta", "jimpnomiDe", "jimpnomiHasta", "tipsel"})
public class DatosFiltrado {
    protected String jfechareDe;
    protected String jfechareHasta;
    protected BigDecimal jimpnomiDe;
    protected BigDecimal jimpnomiHasta;
    protected Long tipsel;

    public String getJfechareDe() {
        return this.jfechareDe;
    }

    public void setJfechareDe(String str) {
        this.jfechareDe = str;
    }

    public String getJfechareHasta() {
        return this.jfechareHasta;
    }

    public void setJfechareHasta(String str) {
        this.jfechareHasta = str;
    }

    public BigDecimal getJimpnomiDe() {
        return this.jimpnomiDe;
    }

    public void setJimpnomiDe(BigDecimal bigDecimal) {
        this.jimpnomiDe = bigDecimal;
    }

    public BigDecimal getJimpnomiHasta() {
        return this.jimpnomiHasta;
    }

    public void setJimpnomiHasta(BigDecimal bigDecimal) {
        this.jimpnomiHasta = bigDecimal;
    }

    public Long getTipsel() {
        return this.tipsel;
    }

    public void setTipsel(Long l) {
        this.tipsel = l;
    }
}
