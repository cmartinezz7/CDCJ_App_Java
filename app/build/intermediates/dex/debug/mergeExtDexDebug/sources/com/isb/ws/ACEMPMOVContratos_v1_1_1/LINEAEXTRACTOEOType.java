package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_EXTRACTO_EO_Type", propOrder = {"contrato", "lineadeextracto"})
public class LINEAEXTRACTOEOType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "LINEA_DE_EXTRACTO")
    protected int lineadeextracto;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getLINEADEEXTRACTO() {
        return this.lineadeextracto;
    }

    public void setLINEADEEXTRACTO(int i) {
        this.lineadeextracto = i;
    }
}
