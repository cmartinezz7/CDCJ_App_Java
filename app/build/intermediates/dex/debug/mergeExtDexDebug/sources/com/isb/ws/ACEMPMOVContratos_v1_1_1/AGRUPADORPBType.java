package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AGRUPADOR_PB_Type", propOrder = {"subtipodeproducto", "codagrupacoperacion"})
public class AGRUPADORPBType {
    @XmlElement(name = "COD_AGRUPAC_OPERACION", required = true)
    protected String codagrupacoperacion;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODAGRUPACOPERACION() {
        return this.codagrupacoperacion;
    }

    public void setCODAGRUPACOPERACION(String str) {
        this.codagrupacoperacion = str;
    }
}
