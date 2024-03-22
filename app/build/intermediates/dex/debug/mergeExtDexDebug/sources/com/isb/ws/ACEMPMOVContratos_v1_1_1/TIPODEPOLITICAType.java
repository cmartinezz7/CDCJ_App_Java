package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_POLITICA_Type", propOrder = {"empresa", "tipodepolitica"})
public class TIPODEPOLITICAType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_DE_POLITICA", required = true)
    protected String tipodepolitica;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPODEPOLITICA() {
        return this.tipodepolitica;
    }

    public void setTIPODEPOLITICA(String str) {
        this.tipodepolitica = str;
    }
}
