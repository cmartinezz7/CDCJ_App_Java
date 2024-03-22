package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FACTURA_PB_Type", propOrder = {"empresa", "codalfanum15"})
public class FACTURAPBType {
    @XmlElement(name = "COD_ALFANUM_15", required = true)
    protected String codalfanum15;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM15() {
        return this.codalfanum15;
    }

    public void setCODALFANUM15(String str) {
        this.codalfanum15 = str;
    }
}
