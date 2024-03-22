package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROFESION_RIESGO_SEG_DIST_Type", propOrder = {"codcompania", "codprofesriesgo"})
public class PROFESIONRIESGOSEGDISTType {
    @XmlElement(name = "COD_COMPANIA", required = true)
    protected String codcompania;
    @XmlElement(name = "COD_PROFES_RIESGO", required = true)
    protected String codprofesriesgo;

    public String getCODCOMPANIA() {
        return this.codcompania;
    }

    public void setCODCOMPANIA(String str) {
        this.codcompania = str;
    }

    public String getCODPROFESRIESGO() {
        return this.codprofesriesgo;
    }

    public void setCODPROFESRIESGO(String str) {
        this.codprofesriesgo = str;
    }
}
