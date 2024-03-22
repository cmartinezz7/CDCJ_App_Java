package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DENOMINACION_ATRIBUT_CONT_Type", propOrder = {"tipoatributo", "coddenominacionatr"})
public class DENOMINACIONATRIBUTCONTType {
    @XmlElement(name = "COD_DENOMINACION_ATR", required = true)
    protected String coddenominacionatr;
    @XmlElement(name = "TIPO_ATRIBUTO", required = true)
    protected String tipoatributo;

    public String getTIPOATRIBUTO() {
        return this.tipoatributo;
    }

    public void setTIPOATRIBUTO(String str) {
        this.tipoatributo = str;
    }

    public String getCODDENOMINACIONATR() {
        return this.coddenominacionatr;
    }

    public void setCODDENOMINACIONATR(String str) {
        this.coddenominacionatr = str;
    }
}
