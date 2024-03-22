package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_CODCON_Type", propOrder = {"fechaejecucion", "numerodeorden", "numerodeejecucion", "contrato", "tipodeoperacion"})
public class OPERACIONCODCONType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_EJECUCION", required = true)
    protected XMLGregorianCalendar fechaejecucion;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_EJECUCION")
    protected int numerodeejecucion;
    @XmlElement(name = "NUMERO_DE_ORDEN", required = true)
    protected String numerodeorden;
    @XmlElement(name = "TIPO_DE_OPERACION", required = true)
    protected String tipodeoperacion;

    public XMLGregorianCalendar getFECHAEJECUCION() {
        return this.fechaejecucion;
    }

    public void setFECHAEJECUCION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaejecucion = xMLGregorianCalendar;
    }

    public String getNUMERODEORDEN() {
        return this.numerodeorden;
    }

    public void setNUMERODEORDEN(String str) {
        this.numerodeorden = str;
    }

    public int getNUMERODEEJECUCION() {
        return this.numerodeejecucion;
    }

    public void setNUMERODEEJECUCION(int i) {
        this.numerodeejecucion = i;
    }

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getTIPODEOPERACION() {
        return this.tipodeoperacion;
    }

    public void setTIPODEOPERACION(String str) {
        this.tipodeoperacion = str;
    }
}
