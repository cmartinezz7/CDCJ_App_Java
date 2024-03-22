package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONSULTA_AIS_Type", propOrder = {"empresa", "secuencialconsultaais"})
public class CONSULTAAISType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIAL_CONSULTA_AIS")
    protected int secuencialconsultaais;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getSECUENCIALCONSULTAAIS() {
        return this.secuencialconsultaais;
    }

    public void setSECUENCIALCONSULTAAIS(int i) {
        this.secuencialconsultaais = i;
    }
}
