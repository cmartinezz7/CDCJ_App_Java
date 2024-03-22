package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTIVIDAD_FMIS_Type", propOrder = {"empresafmis", "codcnaefmis"})
public class ACTIVIDADFMISType {
    @XmlElement(name = "COD_CNAE_FMIS", required = true)
    protected String codcnaefmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODCNAEFMIS() {
        return this.codcnaefmis;
    }

    public void setCODCNAEFMIS(String str) {
        this.codcnaefmis = str;
    }
}
