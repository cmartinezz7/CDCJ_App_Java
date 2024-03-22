package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFERENCIA_BLOQUEO_FONDO_Type", propOrder = {"contrato", "timestamp"})
public class REFERENCIABLOQUEOFONDOType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP", required = true)
    protected XMLGregorianCalendar timestamp;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public XMLGregorianCalendar getTIMESTAMP() {
        return this.timestamp;
    }

    public void setTIMESTAMP(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestamp = xMLGregorianCalendar;
    }
}
