package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_HUECO_EOGHCO_Type", propOrder = {"aplicacioneoghco", "codtiphueco"})
public class TIPOHUECOEOGHCOType {
    @XmlElement(name = "APLICACION_EOGHCO", required = true)
    protected APLICACIONEOGHCOType aplicacioneoghco;
    @XmlElement(name = "COD_TIP_HUECO", required = true)
    protected String codtiphueco;

    public APLICACIONEOGHCOType getAPLICACIONEOGHCO() {
        return this.aplicacioneoghco;
    }

    public void setAPLICACIONEOGHCO(APLICACIONEOGHCOType aPLICACIONEOGHCOType) {
        this.aplicacioneoghco = aPLICACIONEOGHCOType;
    }

    public String getCODTIPHUECO() {
        return this.codtiphueco;
    }

    public void setCODTIPHUECO(String str) {
        this.codtiphueco = str;
    }
}
