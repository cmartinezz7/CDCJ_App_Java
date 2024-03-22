package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APLICACION_SWIFT_Type", propOrder = {"empresa", "sistemagstp", "codaplicacion"})
public class APLICACIONSWIFTType {
    @XmlElement(name = "COD_APLICACION", required = true)
    protected String codaplicacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "SISTEMA_GSTP", required = true)
    protected String sistemagstp;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSISTEMAGSTP() {
        return this.sistemagstp;
    }

    public void setSISTEMAGSTP(String str) {
        this.sistemagstp = str;
    }

    public String getCODAPLICACION() {
        return this.codaplicacion;
    }

    public void setCODAPLICACION(String str) {
        this.codaplicacion = str;
    }
}
