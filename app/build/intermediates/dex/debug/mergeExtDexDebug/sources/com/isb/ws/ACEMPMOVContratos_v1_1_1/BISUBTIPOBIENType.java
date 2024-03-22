package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_SUBTIPO_BIEN_Type", propOrder = {"bitipobien", "codsubtipobien"})
public class BISUBTIPOBIENType {
    @XmlElement(name = "BI_TIPO_BIEN", required = true)
    protected String bitipobien;
    @XmlElement(name = "COD_SUBTIPO_BIEN", required = true)
    protected String codsubtipobien;

    public String getBITIPOBIEN() {
        return this.bitipobien;
    }

    public void setBITIPOBIEN(String str) {
        this.bitipobien = str;
    }

    public String getCODSUBTIPOBIEN() {
        return this.codsubtipobien;
    }

    public void setCODSUBTIPOBIEN(String str) {
        this.codsubtipobien = str;
    }
}
