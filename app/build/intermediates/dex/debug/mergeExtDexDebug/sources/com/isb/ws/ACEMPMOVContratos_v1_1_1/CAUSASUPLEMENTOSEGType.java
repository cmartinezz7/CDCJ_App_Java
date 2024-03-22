package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CAUSA_SUPLEMENTO_SEG_Type", propOrder = {"companiadeseguros", "causadesuplemento"})
public class CAUSASUPLEMENTOSEGType {
    @XmlElement(name = "CAUSA_DE_SUPLEMENTO", required = true)
    protected String causadesuplemento;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCAUSADESUPLEMENTO() {
        return this.causadesuplemento;
    }

    public void setCAUSADESUPLEMENTO(String str) {
        this.causadesuplemento = str;
    }
}
