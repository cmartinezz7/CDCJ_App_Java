package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NOMBRE_ATRIB_PERSON_CONT_Type", propOrder = {"comp1", "comp2"})
public class NOMBREATRIBPERSONCONTType {
    @XmlElement(name = "COMP1", required = true)
    protected String comp1;
    @XmlElement(name = "COMP2", required = true)
    protected String comp2;

    public String getCOMP1() {
        return this.comp1;
    }

    public void setCOMP1(String str) {
        this.comp1 = str;
    }

    public String getCOMP2() {
        return this.comp2;
    }

    public void setCOMP2(String str) {
        this.comp2 = str;
    }
}
