package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSESION_GRH_Type", propOrder = {"csesion", "timestamp"})
public class CSESIONGRHType {
    @XmlElement(name = "CSESION", required = true)
    protected String csesion;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP", required = true)
    protected XMLGregorianCalendar timestamp;

    public String getCSESION() {
        return this.csesion;
    }

    public void setCSESION(String str) {
        this.csesion = str;
    }

    public XMLGregorianCalendar getTIMESTAMP() {
        return this.timestamp;
    }

    public void setTIMESTAMP(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestamp = xMLGregorianCalendar;
    }
}
