package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_EXTRACTO_PCAS_Type", propOrder = {"contrato", "numextracto", "moneda"})
public class NUMEXTRACTOPCASType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlElement(name = "MONEDA", required = true)
    protected String moneda;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_EXTRACTO")
    protected int numextracto;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getNUMEXTRACTO() {
        return this.numextracto;
    }

    public void setNUMEXTRACTO(int i) {
        this.numextracto = i;
    }

    public String getMONEDA() {
        return this.moneda;
    }

    public void setMONEDA(String str) {
        this.moneda = str;
    }
}
