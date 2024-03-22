package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CATEGORIA_AHCORE_Type", propOrder = {"empresa", "codcanal", "tipovisionahcore", "codcategoria"})
public class CATEGORIAAHCOREType {
    @XmlElement(name = "COD_CANAL", required = true)
    protected String codcanal;
    @XmlElement(name = "COD_CATEGORIA", required = true)
    protected String codcategoria;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_VISION_AHCORE", required = true)
    protected String tipovisionahcore;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODCANAL() {
        return this.codcanal;
    }

    public void setCODCANAL(String str) {
        this.codcanal = str;
    }

    public String getTIPOVISIONAHCORE() {
        return this.tipovisionahcore;
    }

    public void setTIPOVISIONAHCORE(String str) {
        this.tipovisionahcore = str;
    }

    public String getCODCATEGORIA() {
        return this.codcategoria;
    }

    public void setCODCATEGORIA(String str) {
        this.codcategoria = str;
    }
}
