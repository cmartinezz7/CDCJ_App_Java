package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_AAFF_Type", propOrder = {"centro", "fecha", "numoperacion"})
public class CONTRATOAAFFType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTRODECONTRATOType centro;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA", required = true)
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_OPERACION")
    protected int numoperacion;

    public CENTRODECONTRATOType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centro = cENTRODECONTRATOType;
    }

    public XMLGregorianCalendar getFECHA() {
        return this.fecha;
    }

    public void setFECHA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecha = xMLGregorianCalendar;
    }

    public int getNUMOPERACION() {
        return this.numoperacion;
    }

    public void setNUMOPERACION(int i) {
        this.numoperacion = i;
    }
}
