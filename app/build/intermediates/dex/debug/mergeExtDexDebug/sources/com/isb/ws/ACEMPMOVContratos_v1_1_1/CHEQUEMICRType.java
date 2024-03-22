package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_MICR_Type", propOrder = {"tipomicr", "codigomicr"})
public class CHEQUEMICRType {
    @XmlElement(name = "CODIGO_MICR", required = true)
    protected String codigomicr;
    @XmlElement(name = "TIPO_MICR", required = true)
    protected String tipomicr;

    public String getTIPOMICR() {
        return this.tipomicr;
    }

    public void setTIPOMICR(String str) {
        this.tipomicr = str;
    }

    public String getCODIGOMICR() {
        return this.codigomicr;
    }

    public void setCODIGOMICR(String str) {
        this.codigomicr = str;
    }
}
