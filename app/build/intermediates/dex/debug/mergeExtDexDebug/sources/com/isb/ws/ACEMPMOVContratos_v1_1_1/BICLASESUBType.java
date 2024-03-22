package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_CLASE_SUB_Type", propOrder = {"bisubtipobien", "codigoalfanum"})
public class BICLASESUBType {
    @XmlElement(name = "BI_SUBTIPO_BIEN", required = true)
    protected BISUBTIPOBIENType bisubtipobien;
    @XmlElement(name = "CODIGO_ALFANUM", required = true)
    protected String codigoalfanum;

    public BISUBTIPOBIENType getBISUBTIPOBIEN() {
        return this.bisubtipobien;
    }

    public void setBISUBTIPOBIEN(BISUBTIPOBIENType bISUBTIPOBIENType) {
        this.bisubtipobien = bISUBTIPOBIENType;
    }

    public String getCODIGOALFANUM() {
        return this.codigoalfanum;
    }

    public void setCODIGOALFANUM(String str) {
        this.codigoalfanum = str;
    }
}
