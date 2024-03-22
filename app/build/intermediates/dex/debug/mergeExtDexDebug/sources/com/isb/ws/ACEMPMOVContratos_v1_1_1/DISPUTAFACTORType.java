package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DISPUTA_FACTOR_Type", propOrder = {"contrato", "coddisputafactor"})
public class DISPUTAFACTORType {
    @XmlElement(name = "COD_DISPUTA_FACTOR", required = true)
    protected String coddisputafactor;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODDISPUTAFACTOR() {
        return this.coddisputafactor;
    }

    public void setCODDISPUTAFACTOR(String str) {
        this.coddisputafactor = str;
    }
}
