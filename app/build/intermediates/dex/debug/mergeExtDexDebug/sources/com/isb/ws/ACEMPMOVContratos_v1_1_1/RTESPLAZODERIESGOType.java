package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTES_PLAZO_DE_RIESGO_Type", propOrder = {"empresa", "plazoriesgo"})
public class RTESPLAZODERIESGOType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "PLAZO_RIESGO", required = true)
    protected String plazoriesgo;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getPLAZORIESGO() {
        return this.plazoriesgo;
    }

    public void setPLAZORIESGO(String str) {
        this.plazoriesgo = str;
    }
}
