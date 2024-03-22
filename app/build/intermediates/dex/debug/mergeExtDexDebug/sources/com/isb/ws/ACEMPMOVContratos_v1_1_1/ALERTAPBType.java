package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ALERTA_PB_Type", propOrder = {"empresa", "alerta"})
public class ALERTAPBType {
    @XmlElement(name = "ALERTA", required = true)
    protected String alerta;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getALERTA() {
        return this.alerta;
    }

    public void setALERTA(String str) {
        this.alerta = str;
    }
}