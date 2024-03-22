package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_AL_Type", propOrder = {"blzcode", "cuenta10"})
public class LOCALIZADORALType {
    @XmlElement(name = "BLZCODE", required = true)
    protected String blzcode;
    @XmlElement(name = "CUENTA10", required = true)
    protected String cuenta10;

    public String getBLZCODE() {
        return this.blzcode;
    }

    public void setBLZCODE(String str) {
        this.blzcode = str;
    }

    public String getCUENTA10() {
        return this.cuenta10;
    }

    public void setCUENTA10(String str) {
        this.cuenta10 = str;
    }
}
