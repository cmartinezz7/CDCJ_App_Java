package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_EXT_PT_Type", propOrder = {"linea1", "linea2"})
public class DOMICILIOPRESENTEXTPTType {
    @XmlElement(name = "LINEA_1", required = true)
    protected String linea1;
    @XmlElement(name = "LINEA_2", required = true)
    protected String linea2;

    public String getLINEA1() {
        return this.linea1;
    }

    public void setLINEA1(String str) {
        this.linea1 = str;
    }

    public String getLINEA2() {
        return this.linea2;
    }

    public void setLINEA2(String str) {
        this.linea2 = str;
    }
}
