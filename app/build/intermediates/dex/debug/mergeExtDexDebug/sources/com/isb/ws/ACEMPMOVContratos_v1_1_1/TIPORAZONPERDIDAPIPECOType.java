package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_RAZON_PERDIDA_PIPECO_Type", propOrder = {"empresa", "codalfanum"})
public class TIPORAZONPERDIDAPIPECOType {
    @XmlElement(name = "COD_ALFANUM", required = true)
    protected String codalfanum;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM() {
        return this.codalfanum;
    }

    public void setCODALFANUM(String str) {
        this.codalfanum = str;
    }
}