package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_ASIENTO_OBB_Type", propOrder = {"obb", "asiento"})
public class MOBASIENTOOBBType {
    @XmlElement(name = "ASIENTO", required = true)
    protected String asiento;
    @XmlElement(name = "OBB", required = true)
    protected MOBOBBType obb;

    public MOBOBBType getOBB() {
        return this.obb;
    }

    public void setOBB(MOBOBBType mOBOBBType) {
        this.obb = mOBOBBType;
    }

    public String getASIENTO() {
        return this.asiento;
    }

    public void setASIENTO(String str) {
        this.asiento = str;
    }
}
