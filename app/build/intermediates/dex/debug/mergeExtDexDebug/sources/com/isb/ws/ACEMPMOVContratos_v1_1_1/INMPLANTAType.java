package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_PLANTA_Type", propOrder = {"inminmueble", "codplanta"})
public class INMPLANTAType {
    @XmlElement(name = "COD_PLANTA", required = true)
    protected String codplanta;
    @XmlElement(name = "INM_INMUEBLE", required = true)
    protected String inminmueble;

    public String getINMINMUEBLE() {
        return this.inminmueble;
    }

    public void setINMINMUEBLE(String str) {
        this.inminmueble = str;
    }

    public String getCODPLANTA() {
        return this.codplanta;
    }

    public void setCODPLANTA(String str) {
        this.codplanta = str;
    }
}
