package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CLAUSULA_FABRICA_SEG_Type", propOrder = {"companiadeseguros", "codigoclausula"})
public class IDCLAUSULAFABRICASEGType {
    @XmlElement(name = "CODIGO_CLAUSULA", required = true)
    protected String codigoclausula;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGOCLAUSULA() {
        return this.codigoclausula;
    }

    public void setCODIGOCLAUSULA(String str) {
        this.codigoclausula = str;
    }
}
