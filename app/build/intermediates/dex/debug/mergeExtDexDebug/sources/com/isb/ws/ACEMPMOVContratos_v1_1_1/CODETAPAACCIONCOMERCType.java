package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_ETAPA_ACCION_COMERC_Type", propOrder = {"empresa", "codetapa"})
public class CODETAPAACCIONCOMERCType {
    @XmlElement(name = "COD_ETAPA", required = true)
    protected String codetapa;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODETAPA() {
        return this.codetapa;
    }

    public void setCODETAPA(String str) {
        this.codetapa = str;
    }
}
