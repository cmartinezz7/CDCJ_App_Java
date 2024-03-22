package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COBERTURA_SEG_FAB_Type", propOrder = {"companiadeseguros", "codigocobertura"})
public class COBERTURASEGFABType {
    @XmlElement(name = "CODIGO_COBERTURA_", required = true)
    protected String codigocobertura;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGOCOBERTURA() {
        return this.codigocobertura;
    }

    public void setCODIGOCOBERTURA(String str) {
        this.codigocobertura = str;
    }
}
