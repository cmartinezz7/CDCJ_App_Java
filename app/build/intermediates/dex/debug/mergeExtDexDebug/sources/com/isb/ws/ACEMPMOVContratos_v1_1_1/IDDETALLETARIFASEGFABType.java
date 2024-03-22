package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_DETALLE_TARIFA_SEG_FAB_Type", propOrder = {"companiadeseguros", "codigodetalletarifa"})
public class IDDETALLETARIFASEGFABType {
    @XmlElement(name = "CODIGO_DETALLE_TARIFA", required = true)
    protected String codigodetalletarifa;
    @XmlElement(name = "COMPANIA_DE_SEGUROS", required = true)
    protected String companiadeseguros;

    public String getCOMPANIADESEGUROS() {
        return this.companiadeseguros;
    }

    public void setCOMPANIADESEGUROS(String str) {
        this.companiadeseguros = str;
    }

    public String getCODIGODETALLETARIFA() {
        return this.codigodetalletarifa;
    }

    public void setCODIGODETALLETARIFA(String str) {
        this.codigodetalletarifa = str;
    }
}
