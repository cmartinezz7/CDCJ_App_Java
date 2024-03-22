package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_CONCEPTO_OBB_Type", propOrder = {"obb", "concepto"})
public class MOBCONCEPTOOBBType {
    @XmlElement(name = "CONCEPTO", required = true)
    protected String concepto;
    @XmlElement(name = "OBB", required = true)
    protected MOBOBBType obb;

    public MOBOBBType getOBB() {
        return this.obb;
    }

    public void setOBB(MOBOBBType mOBOBBType) {
        this.obb = mOBOBBType;
    }

    public String getCONCEPTO() {
        return this.concepto;
    }

    public void setCONCEPTO(String str) {
        this.concepto = str;
    }
}
