package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOC_COBRO_FACTOR_Type", propOrder = {"empresa", "codnum10"})
public class DOCCOBROFACTORType {
    @XmlElement(name = "COD_NUM_10", required = true)
    protected String codnum10;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODNUM10() {
        return this.codnum10;
    }

    public void setCODNUM10(String str) {
        this.codnum10 = str;
    }
}
