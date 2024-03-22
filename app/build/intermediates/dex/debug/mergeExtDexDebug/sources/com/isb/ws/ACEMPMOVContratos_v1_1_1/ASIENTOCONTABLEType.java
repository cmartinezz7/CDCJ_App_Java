package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASIENTO_CONTABLE_Type", propOrder = {"subtipodeproducto", "operacionbancaria", "asiento"})
public class ASIENTOCONTABLEType {
    @XmlElement(name = "ASIENTO", required = true)
    protected String asiento;
    @XmlElement(name = "OPERACION_BANCARIA", required = true)
    protected OPERACIONBANCARIAType operacionbancaria;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public OPERACIONBANCARIAType getOPERACIONBANCARIA() {
        return this.operacionbancaria;
    }

    public void setOPERACIONBANCARIA(OPERACIONBANCARIAType oPERACIONBANCARIAType) {
        this.operacionbancaria = oPERACIONBANCARIAType;
    }

    public String getASIENTO() {
        return this.asiento;
    }

    public void setASIENTO(String str) {
        this.asiento = str;
    }
}
