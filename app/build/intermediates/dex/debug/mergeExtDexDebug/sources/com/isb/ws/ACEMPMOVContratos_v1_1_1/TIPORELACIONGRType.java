package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_RELACION_GR_Type", propOrder = {"empresa", "tiprelacgr"})
public class TIPORELACIONGRType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIP_RELAC_GR", required = true)
    protected String tiprelacgr;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPRELACGR() {
        return this.tiprelacgr;
    }

    public void setTIPRELACGR(String str) {
        this.tiprelacgr = str;
    }
}
