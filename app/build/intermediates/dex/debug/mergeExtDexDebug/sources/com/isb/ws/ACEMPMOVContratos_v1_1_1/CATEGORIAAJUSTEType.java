package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CATEGORIA_AJUSTE_Type", propOrder = {"empresa", "codigoalfanum4", "fecha"})
public class CATEGORIAAJUSTEType {
    @XmlElement(name = "CODIGO_ALFANUM_4", required = true)
    protected String codigoalfanum4;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA", required = true)
    protected XMLGregorianCalendar fecha;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM4() {
        return this.codigoalfanum4;
    }

    public void setCODIGOALFANUM4(String str) {
        this.codigoalfanum4 = str;
    }

    public XMLGregorianCalendar getFECHA() {
        return this.fecha;
    }

    public void setFECHA(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecha = xMLGregorianCalendar;
    }
}
