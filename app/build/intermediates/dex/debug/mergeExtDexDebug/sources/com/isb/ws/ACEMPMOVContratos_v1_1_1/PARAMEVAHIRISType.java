package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_EV_AHIRIS_Type", propOrder = {"eventoahiris", "codacronimopadre", "codacronimopadredato"})
public class PARAMEVAHIRISType {
    @XmlElement(name = "COD_ACRONIMO_PADRE", required = true)
    protected String codacronimopadre;
    @XmlElement(name = "COD_ACRONIMO_PADRE_DATO", required = true)
    protected String codacronimopadredato;
    @XmlElement(name = "EVENTO_AHIRIS", required = true)
    protected EVENTOAHIRISType eventoahiris;

    public EVENTOAHIRISType getEVENTOAHIRIS() {
        return this.eventoahiris;
    }

    public void setEVENTOAHIRIS(EVENTOAHIRISType eVENTOAHIRISType) {
        this.eventoahiris = eVENTOAHIRISType;
    }

    public String getCODACRONIMOPADRE() {
        return this.codacronimopadre;
    }

    public void setCODACRONIMOPADRE(String str) {
        this.codacronimopadre = str;
    }

    public String getCODACRONIMOPADREDATO() {
        return this.codacronimopadredato;
    }

    public void setCODACRONIMOPADREDATO(String str) {
        this.codacronimopadredato = str;
    }
}
