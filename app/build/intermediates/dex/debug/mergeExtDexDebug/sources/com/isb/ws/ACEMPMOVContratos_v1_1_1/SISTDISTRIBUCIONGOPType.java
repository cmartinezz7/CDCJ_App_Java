package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIST_DISTRIBUCION_GOP_Type", propOrder = {"empresa", "string6"})
public class SISTDISTRIBUCIONGOPType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "STRING_6", required = true)
    protected String string6;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSTRING6() {
        return this.string6;
    }

    public void setSTRING6(String str) {
        this.string6 = str;
    }
}
