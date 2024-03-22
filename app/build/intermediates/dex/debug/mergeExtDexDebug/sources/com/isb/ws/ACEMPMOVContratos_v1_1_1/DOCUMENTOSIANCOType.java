package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOCUMENTO_SIANCO_Type", propOrder = {"expedientesianco", "timestamp"})
public class DOCUMENTOSIANCOType {
    @XmlElement(name = "EXPEDIENTE_SIANCO", required = true)
    protected EXPEDIENTESIANCOType expedientesianco;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP", required = true)
    protected XMLGregorianCalendar timestamp;

    public EXPEDIENTESIANCOType getEXPEDIENTESIANCO() {
        return this.expedientesianco;
    }

    public void setEXPEDIENTESIANCO(EXPEDIENTESIANCOType eXPEDIENTESIANCOType) {
        this.expedientesianco = eXPEDIENTESIANCOType;
    }

    public XMLGregorianCalendar getTIMESTAMP() {
        return this.timestamp;
    }

    public void setTIMESTAMP(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestamp = xMLGregorianCalendar;
    }
}
