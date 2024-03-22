package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_PROVINCIA_Type", propOrder = {"inmregion", "codprovincia"})
public class INMPROVINCIAType {
    @XmlElement(name = "COD_PROVINCIA", required = true)
    protected String codprovincia;
    @XmlElement(name = "INM_REGION", required = true)
    protected INMREGIONType inmregion;

    public INMREGIONType getINMREGION() {
        return this.inmregion;
    }

    public void setINMREGION(INMREGIONType iNMREGIONType) {
        this.inmregion = iNMREGIONType;
    }

    public String getCODPROVINCIA() {
        return this.codprovincia;
    }

    public void setCODPROVINCIA(String str) {
        this.codprovincia = str;
    }
}
