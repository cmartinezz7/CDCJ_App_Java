package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBCUENTA_CONTABLE_Type", propOrder = {"empresa", "codalfanum12"})
public class SUBCUENTACONTABLEType {
    @XmlElement(name = "COD_ALFANUM_12", required = true)
    protected String codalfanum12;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM12() {
        return this.codalfanum12;
    }

    public void setCODALFANUM12(String str) {
        this.codalfanum12 = str;
    }
}
