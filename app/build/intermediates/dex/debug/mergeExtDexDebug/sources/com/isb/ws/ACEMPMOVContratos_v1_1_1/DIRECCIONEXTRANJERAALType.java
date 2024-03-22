package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIRECCION_EXTRANJERA_AL_Type", propOrder = {"pais", "linea1", "linea2", "linea3", "pdeliverynote"})
public class DIRECCIONEXTRANJERAALType {
    @XmlElement(name = "LINEA1", required = true)
    protected String linea1;
    @XmlElement(name = "LINEA2", required = true)
    protected String linea2;
    @XmlElement(name = "LINEA3", required = true)
    protected String linea3;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;
    @XmlElement(name = "PDELIVERYNOTE", required = true)
    protected String pdeliverynote;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

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

    public String getLINEA3() {
        return this.linea3;
    }

    public void setLINEA3(String str) {
        this.linea3 = str;
    }

    public String getPDELIVERYNOTE() {
        return this.pdeliverynote;
    }

    public void setPDELIVERYNOTE(String str) {
        this.pdeliverynote = str;
    }
}
