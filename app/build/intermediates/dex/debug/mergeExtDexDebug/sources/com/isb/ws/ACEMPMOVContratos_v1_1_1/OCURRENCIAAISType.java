package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OCURRENCIA_AIS_Type", propOrder = {"empresa", "fechaocurrencia", "secocurrencia"})
public class OCURRENCIAAISType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_OCURRENCIA", required = true)
    protected XMLGregorianCalendar fechaocurrencia;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_OCURRENCIA")
    protected int secocurrencia;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public XMLGregorianCalendar getFECHAOCURRENCIA() {
        return this.fechaocurrencia;
    }

    public void setFECHAOCURRENCIA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaocurrencia = xMLGregorianCalendar;
    }

    public int getSECOCURRENCIA() {
        return this.secocurrencia;
    }

    public void setSECOCURRENCIA(int i) {
        this.secocurrencia = i;
    }
}
