package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_MENSAJE_AHGECO_Type", propOrder = {"logtypeahgeco", "globalid", "created"})
public class IDMENSAJEAHGECOType {
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "CREATED", required = true)
    protected XMLGregorianCalendar created;
    @XmlElement(name = "GLOBAL_ID", required = true)
    protected String globalid;
    @XmlElement(name = "LOG_TYPE_AHGECO", required = true)
    protected String logtypeahgeco;

    public String getLOGTYPEAHGECO() {
        return this.logtypeahgeco;
    }

    public void setLOGTYPEAHGECO(String str) {
        this.logtypeahgeco = str;
    }

    public String getGLOBALID() {
        return this.globalid;
    }

    public void setGLOBALID(String str) {
        this.globalid = str;
    }

    public XMLGregorianCalendar getCREATED() {
        return this.created;
    }

    public void setCREATED(XMLGregorianCalendar xMLGregorianCalendar) {
        this.created = xMLGregorianCalendar;
    }
}
