package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAXONOMIA_BR_Type", propOrder = {"origen", "familia", "subfamilia"})
public class TAXONOMIABRType {
    @XmlElement(name = "FAMILIA", required = true)
    protected String familia;
    @XmlElement(name = "ORIGEN", required = true)
    protected String origen;
    @XmlElement(name = "SUBFAMILIA", required = true)
    protected String subfamilia;

    public String getORIGEN() {
        return this.origen;
    }

    public void setORIGEN(String str) {
        this.origen = str;
    }

    public String getFAMILIA() {
        return this.familia;
    }

    public void setFAMILIA(String str) {
        this.familia = str;
    }

    public String getSUBFAMILIA() {
        return this.subfamilia;
    }

    public void setSUBFAMILIA(String str) {
        this.subfamilia = str;
    }
}
