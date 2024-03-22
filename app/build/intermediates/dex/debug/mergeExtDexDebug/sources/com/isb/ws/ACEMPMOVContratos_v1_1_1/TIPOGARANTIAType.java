package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_GARANTIA_Type", propOrder = {"empresa", "codigotipogarantia"})
public class TIPOGARANTIAType {
    @XmlElement(name = "CODIGO_TIPO_GARANTIA", required = true)
    protected String codigotipogarantia;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOTIPOGARANTIA() {
        return this.codigotipogarantia;
    }

    public void setCODIGOTIPOGARANTIA(String str) {
        this.codigotipogarantia = str;
    }
}
