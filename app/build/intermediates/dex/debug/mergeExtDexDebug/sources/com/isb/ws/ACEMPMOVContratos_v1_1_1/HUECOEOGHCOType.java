package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HUECO_EOGHCO_Type", propOrder = {"operativaeoghco", "tipohuecoeoghco", "codhueco"})
public class HUECOEOGHCOType {
    @XmlElement(name = "COD_HUECO", required = true)
    protected String codhueco;
    @XmlElement(name = "OPERATIVA_EOGHCO", required = true)
    protected OPERATIVAEOGHCOType operativaeoghco;
    @XmlElement(name = "TIPO_HUECO_EOGHCO", required = true)
    protected TIPOHUECOEOGHCOType tipohuecoeoghco;

    public OPERATIVAEOGHCOType getOPERATIVAEOGHCO() {
        return this.operativaeoghco;
    }

    public void setOPERATIVAEOGHCO(OPERATIVAEOGHCOType oPERATIVAEOGHCOType) {
        this.operativaeoghco = oPERATIVAEOGHCOType;
    }

    public TIPOHUECOEOGHCOType getTIPOHUECOEOGHCO() {
        return this.tipohuecoeoghco;
    }

    public void setTIPOHUECOEOGHCO(TIPOHUECOEOGHCOType tIPOHUECOEOGHCOType) {
        this.tipohuecoeoghco = tIPOHUECOEOGHCOType;
    }

    public String getCODHUECO() {
        return this.codhueco;
    }

    public void setCODHUECO(String str) {
        this.codhueco = str;
    }
}
