package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIRMA_OTP_Type", propOrder = {"ticketotp", "numintentos", "fechaexpiracion"})
public class FIRMAOTPType {
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "FECHAEXPIRACION", required = true)
    protected XMLGregorianCalendar fechaexpiracion;
    @XmlElement(name = "NUMINTENTOS", required = true)
    protected String numintentos;
    @XmlElement(name = "TICKETOTP", required = true)
    protected String ticketotp;

    public String getTICKETOTP() {
        return this.ticketotp;
    }

    public void setTICKETOTP(String str) {
        this.ticketotp = str;
    }

    public String getNUMINTENTOS() {
        return this.numintentos;
    }

    public void setNUMINTENTOS(String str) {
        this.numintentos = str;
    }

    public XMLGregorianCalendar getFECHAEXPIRACION() {
        return this.fechaexpiracion;
    }

    public void setFECHAEXPIRACION(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechaexpiracion = xMLGregorianCalendar;
    }
}
