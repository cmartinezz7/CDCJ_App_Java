package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_CARGO_GRPRGR_Type", propOrder = {"tipocargogrprgr", "codsubtipocargo"})
public class SUBTIPOCARGOGRPRGRType {
    @XmlElement(name = "COD_SUBTIPO_CARGO", required = true)
    protected String codsubtipocargo;
    @XmlElement(name = "TIPO_CARGO_GRPRGR", required = true)
    protected String tipocargogrprgr;

    public String getTIPOCARGOGRPRGR() {
        return this.tipocargogrprgr;
    }

    public void setTIPOCARGOGRPRGR(String str) {
        this.tipocargogrprgr = str;
    }

    public String getCODSUBTIPOCARGO() {
        return this.codsubtipocargo;
    }

    public void setCODSUBTIPOCARGO(String str) {
        this.codsubtipocargo = str;
    }
}
