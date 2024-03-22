package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_DE_NEGOCIO_PB_Type", propOrder = {"subtipodeproducto", "codoperacionnegocio"})
public class OPERACIONDENEGOCIOPBType {
    @XmlElement(name = "COD_OPERACION_NEGOCIO", required = true)
    protected String codoperacionnegocio;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODOPERACIONNEGOCIO() {
        return this.codoperacionnegocio;
    }

    public void setCODOPERACIONNEGOCIO(String str) {
        this.codoperacionnegocio = str;
    }
}
