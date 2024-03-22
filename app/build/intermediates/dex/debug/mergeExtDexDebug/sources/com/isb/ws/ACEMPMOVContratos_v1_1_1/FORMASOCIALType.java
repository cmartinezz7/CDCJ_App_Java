package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMA_SOCIAL_Type", propOrder = {"pais", "codformasocial"})
public class FORMASOCIALType {
    @XmlElement(name = "COD_FORMA_SOCIAL", required = true)
    protected String codformasocial;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

    public String getCODFORMASOCIAL() {
        return this.codformasocial;
    }

    public void setCODFORMASOCIAL(String str) {
        this.codformasocial = str;
    }
}
