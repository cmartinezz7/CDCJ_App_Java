package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CENTRO_Type", propOrder = {"empresa", "centro"})
public class CENTROType {
    @XmlElement(name = "CENTRO", required = true)
    protected String centro;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(String str) {
        this.centro = str;
    }
}
