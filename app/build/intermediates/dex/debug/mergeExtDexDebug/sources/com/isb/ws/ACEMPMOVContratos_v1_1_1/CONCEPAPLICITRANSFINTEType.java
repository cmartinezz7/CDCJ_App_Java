package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEP_APLICI_TRANSF_INTE_Type", propOrder = {"subtipodeproducto", "codigoaplicacion"})
public class CONCEPAPLICITRANSFINTEType {
    @XmlElement(name = "CODIGO_APLICACION", required = true)
    protected String codigoaplicacion;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODIGOAPLICACION() {
        return this.codigoaplicacion;
    }

    public void setCODIGOAPLICACION(String str) {
        this.codigoaplicacion = str;
    }
}
