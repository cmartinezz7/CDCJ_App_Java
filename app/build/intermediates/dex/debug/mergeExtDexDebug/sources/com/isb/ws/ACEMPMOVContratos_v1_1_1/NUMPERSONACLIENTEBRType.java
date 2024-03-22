package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_PERSONA_CLIENTE_BR_Type", propOrder = {"tipodepersonabr", "nrodepersonabr"})
public class NUMPERSONACLIENTEBRType {
    @XmlElement(name = "NRO_DE_PERSONA_BR", required = true)
    protected String nrodepersonabr;
    @XmlElement(name = "TIPO_DE_PERSONA_BR", required = true)
    protected String tipodepersonabr;

    public String getTIPODEPERSONABR() {
        return this.tipodepersonabr;
    }

    public void setTIPODEPERSONABR(String str) {
        this.tipodepersonabr = str;
    }

    public String getNRODEPERSONABR() {
        return this.nrodepersonabr;
    }

    public void setNRODEPERSONABR(String str) {
        this.nrodepersonabr = str;
    }
}
