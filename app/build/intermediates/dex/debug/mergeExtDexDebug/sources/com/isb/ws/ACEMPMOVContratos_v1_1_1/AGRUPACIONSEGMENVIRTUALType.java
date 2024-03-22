package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPACION_SEGMEN_VIRTUAL_Type", propOrder = {"empresa", "comp2", "comp3"})
public class AGRUPACIONSEGMENVIRTUALType {
    @XmlElement(name = "COMP2", required = true)
    protected String comp2;
    @XmlElement(name = "COMP3", required = true)
    protected String comp3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCOMP2() {
        return this.comp2;
    }

    public void setCOMP2(String str) {
        this.comp2 = str;
    }

    public String getCOMP3() {
        return this.comp3;
    }

    public void setCOMP3(String str) {
        this.comp3 = str;
    }
}
