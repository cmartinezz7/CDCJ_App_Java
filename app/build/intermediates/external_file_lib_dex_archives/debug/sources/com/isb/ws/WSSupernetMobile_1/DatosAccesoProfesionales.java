package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosAccesoProfesionales", propOrder = {"datosExpediente", "fecacept", "fecbjsol", "fecpetic", "jcoment", "jestactu", "jestactuDesc", "jestpeti", "jestpetiDesc", "motsolic", "motsolicDesc"})
public class DatosAccesoProfesionales {
    protected DatosExpediente datosExpediente;
    protected String fecacept;
    protected String fecbjsol;
    protected String fecpetic;
    protected String jcoment;
    protected String jestactu;
    protected String jestactuDesc;
    protected String jestpeti;
    protected String jestpetiDesc;
    protected String motsolic;
    protected String motsolicDesc;

    public DatosExpediente getDatosExpediente() {
        return this.datosExpediente;
    }

    public void setDatosExpediente(DatosExpediente datosExpediente2) {
        this.datosExpediente = datosExpediente2;
    }

    public String getFecacept() {
        return this.fecacept;
    }

    public void setFecacept(String str) {
        this.fecacept = str;
    }

    public String getFecbjsol() {
        return this.fecbjsol;
    }

    public void setFecbjsol(String str) {
        this.fecbjsol = str;
    }

    public String getFecpetic() {
        return this.fecpetic;
    }

    public void setFecpetic(String str) {
        this.fecpetic = str;
    }

    public String getJcoment() {
        return this.jcoment;
    }

    public void setJcoment(String str) {
        this.jcoment = str;
    }

    public String getJestactu() {
        return this.jestactu;
    }

    public void setJestactu(String str) {
        this.jestactu = str;
    }

    public String getJestactuDesc() {
        return this.jestactuDesc;
    }

    public void setJestactuDesc(String str) {
        this.jestactuDesc = str;
    }

    public String getJestpeti() {
        return this.jestpeti;
    }

    public void setJestpeti(String str) {
        this.jestpeti = str;
    }

    public String getJestpetiDesc() {
        return this.jestpetiDesc;
    }

    public void setJestpetiDesc(String str) {
        this.jestpetiDesc = str;
    }

    public String getMotsolic() {
        return this.motsolic;
    }

    public void setMotsolic(String str) {
        this.motsolic = str;
    }

    public String getMotsolicDesc() {
        return this.motsolicDesc;
    }

    public void setMotsolicDesc(String str) {
        this.motsolicDesc = str;
    }
}
