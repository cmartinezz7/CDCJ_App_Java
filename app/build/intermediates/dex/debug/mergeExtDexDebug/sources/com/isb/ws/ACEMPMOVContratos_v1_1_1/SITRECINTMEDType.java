package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIT_REC_INTMED_Type", propOrder = {"recibointmed", "estadositrecintmed", "timestampsituacrecibo"})
public class SITRECINTMEDType {
    @XmlElement(name = "ESTADO_SIT_REC_INTMED", required = true)
    protected String estadositrecintmed;
    @XmlElement(name = "RECIBO_INTMED", required = true)
    protected String recibointmed;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP_SITUAC_RECIBO", required = true)
    protected XMLGregorianCalendar timestampsituacrecibo;

    public String getRECIBOINTMED() {
        return this.recibointmed;
    }

    public void setRECIBOINTMED(String str) {
        this.recibointmed = str;
    }

    public String getESTADOSITRECINTMED() {
        return this.estadositrecintmed;
    }

    public void setESTADOSITRECINTMED(String str) {
        this.estadositrecintmed = str;
    }

    public XMLGregorianCalendar getTIMESTAMPSITUACRECIBO() {
        return this.timestampsituacrecibo;
    }

    public void setTIMESTAMPSITUACRECIBO(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestampsituacrecibo = xMLGregorianCalendar;
    }
}
