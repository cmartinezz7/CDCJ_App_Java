package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INTERFASE_OTT_Type", propOrder = {"empresa", "tipinterott", "secinterfase"})
public class INTERFASEOTTType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_INTERFASE")
    protected int secinterfase;
    @XmlElement(name = "TIP_INTER_OTT", required = true)
    protected String tipinterott;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPINTEROTT() {
        return this.tipinterott;
    }

    public void setTIPINTEROTT(String str) {
        this.tipinterott = str;
    }

    public int getSECINTERFASE() {
        return this.secinterfase;
    }

    public void setSECINTERFASE(int i) {
        this.secinterfase = i;
    }
}
