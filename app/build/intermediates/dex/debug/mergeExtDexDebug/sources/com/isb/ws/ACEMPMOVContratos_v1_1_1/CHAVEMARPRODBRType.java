package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHAVE_MAR_PROD_BR_Type", propOrder = {"productobr", "subproductobr", "bandeirabr", "tipocartaobr"})
public class CHAVEMARPRODBRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "BANDEIRA_BR")
    protected int bandeirabr;
    @XmlElement(name = "PRODUCTO_BR", required = true)
    protected String productobr;
    @XmlElement(name = "SUBPRODUCTO_BR", required = true)
    protected String subproductobr;
    @XmlElement(name = "TIPO_CARTAO_BR", required = true)
    protected String tipocartaobr;

    public String getPRODUCTOBR() {
        return this.productobr;
    }

    public void setPRODUCTOBR(String str) {
        this.productobr = str;
    }

    public String getSUBPRODUCTOBR() {
        return this.subproductobr;
    }

    public void setSUBPRODUCTOBR(String str) {
        this.subproductobr = str;
    }

    public int getBANDEIRABR() {
        return this.bandeirabr;
    }

    public void setBANDEIRABR(int i) {
        this.bandeirabr = i;
    }

    public String getTIPOCARTAOBR() {
        return this.tipocartaobr;
    }

    public void setTIPOCARTAOBR(String str) {
        this.tipocartaobr = str;
    }
}
