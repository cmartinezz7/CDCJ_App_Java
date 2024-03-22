package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FAMILIA_PRODUCTO_Type", propOrder = {"clasefamilia", "codfamiliaproducto"})
public class FAMILIAPRODUCTOType {
    @XmlElement(name = "CLASE_FAMILIA", required = true)
    protected CLASEFAMILIAPRODUCTOType clasefamilia;
    @XmlElement(name = "COD_FAMILIA_PRODUCTO", required = true)
    protected String codfamiliaproducto;

    public CLASEFAMILIAPRODUCTOType getCLASEFAMILIA() {
        return this.clasefamilia;
    }

    public void setCLASEFAMILIA(CLASEFAMILIAPRODUCTOType cLASEFAMILIAPRODUCTOType) {
        this.clasefamilia = cLASEFAMILIAPRODUCTOType;
    }

    public String getCODFAMILIAPRODUCTO() {
        return this.codfamiliaproducto;
    }

    public void setCODFAMILIAPRODUCTO(String str) {
        this.codfamiliaproducto = str;
    }
}
