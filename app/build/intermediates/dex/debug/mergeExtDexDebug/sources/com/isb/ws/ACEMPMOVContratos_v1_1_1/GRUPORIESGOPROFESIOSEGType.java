package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_RIESGO_PROFESIO_SEG_Type", propOrder = {"companiadeseguros", "codgruporiesgoprofesio"})
public class GRUPORIESGOPROFESIOSEGType {
    @XmlElement(name = "COD_GRUPO_RIESGO_PROFESIO", required = true)
    protected String codgruporiesgoprofesio;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODGRUPORIESGOPROFESIO() {
        return this.codgruporiesgoprofesio;
    }

    public void setCODGRUPORIESGOPROFESIO(String str) {
        this.codgruporiesgoprofesio = str;
    }
}
