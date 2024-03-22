package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VIA_PT_Type", propOrder = {"freguesiapt", "localidadpt", "codviapt"})
public class VIAPTType {
    @XmlElement(name = "COD_VIA_PT", required = true)
    protected String codviapt;
    @XmlElement(name = "FREGUESIA_PT", required = true)
    protected FREGUESIAPTType freguesiapt;
    @XmlElement(name = "LOCALIDAD_PT", required = true)
    protected String localidadpt;

    public FREGUESIAPTType getFREGUESIAPT() {
        return this.freguesiapt;
    }

    public void setFREGUESIAPT(FREGUESIAPTType fREGUESIAPTType) {
        this.freguesiapt = fREGUESIAPTType;
    }

    public String getLOCALIDADPT() {
        return this.localidadpt;
    }

    public void setLOCALIDADPT(String str) {
        this.localidadpt = str;
    }

    public String getCODVIAPT() {
        return this.codviapt;
    }

    public void setCODVIAPT(String str) {
        this.codviapt = str;
    }
}
