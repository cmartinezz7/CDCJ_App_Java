package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARAM_EVENTO_AHCORE_Type", propOrder = {"eventoahcore", "codacronimopadre", "codacronimohijo"})
public class PARAMEVENTOAHCOREType {
    @XmlElement(name = "COD_ACRONIMO_HIJO", required = true)
    protected String codacronimohijo;
    @XmlElement(name = "COD_ACRONIMO_PADRE", required = true)
    protected String codacronimopadre;
    @XmlElement(name = "EVENTO_AHCORE", required = true)
    protected EVENTOAHCOREType eventoahcore;

    public EVENTOAHCOREType getEVENTOAHCORE() {
        return this.eventoahcore;
    }

    public void setEVENTOAHCORE(EVENTOAHCOREType eVENTOAHCOREType) {
        this.eventoahcore = eVENTOAHCOREType;
    }

    public String getCODACRONIMOPADRE() {
        return this.codacronimopadre;
    }

    public void setCODACRONIMOPADRE(String str) {
        this.codacronimopadre = str;
    }

    public String getCODACRONIMOHIJO() {
        return this.codacronimohijo;
    }

    public void setCODACRONIMOHIJO(String str) {
        this.codacronimohijo = str;
    }
}
