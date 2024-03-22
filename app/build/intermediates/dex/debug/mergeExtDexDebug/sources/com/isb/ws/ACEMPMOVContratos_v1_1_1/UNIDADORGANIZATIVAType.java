package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UNIDAD_ORGANIZATIVA_Type", propOrder = {"tipounidadorganizativa", "codunidadorganizativa"})
public class UNIDADORGANIZATIVAType {
    @XmlElement(name = "COD_UNIDAD_ORGANIZATIVA", required = true)
    protected String codunidadorganizativa;
    @XmlElement(name = "TIPO_UNIDAD_ORGANIZATIVA", required = true)
    protected String tipounidadorganizativa;

    public String getTIPOUNIDADORGANIZATIVA() {
        return this.tipounidadorganizativa;
    }

    public void setTIPOUNIDADORGANIZATIVA(String str) {
        this.tipounidadorganizativa = str;
    }

    public String getCODUNIDADORGANIZATIVA() {
        return this.codunidadorganizativa;
    }

    public void setCODUNIDADORGANIZATIVA(String str) {
        this.codunidadorganizativa = str;
    }
}
