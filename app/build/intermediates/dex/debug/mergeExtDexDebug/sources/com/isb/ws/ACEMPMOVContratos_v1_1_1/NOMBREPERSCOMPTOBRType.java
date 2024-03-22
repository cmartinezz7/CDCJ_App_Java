package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NOMBRE_PERS_COMPTO_BR_Type", propOrder = {"nombrepersonabr", "primerappersonabr", "segundoappersonabr"})
public class NOMBREPERSCOMPTOBRType {
    @XmlElement(name = "NOMBRE_PERSONA_BR", required = true)
    protected String nombrepersonabr;
    @XmlElement(name = "PRIMER_AP_PERSONA_BR", required = true)
    protected String primerappersonabr;
    @XmlElement(name = "SEGUNDO_AP_PERSONA_BR", required = true)
    protected String segundoappersonabr;

    public String getNOMBREPERSONABR() {
        return this.nombrepersonabr;
    }

    public void setNOMBREPERSONABR(String str) {
        this.nombrepersonabr = str;
    }

    public String getPRIMERAPPERSONABR() {
        return this.primerappersonabr;
    }

    public void setPRIMERAPPERSONABR(String str) {
        this.primerappersonabr = str;
    }

    public String getSEGUNDOAPPERSONABR() {
        return this.segundoappersonabr;
    }

    public void setSEGUNDOAPPERSONABR(String str) {
        this.segundoappersonabr = str;
    }
}
