package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFER_JUSTIFICANTE_EXT_Type", propOrder = {"empresa", "idjustificanteext", "secuencia"})
public class REFERJUSTIFICANTEEXTType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ID_JUSTIFICANTE_EXT", required = true)
    protected String idjustificanteext;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIA")
    protected int secuencia;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getIDJUSTIFICANTEEXT() {
        return this.idjustificanteext;
    }

    public void setIDJUSTIFICANTEEXT(String str) {
        this.idjustificanteext = str;
    }

    public int getSECUENCIA() {
        return this.secuencia;
    }

    public void setSECUENCIA(int i) {
        this.secuencia = i;
    }
}
