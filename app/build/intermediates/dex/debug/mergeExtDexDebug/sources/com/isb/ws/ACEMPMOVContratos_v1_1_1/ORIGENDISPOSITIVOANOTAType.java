package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORIGEN_DISPOSITIVO_ANOTA_Type", propOrder = {"empresa", "canaldis", "tipoalerta"})
public class ORIGENDISPOSITIVOANOTAType {
    @XmlElement(name = "CANALDIS", required = true)
    protected String canaldis;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_ALERTA", required = true)
    protected String tipoalerta;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANALDIS() {
        return this.canaldis;
    }

    public void setCANALDIS(String str) {
        this.canaldis = str;
    }

    public String getTIPOALERTA() {
        return this.tipoalerta;
    }

    public void setTIPOALERTA(String str) {
        this.tipoalerta = str;
    }
}
