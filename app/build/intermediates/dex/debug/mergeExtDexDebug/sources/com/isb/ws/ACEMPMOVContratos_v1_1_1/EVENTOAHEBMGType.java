package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENTO_AHEBMG_Type", propOrder = {"empresa", "codigodecanal", "codigoalfanum6"})
public class EVENTOAHEBMGType {
    @XmlElement(name = "CODIGO_ALFANUM_6", required = true)
    protected String codigoalfanum6;
    @XmlElement(name = "CODIGO_DE_CANAL", required = true)
    protected String codigodecanal;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGODECANAL() {
        return this.codigodecanal;
    }

    public void setCODIGODECANAL(String str) {
        this.codigodecanal = str;
    }

    public String getCODIGOALFANUM6() {
        return this.codigoalfanum6;
    }

    public void setCODIGOALFANUM6(String str) {
        this.codigoalfanum6 = str;
    }
}
