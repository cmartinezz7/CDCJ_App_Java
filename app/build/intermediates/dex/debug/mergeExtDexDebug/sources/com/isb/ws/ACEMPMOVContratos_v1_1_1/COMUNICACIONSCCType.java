package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMUNICACION_SCC_Type", propOrder = {"empresa", "codcomunicacion", "codseccomunicacion"})
public class COMUNICACIONSCCType {
    @XmlElement(name = "COD_COMUNICACION", required = true)
    protected String codcomunicacion;
    @XmlElement(name = "COD_SEC_COMUNICACION", required = true)
    protected String codseccomunicacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODCOMUNICACION() {
        return this.codcomunicacion;
    }

    public void setCODCOMUNICACION(String str) {
        this.codcomunicacion = str;
    }

    public String getCODSECCOMUNICACION() {
        return this.codseccomunicacion;
    }

    public void setCODSECCOMUNICACION(String str) {
        this.codseccomunicacion = str;
    }
}
