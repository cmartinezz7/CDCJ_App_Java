package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBCONTRATO_Type", propOrder = {"contrato", "subcontrato"})
public class SUBCONTRATOType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlElement(name = "SUBCONTRATO", required = true)
    protected String subcontrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getSUBCONTRATO() {
        return this.subcontrato;
    }

    public void setSUBCONTRATO(String str) {
        this.subcontrato = str;
    }
}
