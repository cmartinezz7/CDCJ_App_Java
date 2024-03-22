package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_GOAL_CATEGORY_Type", propOrder = {"empresa", "codnum3"})
public class IDGOALCATEGORYType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_NUM_3")
    protected int codnum3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODNUM3() {
        return this.codnum3;
    }

    public void setCODNUM3(int i) {
        this.codnum3 = i;
    }
}
