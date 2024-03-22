package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_DE_EMPRESAS_Type", propOrder = {"empresa", "grupodeempresa"})
public class GRUPODEEMPRESASType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "GRUPO_DE_EMPRESA", required = true)
    protected String grupodeempresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getGRUPODEEMPRESA() {
        return this.grupodeempresa;
    }

    public void setGRUPODEEMPRESA(String str) {
        this.grupodeempresa = str;
    }
}
