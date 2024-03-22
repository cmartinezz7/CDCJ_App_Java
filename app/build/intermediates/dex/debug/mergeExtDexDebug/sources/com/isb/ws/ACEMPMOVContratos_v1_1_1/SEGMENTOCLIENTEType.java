package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SEGMENTO_CLIENTE_Type", propOrder = {"empresa", "segmento"})
public class SEGMENTOCLIENTEType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "SEGMENTO", required = true)
    protected String segmento;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSEGMENTO() {
        return this.segmento;
    }

    public void setSEGMENTO(String str) {
        this.segmento = str;
    }
}
