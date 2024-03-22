package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MARCA_TARJETA_Type", propOrder = {"empresa", "codmarcatarjeta"})
public class MARCATARJETAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_MARCA_TARJETA")
    protected int codmarcatarjeta;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODMARCATARJETA() {
        return this.codmarcatarjeta;
    }

    public void setCODMARCATARJETA(int i) {
        this.codmarcatarjeta = i;
    }
}
