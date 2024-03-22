package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMP_PRESENTACION_EOGHCO_Type", propOrder = {"aplicacioneoghco", "codcomponente"})
public class COMPPRESENTACIONEOGHCOType {
    @XmlElement(name = "APLICACION_EOGHCO", required = true)
    protected APLICACIONEOGHCOType aplicacioneoghco;
    @XmlElement(name = "COD_COMPONENTE", required = true)
    protected String codcomponente;

    public APLICACIONEOGHCOType getAPLICACIONEOGHCO() {
        return this.aplicacioneoghco;
    }

    public void setAPLICACIONEOGHCO(APLICACIONEOGHCOType aPLICACIONEOGHCOType) {
        this.aplicacioneoghco = aPLICACIONEOGHCOType;
    }

    public String getCODCOMPONENTE() {
        return this.codcomponente;
    }

    public void setCODCOMPONENTE(String str) {
        this.codcomponente = str;
    }
}
