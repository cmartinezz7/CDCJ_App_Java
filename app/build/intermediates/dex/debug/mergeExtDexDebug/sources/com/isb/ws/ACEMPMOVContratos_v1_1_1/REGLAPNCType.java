package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_PNC_Type", propOrder = {"empresa", "codreglapnc"})
public class REGLAPNCType {
    @XmlElement(name = "COD_REGLA_PNC", required = true)
    protected String codreglapnc;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODREGLAPNC() {
        return this.codreglapnc;
    }

    public void setCODREGLAPNC(String str) {
        this.codreglapnc = str;
    }
}
