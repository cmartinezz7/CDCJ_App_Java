package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_OBB_Type", propOrder = {"subtipodeproducto", "operacionbancaria", "version"})
public class MOBOBBType {
    @XmlElement(name = "OPERACION_BANCARIA", required = true)
    protected OPERACIONBANCARIAType operacionbancaria;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "VERSION")
    protected int version;

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

    public int getVERSION() {
        return this.version;
    }

    public void setVERSION(int i) {
        this.version = i;
    }
}
