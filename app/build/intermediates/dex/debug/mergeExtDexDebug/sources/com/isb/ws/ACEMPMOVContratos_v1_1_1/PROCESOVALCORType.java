package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESO_VALCOR_Type", propOrder = {"expedientevalcor", "ciclovalcor", "timestampiniproceso"})
public class PROCESOVALCORType {
    @XmlElement(name = "CICLO_VALCOR", required = true)
    protected String ciclovalcor;
    @XmlElement(name = "EXPEDIENTE_VALCOR", required = true)
    protected EXPEDIENTEVALCORType expedientevalcor;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESTAMP_INI_PROCESO", required = true)
    protected XMLGregorianCalendar timestampiniproceso;

    public EXPEDIENTEVALCORType getEXPEDIENTEVALCOR() {
        return this.expedientevalcor;
    }

    public void setEXPEDIENTEVALCOR(EXPEDIENTEVALCORType eXPEDIENTEVALCORType) {
        this.expedientevalcor = eXPEDIENTEVALCORType;
    }

    public String getCICLOVALCOR() {
        return this.ciclovalcor;
    }

    public void setCICLOVALCOR(String str) {
        this.ciclovalcor = str;
    }

    public XMLGregorianCalendar getTIMESTAMPINIPROCESO() {
        return this.timestampiniproceso;
    }

    public void setTIMESTAMPINIPROCESO(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timestampiniproceso = xMLGregorianCalendar;
    }
}
