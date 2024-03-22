package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosAdicionales", propOrder = {"indaccio", "indactu", "indtras", "jasiento", "jestoper", "jsubasta", "sitexpf", "sitexpi"})
public class DatosAdicionales {
    protected String indaccio;
    protected String indactu;
    protected String indtras;
    protected String jasiento;
    protected String jestoper;
    protected Integer jsubasta;
    protected String sitexpf;
    protected String sitexpi;

    public String getIndaccio() {
        return this.indaccio;
    }

    public void setIndaccio(String str) {
        this.indaccio = str;
    }

    public String getIndactu() {
        return this.indactu;
    }

    public void setIndactu(String str) {
        this.indactu = str;
    }

    public String getIndtras() {
        return this.indtras;
    }

    public void setIndtras(String str) {
        this.indtras = str;
    }

    public String getJasiento() {
        return this.jasiento;
    }

    public void setJasiento(String str) {
        this.jasiento = str;
    }

    public String getJestoper() {
        return this.jestoper;
    }

    public void setJestoper(String str) {
        this.jestoper = str;
    }

    public Integer getJsubasta() {
        return this.jsubasta;
    }

    public void setJsubasta(Integer num) {
        this.jsubasta = num;
    }

    public String getSitexpf() {
        return this.sitexpf;
    }

    public void setSitexpf(String str) {
        this.sitexpf = str;
    }

    public String getSitexpi() {
        return this.sitexpi;
    }

    public void setSitexpi(String str) {
        this.sitexpi = str;
    }
}
