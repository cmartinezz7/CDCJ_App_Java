package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONT_PRESEN_6MAS9MAS3MAS3_Type", propOrder = {"claveclasificacion", "numerocontrato", "surcode", "surcode2"})
public class CONTPRESEN6MAS9MAS3MAS3Type {
    @XmlElement(name = "CLAVE_CLASIFICACION", required = true)
    protected String claveclasificacion;
    @XmlElement(name = "NUMERO_CONTRATO", required = true)
    protected String numerocontrato;
    @XmlElement(name = "SURCODE", required = true)
    protected String surcode;
    @XmlElement(name = "SURCODE_2", required = true)
    protected String surcode2;

    public String getCLAVECLASIFICACION() {
        return this.claveclasificacion;
    }

    public void setCLAVECLASIFICACION(String str) {
        this.claveclasificacion = str;
    }

    public String getNUMEROCONTRATO() {
        return this.numerocontrato;
    }

    public void setNUMEROCONTRATO(String str) {
        this.numerocontrato = str;
    }

    public String getSURCODE() {
        return this.surcode;
    }

    public void setSURCODE(String str) {
        this.surcode = str;
    }

    public String getSURCODE2() {
        return this.surcode2;
    }

    public void setSURCODE2(String str) {
        this.surcode2 = str;
    }
}
