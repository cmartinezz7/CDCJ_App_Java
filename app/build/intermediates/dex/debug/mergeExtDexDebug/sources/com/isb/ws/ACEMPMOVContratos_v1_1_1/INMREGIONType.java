package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_REGION_Type", propOrder = {"inmpais", "codregion"})
public class INMREGIONType {
    @XmlElement(name = "COD_REGION", required = true)
    protected String codregion;
    @XmlElement(name = "INM_PAIS", required = true)
    protected String inmpais;

    public String getINMPAIS() {
        return this.inmpais;
    }

    public void setINMPAIS(String str) {
        this.inmpais = str;
    }

    public String getCODREGION() {
        return this.codregion;
    }

    public void setCODREGION(String str) {
        this.codregion = str;
    }
}
