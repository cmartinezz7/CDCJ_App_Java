package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_UNIDAD_VENTA_AC_COMER_Type", propOrder = {"empresa", "coduvent"})
public class CODUNIDADVENTAACCOMERType {
    @XmlElement(name = "COD_UVENT", required = true)
    protected String coduvent;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODUVENT() {
        return this.coduvent;
    }

    public void setCODUVENT(String str) {
        this.coduvent = str;
    }
}
