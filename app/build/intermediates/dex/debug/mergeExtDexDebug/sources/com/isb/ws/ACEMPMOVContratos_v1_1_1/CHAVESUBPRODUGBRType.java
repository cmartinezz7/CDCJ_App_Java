package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_SUBPROD_UG_BR_Type", propOrder = {"codprodutobr", "subprodugbr"})
public class CHAVESUBPRODUGBRType {
    @XmlElement(name = "COD_PRODUTO_BR", required = true)
    protected String codprodutobr;
    @XmlElement(name = "SUB_PROD_UG_BR", required = true)
    protected String subprodugbr;

    public String getCODPRODUTOBR() {
        return this.codprodutobr;
    }

    public void setCODPRODUTOBR(String str) {
        this.codprodutobr = str;
    }

    public String getSUBPRODUGBR() {
        return this.subprodugbr;
    }

    public void setSUBPRODUGBR(String str) {
        this.subprodugbr = str;
    }
}
