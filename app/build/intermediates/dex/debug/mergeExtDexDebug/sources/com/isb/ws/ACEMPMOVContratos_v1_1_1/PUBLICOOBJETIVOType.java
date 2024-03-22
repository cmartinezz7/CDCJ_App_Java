package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PUBLICO_OBJETIVO_Type", propOrder = {"empresa", "codpublicoobjetivo"})
public class PUBLICOOBJETIVOType {
    @XmlElement(name = "COD_PUBLICO_OBJETIVO", required = true)
    protected String codpublicoobjetivo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODPUBLICOOBJETIVO() {
        return this.codpublicoobjetivo;
    }

    public void setCODPUBLICOOBJETIVO(String str) {
        this.codpublicoobjetivo = str;
    }
}
