package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_USA_Type", propOrder = {"abacode", "cuenta17"})
public class LOCALIZADORUSAType {
    @XmlElement(name = "ABACODE", required = true)
    protected String abacode;
    @XmlElement(name = "CUENTA_17", required = true)
    protected String cuenta17;

    public String getABACODE() {
        return this.abacode;
    }

    public void setABACODE(String str) {
        this.abacode = str;
    }

    public String getCUENTA17() {
        return this.cuenta17;
    }

    public void setCUENTA17(String str) {
        this.cuenta17 = str;
    }
}
