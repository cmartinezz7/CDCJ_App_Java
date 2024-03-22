package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUBAPLIC_SIGEAL_SCC_Type", propOrder = {"subtipodeproducto", "codigodesubaplicacion"})
public class IDSUBAPLICSIGEALSCCType {
    @XmlElement(name = "CODIGO_DE_SUBAPLICACION", required = true)
    protected String codigodesubaplicacion;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODIGODESUBAPLICACION() {
        return this.codigodesubaplicacion;
    }

    public void setCODIGODESUBAPLICACION(String str) {
        this.codigodesubaplicacion = str;
    }
}
