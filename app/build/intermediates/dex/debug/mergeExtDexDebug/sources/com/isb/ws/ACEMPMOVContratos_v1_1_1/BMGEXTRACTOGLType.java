package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_EXTRACTO_GL_Type", propOrder = {"empresa", "bmgcuenta", "tipomensajegstp", "fechavalor", "codextracto"})
public class BMGEXTRACTOGLType {
    @XmlElement(name = "BMG_CUENTA", required = true)
    protected BMGCUENTAType bmgcuenta;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_EXTRACTO")
    protected int codextracto;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECHA_VALOR", required = true)
    protected XMLGregorianCalendar fechavalor;
    @XmlElement(name = "TIPO_MENSAJE_GSTP", required = true)
    protected TIPOMENSAJEGSTPType tipomensajegstp;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public BMGCUENTAType getBMGCUENTA() {
        return this.bmgcuenta;
    }

    public void setBMGCUENTA(BMGCUENTAType bMGCUENTAType) {
        this.bmgcuenta = bMGCUENTAType;
    }

    public TIPOMENSAJEGSTPType getTIPOMENSAJEGSTP() {
        return this.tipomensajegstp;
    }

    public void setTIPOMENSAJEGSTP(TIPOMENSAJEGSTPType tIPOMENSAJEGSTPType) {
        this.tipomensajegstp = tIPOMENSAJEGSTPType;
    }

    public XMLGregorianCalendar getFECHAVALOR() {
        return this.fechavalor;
    }

    public void setFECHAVALOR(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fechavalor = xMLGregorianCalendar;
    }

    public int getCODEXTRACTO() {
        return this.codextracto;
    }

    public void setCODEXTRACTO(int i) {
        this.codextracto = i;
    }
}
