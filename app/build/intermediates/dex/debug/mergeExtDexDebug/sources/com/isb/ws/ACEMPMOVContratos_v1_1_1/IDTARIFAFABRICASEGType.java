package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TARIFA_FABRICA_SEG_Type", propOrder = {"companiadeseguros", "codigotarifa"})
public class IDTARIFAFABRICASEGType {
    @XmlElement(name = "CODIGO_TARIFA", required = true)
    protected String codigotarifa;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGOTARIFA() {
        return this.codigotarifa;
    }

    public void setCODIGOTARIFA(String str) {
        this.codigotarifa = str;
    }
}
