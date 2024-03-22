package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAME_EVENTO_AHATSO_Type", propOrder = {"eventoahatso", "tipovisionahatso", "codacronimodato"})
public class PARAMEEVENTOAHATSOType {
    @XmlElement(name = "COD_ACRONIMO_DATO", required = true)
    protected String codacronimodato;
    @XmlElement(name = "EVENTO_AHATSO", required = true)
    protected EVENTOAHATSOType eventoahatso;
    @XmlElement(name = "TIPO_VISION_AHATSO", required = true)
    protected String tipovisionahatso;

    public EVENTOAHATSOType getEVENTOAHATSO() {
        return this.eventoahatso;
    }

    public void setEVENTOAHATSO(EVENTOAHATSOType eVENTOAHATSOType) {
        this.eventoahatso = eVENTOAHATSOType;
    }

    public String getTIPOVISIONAHATSO() {
        return this.tipovisionahatso;
    }

    public void setTIPOVISIONAHATSO(String str) {
        this.tipovisionahatso = str;
    }

    public String getCODACRONIMODATO() {
        return this.codacronimodato;
    }

    public void setCODACRONIMODATO(String str) {
        this.codacronimodato = str;
    }
}
