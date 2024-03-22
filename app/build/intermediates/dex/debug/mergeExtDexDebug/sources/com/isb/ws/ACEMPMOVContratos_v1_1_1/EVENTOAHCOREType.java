package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENTO_AHCORE_Type", propOrder = {"empresa", "codcanal", "tipovisionahcore", "codevento"})
public class EVENTOAHCOREType {
    @XmlElement(name = "COD_CANAL", required = true)
    protected String codcanal;
    @XmlElement(name = "COD_EVENTO", required = true)
    protected String codevento;
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

    public String getCODEVENTO() {
        return this.codevento;
    }

    public void setCODEVENTO(String str) {
        this.codevento = str;
    }
}
