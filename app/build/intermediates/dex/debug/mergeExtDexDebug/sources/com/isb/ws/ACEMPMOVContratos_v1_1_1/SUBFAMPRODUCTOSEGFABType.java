package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBFAM_PRODUCTO_SEG_FAB_Type", propOrder = {"familiadeproducto", "subfamiliadeproducto"})
public class SUBFAMPRODUCTOSEGFABType {
    @XmlElement(name = "FAMILIA_DE_PRODUCTO", required = true)
    protected String familiadeproducto;
    @XmlElement(name = "SUBFAMILIA_DE_PRODUCTO", required = true)
    protected String subfamiliadeproducto;

    public String getFAMILIADEPRODUCTO() {
        return this.familiadeproducto;
    }

    public void setFAMILIADEPRODUCTO(String str) {
        this.familiadeproducto = str;
    }

    public String getSUBFAMILIADEPRODUCTO() {
        return this.subfamiliadeproducto;
    }

    public void setSUBFAMILIADEPRODUCTO(String str) {
        this.subfamiliadeproducto = str;
    }
}
