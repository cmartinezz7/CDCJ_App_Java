package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORIGEN_ANCOCO_Type", propOrder = {"empresa", "canaldis", "codtipoalerta"})
public class ORIGENANCOCOType {
    @XmlElement(name = "CANALDIS", required = true)
    protected String canaldis;
    @XmlElement(name = "COD_TIPO_ALERTA", required = true)
    protected String codtipoalerta;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

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

    public String getCODTIPOALERTA() {
        return this.codtipoalerta;
    }

    public void setCODTIPOALERTA(String str) {
        this.codtipoalerta = str;
    }
}
