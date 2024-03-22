package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CIRCUITO_DE_ADMISION_Type", propOrder = {"empresa", "circuitoadmision"})
public class CIRCUITODEADMISIONType {
    @XmlElement(name = "CIRCUITO_ADMISION", required = true)
    protected String circuitoadmision;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCIRCUITOADMISION() {
        return this.circuitoadmision;
    }

    public void setCIRCUITOADMISION(String str) {
        this.circuitoadmision = str;
    }
}
