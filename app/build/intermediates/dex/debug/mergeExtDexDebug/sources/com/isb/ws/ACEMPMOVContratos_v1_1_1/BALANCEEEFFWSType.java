package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BALANCE_EEFF_WS_Type", propOrder = {"plancontableeeff", "codexpedienteeeff", "fechabalanceeeff", "timestampinieeff"})
public class BALANCEEEFFWSType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_EXPEDIENTE_EEFF")
    protected long codexpedienteeeff;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_BALANCE_EEFF", required = true)
    protected XMLGregorianCalendar fechabalanceeeff;
    @XmlElement(name = "PLAN_CONTABLE_EEFF", required = true)
    protected PLANCONTABLEEEFFType plancontableeeff;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP_INI_EEFF", required = true)
    protected XMLGregorianCalendar timestampinieeff;

    public PLANCONTABLEEEFFType getPLANCONTABLEEEFF() {
        return this.plancontableeeff;
    }

    public void setPLANCONTABLEEEFF(PLANCONTABLEEEFFType pLANCONTABLEEEFFType) {
        this.plancontableeeff = pLANCONTABLEEEFFType;
    }

    public long getCODEXPEDIENTEEEFF() {
        return this.codexpedienteeeff;
    }

    public void setCODEXPEDIENTEEEFF(long j) {
        this.codexpedienteeeff = j;
    }

    public XMLGregorianCalendar getFECHABALANCEEEFF() {
        return this.fechabalanceeeff;
    }

    public void setFECHABALANCEEEFF(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechabalanceeeff = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getTIMESTAMPINIEEFF() {
        return this.timestampinieeff;
    }

    public void setTIMESTAMPINIEEFF(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestampinieeff = xMLGregorianCalendar;
    }
}
