package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LIQUIDACION_FACTOR_Type", propOrder = {"contrato", "codnum10"})
public class LIQUIDACIONFACTORType {
    @XmlElement(name = "COD_NUM_10", required = true)
    protected String codnum10;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODNUM10() {
        return this.codnum10;
    }

    public void setCODNUM10(String str) {
        this.codnum10 = str;
    }
}
