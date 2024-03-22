package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_ERROR_PROC_LIQUI_Type", propOrder = {"empresa", "coderrorproc"})
public class CODERRORPROCLIQUIType {
    @XmlElement(name = "COD_ERROR_PROC", required = true)
    protected String coderrorproc;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODERRORPROC() {
        return this.coderrorproc;
    }

    public void setCODERRORPROC(String str) {
        this.coderrorproc = str;
    }
}
