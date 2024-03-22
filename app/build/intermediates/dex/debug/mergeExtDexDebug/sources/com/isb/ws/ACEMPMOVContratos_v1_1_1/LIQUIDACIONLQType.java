package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LIQUIDACION_LQ_Type", propOrder = {"empresa", "fecvalor", "fecenvio", "refpago"})
public class LIQUIDACIONLQType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FEC_ENVIO", required = true)
    protected XMLGregorianCalendar fecenvio;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FEC_VALOR", required = true)
    protected XMLGregorianCalendar fecvalor;
    @XmlElement(name = "REF_PAGO", required = true)
    protected String refpago;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public XMLGregorianCalendar getFECVALOR() {
        return this.fecvalor;
    }

    public void setFECVALOR(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecvalor = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getFECENVIO() {
        return this.fecenvio;
    }

    public void setFECENVIO(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fecenvio = xMLGregorianCalendar;
    }

    public String getREFPAGO() {
        return this.refpago;
    }

    public void setREFPAGO(String str) {
        this.refpago = str;
    }
}
