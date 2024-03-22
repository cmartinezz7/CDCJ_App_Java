package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_ZONA_Type", propOrder = {"inmplanta", "codzona"})
public class INMZONAType {
    @XmlElement(name = "COD_ZONA", required = true)
    protected String codzona;
    @XmlElement(name = "INM_PLANTA", required = true)
    protected INMPLANTAType inmplanta;

    public INMPLANTAType getINMPLANTA() {
        return this.inmplanta;
    }

    public void setINMPLANTA(INMPLANTAType iNMPLANTAType) {
        this.inmplanta = iNMPLANTAType;
    }

    public String getCODZONA() {
        return this.codzona;
    }

    public void setCODZONA(String str) {
        this.codzona = str;
    }
}
