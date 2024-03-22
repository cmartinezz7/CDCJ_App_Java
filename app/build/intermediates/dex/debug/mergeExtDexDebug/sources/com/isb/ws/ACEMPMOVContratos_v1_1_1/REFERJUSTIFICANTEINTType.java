package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFER_JUSTIFICANTE_INT_Type", propOrder = {"empresa", "idjustificanteint", "secuencia"})
public class REFERJUSTIFICANTEINTType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ID_JUSTIFICANTE_INT", required = true)
    protected String idjustificanteint;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIA")
    protected int secuencia;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getIDJUSTIFICANTEINT() {
        return this.idjustificanteint;
    }

    public void setIDJUSTIFICANTEINT(String str) {
        this.idjustificanteint = str;
    }

    public int getSECUENCIA() {
        return this.secuencia;
    }

    public void setSECUENCIA(int i) {
        this.secuencia = i;
    }
}
