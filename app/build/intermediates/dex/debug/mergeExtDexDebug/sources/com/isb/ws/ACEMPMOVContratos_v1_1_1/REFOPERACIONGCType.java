package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REF_OPERACION_GC_Type", propOrder = {"ordendeservicio", "timestamp", "operaciongestorcontable"})
public class REFOPERACIONGCType {
    @XmlElement(name = "OPERACION_GESTOR_CONTABLE", required = true)
    protected String operaciongestorcontable;
    @XmlElement(name = "ORDEN_DE_SERVICIO", required = true)
    protected ORDENDESERVICIOType ordendeservicio;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP", required = true)
    protected XMLGregorianCalendar timestamp;

    public ORDENDESERVICIOType getORDENDESERVICIO() {
        return this.ordendeservicio;
    }

    public void setORDENDESERVICIO(ORDENDESERVICIOType oRDENDESERVICIOType) {
        this.ordendeservicio = oRDENDESERVICIOType;
    }

    public XMLGregorianCalendar getTIMESTAMP() {
        return this.timestamp;
    }

    public void setTIMESTAMP(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestamp = xMLGregorianCalendar;
    }

    public String getOPERACIONGESTORCONTABLE() {
        return this.operaciongestorcontable;
    }

    public void setOPERACIONGESTORCONTABLE(String str) {
        this.operaciongestorcontable = str;
    }
}
