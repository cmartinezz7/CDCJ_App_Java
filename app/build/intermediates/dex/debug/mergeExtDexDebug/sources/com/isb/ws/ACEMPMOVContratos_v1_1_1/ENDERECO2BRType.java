package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENDERECO_2_BR_Type", propOrder = {"titularidadeviabr", "enderecobr"})
public class ENDERECO2BRType {
    @XmlElement(name = "ENDERECO_BR", required = true)
    protected String enderecobr;
    @XmlElement(name = "TITULARIDADE_VIA_BR", required = true)
    protected String titularidadeviabr;

    public String getTITULARIDADEVIABR() {
        return this.titularidadeviabr;
    }

    public void setTITULARIDADEVIABR(String str) {
        this.titularidadeviabr = str;
    }

    public String getENDERECOBR() {
        return this.enderecobr;
    }

    public void setENDERECOBR(String str) {
        this.enderecobr = str;
    }
}
