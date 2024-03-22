package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BLOQUE_FUNCIONAL_EOGHCO_Type", propOrder = {"aplicacioneoghco", "codbloque"})
public class BLOQUEFUNCIONALEOGHCOType {
    @XmlElement(name = "APLICACION_EOGHCO", required = true)
    protected APLICACIONEOGHCOType aplicacioneoghco;
    @XmlElement(name = "COD_BLOQUE", required = true)
    protected String codbloque;

    public APLICACIONEOGHCOType getAPLICACIONEOGHCO() {
        return this.aplicacioneoghco;
    }

    public void setAPLICACIONEOGHCO(APLICACIONEOGHCOType aPLICACIONEOGHCOType) {
        this.aplicacioneoghco = aPLICACIONEOGHCOType;
    }

    public String getCODBLOQUE() {
        return this.codbloque;
    }

    public void setCODBLOQUE(String str) {
        this.codbloque = str;
    }
}
