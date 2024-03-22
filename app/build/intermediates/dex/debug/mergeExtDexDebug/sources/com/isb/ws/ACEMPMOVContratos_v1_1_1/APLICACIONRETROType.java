package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APLICACION_RETRO_Type", propOrder = {"empresa", "codaplicacionretro"})
public class APLICACIONRETROType {
    @XmlElement(name = "COD_APLICACION_RETRO", required = true)
    protected String codaplicacionretro;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODAPLICACIONRETRO() {
        return this.codaplicacionretro;
    }

    public void setCODAPLICACIONRETRO(String str) {
        this.codaplicacionretro = str;
    }
}
