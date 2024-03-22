package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_RIESGO_DEPORTE_SEG_Type", propOrder = {"companiadeseguros", "codgruporiesgodeportes"})
public class GRUPORIESGODEPORTESEGType {
    @XmlElement(name = "COD_GRUPO_RIESGO_DEPORTES", required = true)
    protected String codgruporiesgodeportes;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODGRUPORIESGODEPORTES() {
        return this.codgruporiesgodeportes;
    }

    public void setCODGRUPORIESGODEPORTES(String str) {
        this.codgruporiesgodeportes = str;
    }
}
