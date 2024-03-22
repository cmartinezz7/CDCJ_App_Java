package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPO_DATO_BONIS_BNF_Type", propOrder = {"tipodatobnf", "coddatooperbonis"})
public class TPODATOBONISBNFType {
    @XmlElement(name = "COD_DATO_OPER_BONIS", required = true)
    protected String coddatooperbonis;
    @XmlElement(name = "TIPO_DATO_BNF", required = true)
    protected TIPODATOBNFType tipodatobnf;

    public TIPODATOBNFType getTIPODATOBNF() {
        return this.tipodatobnf;
    }

    public void setTIPODATOBNF(TIPODATOBNFType tIPODATOBNFType) {
        this.tipodatobnf = tIPODATOBNFType;
    }

    public String getCODDATOOPERBONIS() {
        return this.coddatooperbonis;
    }

    public void setCODDATOOPERBONIS(String str) {
        this.coddatooperbonis = str;
    }
}
