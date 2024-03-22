package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPVAL_SIANCO_Type", propOrder = {"concepssaa", "codvalssaa"})
public class CONCEPVALSIANCOType {
    @XmlElement(name = "CODVAL_SSAA", required = true)
    protected String codvalssaa;
    @XmlElement(name = "CONCEP_SSAA", required = true)
    protected String concepssaa;

    public String getCONCEPSSAA() {
        return this.concepssaa;
    }

    public void setCONCEPSSAA(String str) {
        this.concepssaa = str;
    }

    public String getCODVALSSAA() {
        return this.codvalssaa;
    }

    public void setCODVALSSAA(String str) {
        this.codvalssaa = str;
    }
}
