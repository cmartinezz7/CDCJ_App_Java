package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_COND_ECON_BR_Type", propOrder = {"codprodutobr", "subproductobr", "vertentebr", "condicaoeconbr"})
public class CHAVECONDECONBRType {
    @XmlElement(name = "COD_PRODUTO_BR", required = true)
    protected String codprodutobr;
    @XmlElement(name = "CONDICAO_ECON_BR", required = true)
    protected String condicaoeconbr;
    @XmlElement(name = "SUBPRODUCTO_BR", required = true)
    protected String subproductobr;
    @XmlElement(name = "VERTENTE_BR", required = true)
    protected String vertentebr;

    public String getCODPRODUTOBR() {
        return this.codprodutobr;
    }

    public void setCODPRODUTOBR(String str) {
        this.codprodutobr = str;
    }

    public String getSUBPRODUCTOBR() {
        return this.subproductobr;
    }

    public void setSUBPRODUCTOBR(String str) {
        this.subproductobr = str;
    }

    public String getVERTENTEBR() {
        return this.vertentebr;
    }

    public void setVERTENTEBR(String str) {
        this.vertentebr = str;
    }

    public String getCONDICAOECONBR() {
        return this.condicaoeconbr;
    }

    public void setCONDICAOECONBR(String str) {
        this.condicaoeconbr = str;
    }
}
