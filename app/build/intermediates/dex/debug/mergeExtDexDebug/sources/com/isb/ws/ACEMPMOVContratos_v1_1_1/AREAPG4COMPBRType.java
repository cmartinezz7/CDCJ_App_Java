package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG4_COMP_BR_Type", propOrder = {"areapg4", "indenvcomp"})
public class AREAPG4COMPBRType {
    @XmlElement(name = "AREAPG4", required = true)
    protected AREAPG4BRType areapg4;
    @XmlElement(name = "INDENVCOMP", required = true)
    protected String indenvcomp;

    public AREAPG4BRType getAREAPG4() {
        return this.areapg4;
    }

    public void setAREAPG4(AREAPG4BRType aREAPG4BRType) {
        this.areapg4 = aREAPG4BRType;
    }

    public String getINDENVCOMP() {
        return this.indenvcomp;
    }

    public void setINDENVCOMP(String str) {
        this.indenvcomp = str;
    }
}
