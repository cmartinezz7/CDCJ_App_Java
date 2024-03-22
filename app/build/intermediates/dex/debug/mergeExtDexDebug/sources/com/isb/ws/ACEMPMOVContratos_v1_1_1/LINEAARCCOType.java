package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_ARCCO_Type", propOrder = {"empresa", "aplicacioninformatica", "codigoalfanum6"})
public class LINEAARCCOType {
    @XmlElement(name = "APLICACION_INFORMATICA", required = true)
    protected String aplicacioninformatica;
    @XmlElement(name = "CODIGO_ALFANUM_6", required = true)
    protected String codigoalfanum6;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getAPLICACIONINFORMATICA() {
        return this.aplicacioninformatica;
    }

    public void setAPLICACIONINFORMATICA(String str) {
        this.aplicacioninformatica = str;
    }

    public String getCODIGOALFANUM6() {
        return this.codigoalfanum6;
    }

    public void setCODIGOALFANUM6(String str) {
        this.codigoalfanum6 = str;
    }
}
