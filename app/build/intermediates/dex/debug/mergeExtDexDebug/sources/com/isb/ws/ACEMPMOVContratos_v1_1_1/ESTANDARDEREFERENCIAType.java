package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTANDAR_DE_REFERENCIA_Type", propOrder = {"subtipodeproducto", "codigodeestandar"})
public class ESTANDARDEREFERENCIAType {
    @XmlElement(name = "CODIGO_DE_ESTANDAR", required = true)
    protected String codigodeestandar;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODIGODEESTANDAR() {
        return this.codigodeestandar;
    }

    public void setCODIGODEESTANDAR(String str) {
        this.codigodeestandar = str;
    }
}
