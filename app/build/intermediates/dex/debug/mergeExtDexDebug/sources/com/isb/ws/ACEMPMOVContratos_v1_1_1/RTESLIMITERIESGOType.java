package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTES_LIMITE_RIESGO_Type", propOrder = {"grupoempresa", "limiteriesgo"})
public class RTESLIMITERIESGOType {
    @XmlElement(name = "GRUPO_EMPRESA", required = true)
    protected String grupoempresa;
    @XmlElement(name = "LIMITE_RIESGO", required = true)
    protected String limiteriesgo;

    public String getGRUPOEMPRESA() {
        return this.grupoempresa;
    }

    public void setGRUPOEMPRESA(String str) {
        this.grupoempresa = str;
    }

    public String getLIMITERIESGO() {
        return this.limiteriesgo;
    }

    public void setLIMITERIESGO(String str) {
        this.limiteriesgo = str;
    }
}
