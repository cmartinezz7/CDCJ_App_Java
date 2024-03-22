package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ANTICIPO_FACTOR_Type", propOrder = {"contrato", "codnum7"})
public class ANTICIPOFACTORType {
    @XmlElement(name = "COD_NUM_7", required = true)
    protected String codnum7;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODNUM7() {
        return this.codnum7;
    }

    public void setCODNUM7(String str) {
        this.codnum7 = str;
    }
}
