package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTES_SUJETO_INTERNO_Type", propOrder = {"nivelinterno", "codsujetointerno"})
public class RTESSUJETOINTERNOType {
    @XmlElement(name = "COD_SUJETO_INTERNO", required = true)
    protected String codsujetointerno;
    @XmlElement(name = "NIVEL_INTERNO", required = true)
    protected RTESNIVELSUJINTERNOType nivelinterno;

    public RTESNIVELSUJINTERNOType getNIVELINTERNO() {
        return this.nivelinterno;
    }

    public void setNIVELINTERNO(RTESNIVELSUJINTERNOType rTESNIVELSUJINTERNOType) {
        this.nivelinterno = rTESNIVELSUJINTERNOType;
    }

    public String getCODSUJETOINTERNO() {
        return this.codsujetointerno;
    }

    public void setCODSUJETOINTERNO(String str) {
        this.codsujetointerno = str;
    }
}
