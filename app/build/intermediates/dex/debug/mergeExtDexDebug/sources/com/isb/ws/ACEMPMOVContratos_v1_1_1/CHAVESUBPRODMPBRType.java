package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_SUBPROD_MP_BR_Type", propOrder = {"codprodutobr", "subprodmpbr"})
public class CHAVESUBPRODMPBRType {
    @XmlElement(name = "COD_PRODUTO_BR", required = true)
    protected String codprodutobr;
    @XmlElement(name = "SUB_PROD_MP_BR", required = true)
    protected String subprodmpbr;

    public String getCODPRODUTOBR() {
        return this.codprodutobr;
    }

    public void setCODPRODUTOBR(String str) {
        this.codprodutobr = str;
    }

    public String getSUBPRODMPBR() {
        return this.subprodmpbr;
    }

    public void setSUBPRODMPBR(String str) {
        this.subprodmpbr = str;
    }
}
