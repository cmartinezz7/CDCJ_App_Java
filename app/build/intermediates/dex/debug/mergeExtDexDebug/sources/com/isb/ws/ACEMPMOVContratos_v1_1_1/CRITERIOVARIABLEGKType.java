package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRITERIO_VARIABLE_GK_Type", propOrder = {"criteriogk", "codvariable"})
public class CRITERIOVARIABLEGKType {
    @XmlElement(name = "COD_VARIABLE", required = true)
    protected String codvariable;
    @XmlElement(name = "CRITERIO_GK", required = true)
    protected CRITERIOGKType criteriogk;

    public CRITERIOGKType getCRITERIOGK() {
        return this.criteriogk;
    }

    public void setCRITERIOGK(CRITERIOGKType cRITERIOGKType) {
        this.criteriogk = cRITERIOGKType;
    }

    public String getCODVARIABLE() {
        return this.codvariable;
    }

    public void setCODVARIABLE(String str) {
        this.codvariable = str;
    }
}
