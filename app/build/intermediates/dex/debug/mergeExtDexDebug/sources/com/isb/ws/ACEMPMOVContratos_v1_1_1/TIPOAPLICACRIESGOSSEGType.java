package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_APLICAC_RIESGOS_SEG_Type", propOrder = {"companiadeseguros", "tipoaplicacioncondicion"})
public class TIPOAPLICACRIESGOSSEGType {
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;
    @XmlElement(name = "TIPO_APLICACION_CONDICION", required = true)
    protected String tipoaplicacioncondicion;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getTIPOAPLICACIONCONDICION() {
        return this.tipoaplicacioncondicion;
    }

    public void setTIPOAPLICACIONCONDICION(String str) {
        this.tipoaplicacioncondicion = str;
    }
}
