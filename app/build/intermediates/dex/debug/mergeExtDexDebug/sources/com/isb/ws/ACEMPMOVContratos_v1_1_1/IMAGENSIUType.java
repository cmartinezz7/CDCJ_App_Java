package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMAGEN_SIU_Type", propOrder = {"tipoimagensiu", "codimagensiu"})
public class IMAGENSIUType {
    @XmlElement(name = "COD_IMAGEN_SIU", required = true)
    protected String codimagensiu;
    @XmlElement(name = "TIPO_IMAGEN_SIU", required = true)
    protected String tipoimagensiu;

    public String getTIPOIMAGENSIU() {
        return this.tipoimagensiu;
    }

    public void setTIPOIMAGENSIU(String str) {
        this.tipoimagensiu = str;
    }

    public String getCODIMAGENSIU() {
        return this.codimagensiu;
    }

    public void setCODIMAGENSIU(String str) {
        this.codimagensiu = str;
    }
}
