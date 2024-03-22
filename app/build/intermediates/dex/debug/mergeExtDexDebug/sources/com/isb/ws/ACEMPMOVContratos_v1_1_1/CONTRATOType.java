package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_Type", propOrder = {"centro", "producto", "numerodecontrato"})
public class CONTRATOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTRODECONTRATOType centro;
    @XmlElement(name = "NUMERO_DE_CONTRATO", required = true)
    protected String numerodecontrato;
    @XmlElement(name = "PRODUCTO", required = true)
    protected String producto;

    public CENTRODECONTRATOType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centro = cENTRODECONTRATOType;
    }

    public String getPRODUCTO() {
        return this.producto;
    }

    public void setPRODUCTO(String str) {
        this.producto = str;
    }

    public String getNUMERODECONTRATO() {
        return this.numerodecontrato;
    }

    public void setNUMERODECONTRATO(String str) {
        this.numerodecontrato = str;
    }
}
