package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_ERROR_NOF_Type", propOrder = {"coderror", "sistema"})
public class CODIGOERRORNOFType {
    @XmlElement(name = "COD_ERROR", required = true)
    protected String coderror;
    @XmlElement(name = "SISTEMA", required = true)
    protected String sistema;

    public String getCODERROR() {
        return this.coderror;
    }

    public void setCODERROR(String str) {
        this.coderror = str;
    }

    public String getSISTEMA() {
        return this.sistema;
    }

    public void setSISTEMA(String str) {
        this.sistema = str;
    }
}
