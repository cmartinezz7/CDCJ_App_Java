package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosJuzgadoPaz", propOrder = {"cdpostp", "codplazc", "codplazp", "codprovp", "descpaz", "descprov", "expjuzpaz", "juzgap", "obsjuzpaz", "telefono"})
public class DatosJuzgadoPaz {
    protected String cdpostp;
    protected String codplazc;
    protected String codplazp;
    protected String codprovp;
    protected String descpaz;
    protected String descprov;
    protected String expjuzpaz;
    protected String juzgap;
    protected String obsjuzpaz;
    protected String telefono;

    public String getCdpostp() {
        return this.cdpostp;
    }

    public void setCdpostp(String str) {
        this.cdpostp = str;
    }

    public String getCodplazc() {
        return this.codplazc;
    }

    public void setCodplazc(String str) {
        this.codplazc = str;
    }

    public String getCodplazp() {
        return this.codplazp;
    }

    public void setCodplazp(String str) {
        this.codplazp = str;
    }

    public String getCodprovp() {
        return this.codprovp;
    }

    public void setCodprovp(String str) {
        this.codprovp = str;
    }

    public String getDescpaz() {
        return this.descpaz;
    }

    public void setDescpaz(String str) {
        this.descpaz = str;
    }

    public String getDescprov() {
        return this.descprov;
    }

    public void setDescprov(String str) {
        this.descprov = str;
    }

    public String getExpjuzpaz() {
        return this.expjuzpaz;
    }

    public void setExpjuzpaz(String str) {
        this.expjuzpaz = str;
    }

    public String getJuzgap() {
        return this.juzgap;
    }

    public void setJuzgap(String str) {
        this.juzgap = str;
    }

    public String getObsjuzpaz() {
        return this.obsjuzpaz;
    }

    public void setObsjuzpaz(String str) {
        this.obsjuzpaz = str;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String str) {
        this.telefono = str;
    }
}
