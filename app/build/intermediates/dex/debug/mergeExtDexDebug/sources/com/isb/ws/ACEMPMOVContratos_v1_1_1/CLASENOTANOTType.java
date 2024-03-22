package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLASE_NOTA_NOT_Type", propOrder = {"empresa", "codclant"})
public class CLASENOTANOTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODCLANT")
    protected int codclant;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODCLANT() {
        return this.codclant;
    }

    public void setCODCLANT(int i) {
        this.codclant = i;
    }
}
