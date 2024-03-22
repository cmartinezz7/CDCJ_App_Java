package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEMA_CONSULTA_CSN_Type", propOrder = {"empresa", "codigonum3"})
public class TEMACONSULTACSNType {
    @XmlElement(name = "CODIGO_NUM_3", required = true)
    protected String codigonum3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGONUM3() {
        return this.codigonum3;
    }

    public void setCODIGONUM3(String str) {
        this.codigonum3 = str;
    }
}
