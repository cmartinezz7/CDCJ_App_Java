package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SEGMENTO_FMIS_Type", propOrder = {"aplicacionfmis", "empresafmis", "codigosegmentofmis"})
public class SEGMENTOFMISType {
    @XmlElement(name = "APLICACION_FMIS", required = true)
    protected String aplicacionfmis;
    @XmlElement(name = "CODIGO_SEGMENTO_FMIS", required = true)
    protected String codigosegmentofmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getAPLICACIONFMIS() {
        return this.aplicacionfmis;
    }

    public void setAPLICACIONFMIS(String str) {
        this.aplicacionfmis = str;
    }

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODIGOSEGMENTOFMIS() {
        return this.codigosegmentofmis;
    }

    public void setCODIGOSEGMENTOFMIS(String str) {
        this.codigosegmentofmis = str;
    }
}
