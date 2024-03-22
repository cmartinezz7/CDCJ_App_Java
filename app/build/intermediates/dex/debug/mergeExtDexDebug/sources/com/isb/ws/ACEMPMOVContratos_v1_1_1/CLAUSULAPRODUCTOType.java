package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLAUSULA_PRODUCTO_Type", propOrder = {"empresa", "codalfanum6"})
public class CLAUSULAPRODUCTOType {
    @XmlElement(name = "COD_ALFANUM_6", required = true)
    protected String codalfanum6;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM6() {
        return this.codalfanum6;
    }

    public void setCODALFANUM6(String str) {
        this.codalfanum6 = str;
    }
}
