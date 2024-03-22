package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_CONDICION_RGO_SEG_Type", propOrder = {"companiadeseguros", "codigodecondicion"})
public class TIPOCONDICIONRGOSEGType {
    @XmlElement(name = "CODIGO_DE_CONDICION", required = true)
    protected String codigodecondicion;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGODECONDICION() {
        return this.codigodecondicion;
    }

    public void setCODIGODECONDICION(String str) {
        this.codigodecondicion = str;
    }
}
