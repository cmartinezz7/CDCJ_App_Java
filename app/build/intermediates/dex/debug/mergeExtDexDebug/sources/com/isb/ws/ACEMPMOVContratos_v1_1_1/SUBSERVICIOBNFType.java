package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBSERVICIO_BNF_Type", propOrder = {"codtipservicio", "codsubservicio"})
public class SUBSERVICIOBNFType {
    @XmlElement(name = "COD_SUBSERVICIO", required = true)
    protected String codsubservicio;
    @XmlElement(name = "COD_TIP_SERVICIO", required = true)
    protected TIPOSERVICIOBNFType codtipservicio;

    public TIPOSERVICIOBNFType getCODTIPSERVICIO() {
        return this.codtipservicio;
    }

    public void setCODTIPSERVICIO(TIPOSERVICIOBNFType tIPOSERVICIOBNFType) {
        this.codtipservicio = tIPOSERVICIOBNFType;
    }

    public String getCODSUBSERVICIO() {
        return this.codsubservicio;
    }

    public void setCODSUBSERVICIO(String str) {
        this.codsubservicio = str;
    }
}
