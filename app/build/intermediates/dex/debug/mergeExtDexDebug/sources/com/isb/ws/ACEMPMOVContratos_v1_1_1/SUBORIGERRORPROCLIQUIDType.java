package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBORIG_ERROR_PROC_LIQUID_Type", propOrder = {"origenerrorprocliquid", "codsuborigen"})
public class SUBORIGERRORPROCLIQUIDType {
    @XmlElement(name = "COD_SUBORIGEN", required = true)
    protected String codsuborigen;
    @XmlElement(name = "ORIGEN_ERROR_PROC_LIQUID", required = true)
    protected String origenerrorprocliquid;

    public String getORIGENERRORPROCLIQUID() {
        return this.origenerrorprocliquid;
    }

    public void setORIGENERRORPROCLIQUID(String str) {
        this.origenerrorprocliquid = str;
    }

    public String getCODSUBORIGEN() {
        return this.codsuborigen;
    }

    public void setCODSUBORIGEN(String str) {
        this.codsuborigen = str;
    }
}
