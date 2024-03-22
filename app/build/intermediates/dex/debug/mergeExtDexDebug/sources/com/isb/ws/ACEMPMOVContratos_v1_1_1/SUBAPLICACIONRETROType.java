package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBAPLICACION_RETRO_Type", propOrder = {"empresa", "codsubaplicacionretro"})
public class SUBAPLICACIONRETROType {
    @XmlElement(name = "COD_SUBAPLICACION_RETRO", required = true)
    protected String codsubaplicacionretro;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODSUBAPLICACIONRETRO() {
        return this.codsubaplicacionretro;
    }

    public void setCODSUBAPLICACIONRETRO(String str) {
        this.codsubaplicacionretro = str;
    }
}
