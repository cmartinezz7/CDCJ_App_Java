package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IND_ACTIVIDAD_GR_Type", propOrder = {"empresa", "indactvgr"})
public class INDACTIVIDADGRType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "IND_ACTV_GR", required = true)
    protected String indactvgr;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getINDACTVGR() {
        return this.indactvgr;
    }

    public void setINDACTVGR(String str) {
        this.indactvgr = str;
    }
}
