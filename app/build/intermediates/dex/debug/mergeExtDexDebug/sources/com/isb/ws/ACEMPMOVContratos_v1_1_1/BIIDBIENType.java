package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_ID_BIEN_Type", propOrder = {"empresa", "bitipobien", "numerobien"})
public class BIIDBIENType {
    @XmlElement(name = "BI_TIPO_BIEN", required = true)
    protected String bitipobien;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_BIEN")
    protected int numerobien;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getBITIPOBIEN() {
        return this.bitipobien;
    }

    public void setBITIPOBIEN(String str) {
        this.bitipobien = str;
    }

    public int getNUMEROBIEN() {
        return this.numerobien;
    }

    public void setNUMEROBIEN(int i) {
        this.numerobien = i;
    }
}
