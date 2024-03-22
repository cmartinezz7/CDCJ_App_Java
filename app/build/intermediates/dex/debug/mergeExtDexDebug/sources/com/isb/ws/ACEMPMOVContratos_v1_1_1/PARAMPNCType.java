package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_PNC_Type", propOrder = {"empresa", "codparampnc"})
public class PARAMPNCType {
    @XmlElement(name = "COD_PARAM_PNC", required = true)
    protected String codparampnc;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODPARAMPNC() {
        return this.codparampnc;
    }

    public void setCODPARAMPNC(String str) {
        this.codparampnc = str;
    }
}
