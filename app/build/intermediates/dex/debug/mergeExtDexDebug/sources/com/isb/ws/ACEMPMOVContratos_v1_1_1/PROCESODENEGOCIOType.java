package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESO_DE_NEGOCIO_Type", propOrder = {"empresa", "procesodenegocio"})
public class PROCESODENEGOCIOType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected String procesodenegocio;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(String str) {
        this.procesodenegocio = str;
    }
}
