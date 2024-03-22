package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_PRODUCTO_Type", propOrder = {"subtipodeproducto", "operacionbancaria", "fechadeoperacion"})
public class OPERACIONPRODUCTOType {
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_DE_OPERACION", required = true)
    protected XMLGregorianCalendar fechadeoperacion;
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

    public XMLGregorianCalendar getFECHADEOPERACION() {
        return this.fechadeoperacion;
    }

    public void setFECHADEOPERACION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechadeoperacion = xMLGregorianCalendar;
    }
}
