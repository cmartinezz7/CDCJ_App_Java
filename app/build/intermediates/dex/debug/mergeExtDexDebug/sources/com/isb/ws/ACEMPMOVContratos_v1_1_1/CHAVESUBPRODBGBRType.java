package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_SUBPROD_BG_BR_Type", propOrder = {"codprodutobr", "subprodbgbr"})
public class CHAVESUBPRODBGBRType {
    @XmlElement(name = "COD_PRODUTO_BR", required = true)
    protected String codprodutobr;
    @XmlElement(name = "SUB_PROD_BG_BR", required = true)
    protected String subprodbgbr;

    public String getCODPRODUTOBR() {
        return this.codprodutobr;
    }

    public void setCODPRODUTOBR(String str) {
        this.codprodutobr = str;
    }

    public String getSUBPRODBGBR() {
        return this.subprodbgbr;
    }

    public void setSUBPRODBGBR(String str) {
        this.subprodbgbr = str;
    }
}
