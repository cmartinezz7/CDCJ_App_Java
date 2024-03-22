package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CATALOGO_AHGECO_Type", propOrder = {"ahcoderror", "bwcoderror"})
public class CATALOGOAHGECOType {
    @XmlElement(name = "AH_COD_ERROR", required = true)
    protected String ahcoderror;
    @XmlElement(name = "BW_COD_ERROR", required = true)
    protected String bwcoderror;

    public String getAHCODERROR() {
        return this.ahcoderror;
    }

    public void setAHCODERROR(String str) {
        this.ahcoderror = str;
    }

    public String getBWCODERROR() {
        return this.bwcoderror;
    }

    public void setBWCODERROR(String str) {
        this.bwcoderror = str;
    }
}
