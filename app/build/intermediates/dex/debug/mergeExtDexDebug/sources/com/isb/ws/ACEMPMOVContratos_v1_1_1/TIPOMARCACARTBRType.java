package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MARCA_CART_BR_Type", propOrder = {"codbandeirabr", "tipocartaobr"})
public class TIPOMARCACARTBRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_BANDEIRA_BR")
    protected int codbandeirabr;
    @XmlElement(name = "TIPO_CARTAO_BR", required = true)
    protected String tipocartaobr;

    public int getCODBANDEIRABR() {
        return this.codbandeirabr;
    }

    public void setCODBANDEIRABR(int i) {
        this.codbandeirabr = i;
    }

    public String getTIPOCARTAOBR() {
        return this.tipocartaobr;
    }

    public void setTIPOCARTAOBR(String str) {
        this.tipocartaobr = str;
    }
}
