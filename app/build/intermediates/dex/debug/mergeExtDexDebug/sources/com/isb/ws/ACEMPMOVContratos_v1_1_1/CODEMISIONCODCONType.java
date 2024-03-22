package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_EMISION_CODCON_Type", propOrder = {"codvalorinternocc", "codemisioncc"})
public class CODEMISIONCODCONType {
    @XmlElement(name = "COD_EMISION_CC", required = true)
    protected String codemisioncc;
    @XmlElement(name = "COD_VALOR_INTERNO_CC", required = true)
    protected String codvalorinternocc;

    public String getCODVALORINTERNOCC() {
        return this.codvalorinternocc;
    }

    public void setCODVALORINTERNOCC(String str) {
        this.codvalorinternocc = str;
    }

    public String getCODEMISIONCC() {
        return this.codemisioncc;
    }

    public void setCODEMISIONCC(String str) {
        this.codemisioncc = str;
    }
}
