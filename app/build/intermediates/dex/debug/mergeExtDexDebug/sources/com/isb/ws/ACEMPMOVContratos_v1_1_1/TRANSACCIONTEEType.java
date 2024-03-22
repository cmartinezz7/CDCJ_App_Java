package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRANSACCION_TEE_Type", propOrder = {"empresa", "fechadeclaracion", "secuenciaoperacion"})
public class TRANSACCIONTEEType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_DECLARACION", required = true)
    protected XMLGregorianCalendar fechadeclaracion;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIA_OPERACION")
    protected int secuenciaoperacion;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public XMLGregorianCalendar getFECHADECLARACION() {
        return this.fechadeclaracion;
    }

    public void setFECHADECLARACION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechadeclaracion = xMLGregorianCalendar;
    }

    public int getSECUENCIAOPERACION() {
        return this.secuenciaoperacion;
    }

    public void setSECUENCIAOPERACION(int i) {
        this.secuenciaoperacion = i;
    }
}
