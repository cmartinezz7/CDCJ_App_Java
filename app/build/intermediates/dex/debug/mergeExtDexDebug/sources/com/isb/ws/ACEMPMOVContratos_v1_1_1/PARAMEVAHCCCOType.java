package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_EV_AHCCCO_Type", propOrder = {"eventoahccco", "coddaudi"})
public class PARAMEVAHCCCOType {
    @XmlElement(name = "COD_DAUDI", required = true)
    protected String coddaudi;
    @XmlElement(name = "EVENTO_AHCCCO", required = true)
    protected EVENTOAHCCCOType eventoahccco;

    public EVENTOAHCCCOType getEVENTOAHCCCO() {
        return this.eventoahccco;
    }

    public void setEVENTOAHCCCO(EVENTOAHCCCOType eVENTOAHCCCOType) {
        this.eventoahccco = eVENTOAHCCCOType;
    }

    public String getCODDAUDI() {
        return this.coddaudi;
    }

    public void setCODDAUDI(String str) {
        this.coddaudi = str;
    }
}
