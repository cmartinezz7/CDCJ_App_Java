package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUCESO_SEG_FAB_Type", propOrder = {"companiadeseguros", "codigosuceso"})
public class IDSUCESOSEGFABType {
    @XmlElement(name = "CODIGO_SUCESO", required = true)
    protected String codigosuceso;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGOSUCESO() {
        return this.codigosuceso;
    }

    public void setCODIGOSUCESO(String str) {
        this.codigosuceso = str;
    }
}
