package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVIDENCIA_Type", propOrder = {"empresa", "codnum"})
public class EVIDENCIAType {
    @XmlElement(name = "COD_NUM", required = true)
    protected String codnum;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODNUM() {
        return this.codnum;
    }

    public void setCODNUM(String str) {
        this.codnum = str;
    }
}
