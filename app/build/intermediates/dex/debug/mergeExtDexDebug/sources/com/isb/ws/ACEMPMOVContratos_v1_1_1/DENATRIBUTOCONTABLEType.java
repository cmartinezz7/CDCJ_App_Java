package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DEN_ATRIBUTO_CONTABLE_Type", propOrder = {"empresa", "codigoalfanum1SINESP", "codigoalfanum3SINESP"})
public class DENATRIBUTOCONTABLEType {
    @XmlElement(name = "CODIGO_ALFANUM_1_SIN_ESP", required = true)
    protected String codigoalfanum1SINESP;
    @XmlElement(name = "CODIGO_ALFANUM_3_SIN_ESP", required = true)
    protected String codigoalfanum3SINESP;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM1SINESP() {
        return this.codigoalfanum1SINESP;
    }

    public void setCODIGOALFANUM1SINESP(String str) {
        this.codigoalfanum1SINESP = str;
    }

    public String getCODIGOALFANUM3SINESP() {
        return this.codigoalfanum3SINESP;
    }

    public void setCODIGOALFANUM3SINESP(String str) {
        this.codigoalfanum3SINESP = str;
    }
}
