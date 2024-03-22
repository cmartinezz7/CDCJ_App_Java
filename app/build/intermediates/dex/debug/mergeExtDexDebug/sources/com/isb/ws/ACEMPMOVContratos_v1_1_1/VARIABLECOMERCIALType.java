package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VARIABLE_COMERCIAL_Type", propOrder = {"codigovariablecomercial", "valorvariablecomercial"})
public class VARIABLECOMERCIALType {
    @XmlElement(name = "CODIGO_VARIABLE_COMERCIAL", required = true)
    protected String codigovariablecomercial;
    @XmlElement(name = "VALOR_VARIABLE_COMERCIAL", required = true)
    protected String valorvariablecomercial;

    public String getCODIGOVARIABLECOMERCIAL() {
        return this.codigovariablecomercial;
    }

    public void setCODIGOVARIABLECOMERCIAL(String str) {
        this.codigovariablecomercial = str;
    }

    public String getVALORVARIABLECOMERCIAL() {
        return this.valorvariablecomercial;
    }

    public void setVALORVARIABLECOMERCIAL(String str) {
        this.valorvariablecomercial = str;
    }
}
