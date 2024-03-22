package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERROR_AHGECO_Type", propOrder = {"idmensajeahgeco", "timestamp"})
public class ERRORAHGECOType {
    @XmlElement(name = "ID_MENSAJE_AHGECO", required = true)
    protected IDMENSAJEAHGECOType idmensajeahgeco;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP", required = true)
    protected XMLGregorianCalendar timestamp;

    public IDMENSAJEAHGECOType getIDMENSAJEAHGECO() {
        return this.idmensajeahgeco;
    }

    public void setIDMENSAJEAHGECO(IDMENSAJEAHGECOType iDMENSAJEAHGECOType) {
        this.idmensajeahgeco = iDMENSAJEAHGECOType;
    }

    public XMLGregorianCalendar getTIMESTAMP() {
        return this.timestamp;
    }

    public void setTIMESTAMP(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestamp = xMLGregorianCalendar;
    }
}
