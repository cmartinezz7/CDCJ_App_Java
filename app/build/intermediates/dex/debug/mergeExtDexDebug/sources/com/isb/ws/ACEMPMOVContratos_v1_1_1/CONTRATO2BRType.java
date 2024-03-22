package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_2_BR_Type", propOrder = {"entidadbr", "sucursalbr", "nrocuenta2BR"})
public class CONTRATO2BRType {
    @XmlElement(name = "ENTIDAD_BR", required = true)
    protected String entidadbr;
    @XmlElement(name = "NRO_CUENTA_2_BR", required = true)
    protected String nrocuenta2BR;
    @XmlElement(name = "SUCURSAL_BR", required = true)
    protected String sucursalbr;

    public String getENTIDADBR() {
        return this.entidadbr;
    }

    public void setENTIDADBR(String str) {
        this.entidadbr = str;
    }

    public String getSUCURSALBR() {
        return this.sucursalbr;
    }

    public void setSUCURSALBR(String str) {
        this.sucursalbr = str;
    }

    public String getNROCUENTA2BR() {
        return this.nrocuenta2BR;
    }

    public void setNROCUENTA2BR(String str) {
        this.nrocuenta2BR = str;
    }
}
