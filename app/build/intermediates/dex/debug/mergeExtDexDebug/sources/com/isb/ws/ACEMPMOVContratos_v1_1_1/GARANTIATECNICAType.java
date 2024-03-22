package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GARANTIA_TECNICA_Type", propOrder = {"clasedegarantia", "tipodegarantia", "indicaciondegarantia"})
public class GARANTIATECNICAType {
    @XmlElement(name = "CLASE_DE_GARANTIA", required = true)
    protected String clasedegarantia;
    @XmlElement(name = "INDICACION_DE_GARANTIA", required = true)
    protected String indicaciondegarantia;
    @XmlElement(name = "TIPO_DE_GARANTIA", required = true)
    protected String tipodegarantia;

    public String getCLASEDEGARANTIA() {
        return this.clasedegarantia;
    }

    public void setCLASEDEGARANTIA(String str) {
        this.clasedegarantia = str;
    }

    public String getTIPODEGARANTIA() {
        return this.tipodegarantia;
    }

    public void setTIPODEGARANTIA(String str) {
        this.tipodegarantia = str;
    }

    public String getINDICACIONDEGARANTIA() {
        return this.indicaciondegarantia;
    }

    public void setINDICACIONDEGARANTIA(String str) {
        this.indicaciondegarantia = str;
    }
}
