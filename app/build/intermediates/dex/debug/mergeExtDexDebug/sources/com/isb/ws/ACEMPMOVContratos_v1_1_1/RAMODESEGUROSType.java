package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RAMO_DE_SEGUROS_Type", propOrder = {"codcompaniaseg", "codramo"})
public class RAMODESEGUROSType {
    @XmlElement(name = "COD_COMPANIA_SEG", required = true)
    protected String codcompaniaseg;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_RAMO")
    protected int codramo;

    public String getCODCOMPANIASEG() {
        return this.codcompaniaseg;
    }

    public void setCODCOMPANIASEG(String str) {
        this.codcompaniaseg = str;
    }

    public int getCODRAMO() {
        return this.codramo;
    }

    public void setCODRAMO(int i) {
        this.codramo = i;
    }
}
