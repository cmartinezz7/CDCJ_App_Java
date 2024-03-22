package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_ATRIBUTO_CONTABLE_Type", propOrder = {"denominacionatributcont", "codvaloratrib"})
public class VALORATRIBUTOCONTABLEType {
    @XmlElement(name = "COD_VALOR_ATRIB", required = true)
    protected String codvaloratrib;
    @XmlElement(name = "DENOMINACION_ATRIBUT_CONT", required = true)
    protected DENOMINACIONATRIBUTCONTType denominacionatributcont;

    public DENOMINACIONATRIBUTCONTType getDENOMINACIONATRIBUTCONT() {
        return this.denominacionatributcont;
    }

    public void setDENOMINACIONATRIBUTCONT(DENOMINACIONATRIBUTCONTType dENOMINACIONATRIBUTCONTType) {
        this.denominacionatributcont = dENOMINACIONATRIBUTCONTType;
    }

    public String getCODVALORATRIB() {
        return this.codvaloratrib;
    }

    public void setCODVALORATRIB(String str) {
        this.codvaloratrib = str;
    }
}
