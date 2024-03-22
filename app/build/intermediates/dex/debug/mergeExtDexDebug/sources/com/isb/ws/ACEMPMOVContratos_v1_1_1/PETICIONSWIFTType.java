package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PETICION_SWIFT_Type", propOrder = {"usuario", "fecha", "numerodepeticion"})
public class PETICIONSWIFTType {
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA", required = true)
    protected XMLGregorianCalendar fecha;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_PETICION")
    protected int numerodepeticion;
    @XmlElement(name = "USUARIO", required = true)
    protected String usuario;

    public String getUSUARIO() {
        return this.usuario;
    }

    public void setUSUARIO(String str) {
        this.usuario = str;
    }

    public XMLGregorianCalendar getFECHA() {
        return this.fecha;
    }

    public void setFECHA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecha = xMLGregorianCalendar;
    }

    public int getNUMERODEPETICION() {
        return this.numerodepeticion;
    }

    public void setNUMERODEPETICION(int i) {
        this.numerodepeticion = i;
    }
}
