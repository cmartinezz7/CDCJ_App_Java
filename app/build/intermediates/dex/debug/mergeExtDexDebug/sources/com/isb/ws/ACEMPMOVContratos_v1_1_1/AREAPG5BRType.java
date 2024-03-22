package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG5_BR_Type", propOrder = {"codlinx", "obslinx"})
public class AREAPG5BRType {
    @XmlElement(name = "CODLINX", required = true)
    protected String codlinx;
    @XmlElement(name = "OBSLINX", required = true)
    protected String obslinx;

    public String getCODLINX() {
        return this.codlinx;
    }

    public void setCODLINX(String str) {
        this.codlinx = str;
    }

    public String getOBSLINX() {
        return this.obslinx;
    }

    public void setOBSLINX(String str) {
        this.obslinx = str;
    }
}
