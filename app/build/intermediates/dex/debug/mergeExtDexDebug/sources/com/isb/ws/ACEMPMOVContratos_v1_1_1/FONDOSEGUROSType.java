package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FONDO_SEGUROS_Type", propOrder = {"companiadeseguros", "codfondo"})
public class FONDOSEGUROSType {
    @XmlElement(name = "COD_FONDO", required = true)
    protected String codfondo;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODFONDO() {
        return this.codfondo;
    }

    public void setCODFONDO(String str) {
        this.codfondo = str;
    }
}
