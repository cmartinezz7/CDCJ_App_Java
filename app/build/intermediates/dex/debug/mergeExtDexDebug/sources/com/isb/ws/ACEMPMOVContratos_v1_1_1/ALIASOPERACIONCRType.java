package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ALIAS_OPERACION_CR_Type", propOrder = {"empresa", "sistema", "codaliasoperacion"})
public class ALIASOPERACIONCRType {
    @XmlElement(name = "COD_ALIAS_OPERACION", required = true)
    protected String codaliasoperacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "SISTEMA", required = true)
    protected String sistema;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSISTEMA() {
        return this.sistema;
    }

    public void setSISTEMA(String str) {
        this.sistema = str;
    }

    public String getCODALIASOPERACION() {
        return this.codaliasoperacion;
    }

    public void setCODALIASOPERACION(String str) {
        this.codaliasoperacion = str;
    }
}
