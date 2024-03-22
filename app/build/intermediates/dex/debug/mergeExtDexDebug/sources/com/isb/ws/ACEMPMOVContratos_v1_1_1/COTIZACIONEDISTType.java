package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COTIZACION_EDIST_Type", propOrder = {"empresa", "codnum9"})
public class COTIZACIONEDISTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_NUM9")
    protected int codnum9;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODNUM9() {
        return this.codnum9;
    }

    public void setCODNUM9(int i) {
        this.codnum9 = i;
    }
}
