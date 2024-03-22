package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBFAMILIA_PRODUCTO_Type", propOrder = {"familiaproducto", "codsubfamiliaproducto"})
public class SUBFAMILIAPRODUCTOType {
    @XmlElement(name = "COD_SUBFAMILIA_PRODUCTO", required = true)
    protected String codsubfamiliaproducto;
    @XmlElement(name = "FAMILIA_PRODUCTO", required = true)
    protected FAMILIAPRODUCTOType familiaproducto;

    public FAMILIAPRODUCTOType getFAMILIAPRODUCTO() {
        return this.familiaproducto;
    }

    public void setFAMILIAPRODUCTO(FAMILIAPRODUCTOType fAMILIAPRODUCTOType) {
        this.familiaproducto = fAMILIAPRODUCTOType;
    }

    public String getCODSUBFAMILIAPRODUCTO() {
        return this.codsubfamiliaproducto;
    }

    public void setCODSUBFAMILIAPRODUCTO(String str) {
        this.codsubfamiliaproducto = str;
    }
}
