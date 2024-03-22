package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CASO_RECLAM_PN_Type", propOrder = {"centro", "codcasoreclam", "version"})
public class IDCASORECLAMPNType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "COD_CASO_RECLAM", required = true)
    protected String codcasoreclam;
    @XmlElement(name = "VERSION", required = true)
    protected String version;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODCASORECLAM() {
        return this.codcasoreclam;
    }

    public void setCODCASORECLAM(String str) {
        this.codcasoreclam = str;
    }

    public String getVERSION() {
        return this.version;
    }

    public void setVERSION(String str) {
        this.version = str;
    }
}
