package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_COMPANIA_Type", propOrder = {"bitipocompania", "codcompania"})
public class BICOMPANIAType {
    @XmlElement(name = "BI_TIPO_COMPANIA", required = true)
    protected String bitipocompania;
    @XmlElement(name = "COD_COMPANIA", required = true)
    protected String codcompania;

    public String getBITIPOCOMPANIA() {
        return this.bitipocompania;
    }

    public void setBITIPOCOMPANIA(String str) {
        this.bitipocompania = str;
    }

    public String getCODCOMPANIA() {
        return this.codcompania;
    }

    public void setCODCOMPANIA(String str) {
        this.codcompania = str;
    }
}
