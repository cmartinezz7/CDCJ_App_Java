package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_EVENTO_AHATSO_Type", propOrder = {"eventoahatso", "codacronimodato"})
public class PARAMEVENTOAHATSOType {
    @XmlElement(name = "COD_ACRONIMO_DATO", required = true)
    protected String codacronimodato;
    @XmlElement(name = "EVENTO_AHATSO", required = true)
    protected EVENTOAHATSOType eventoahatso;

    public EVENTOAHATSOType getEVENTOAHATSO() {
        return this.eventoahatso;
    }

    public void setEVENTOAHATSO(EVENTOAHATSOType eVENTOAHATSOType) {
        this.eventoahatso = eVENTOAHATSOType;
    }

    public String getCODACRONIMODATO() {
        return this.codacronimodato;
    }

    public void setCODACRONIMODATO(String str) {
        this.codacronimodato = str;
    }
}
