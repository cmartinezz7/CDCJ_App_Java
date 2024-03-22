package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_SECTOR_GLOBAL_Type", propOrder = {"bmgtiposector", "idsectorglobal"})
public class BMGSECTORGLOBALType {
    @XmlElement(name = "BMG_TIPO_SECTOR", required = true)
    protected String bmgtiposector;
    @XmlElement(name = "ID_SECTOR_GLOBAL", required = true)
    protected String idsectorglobal;

    public String getBMGTIPOSECTOR() {
        return this.bmgtiposector;
    }

    public void setBMGTIPOSECTOR(String str) {
        this.bmgtiposector = str;
    }

    public String getIDSECTORGLOBAL() {
        return this.idsectorglobal;
    }

    public void setIDSECTORGLOBAL(String str) {
        this.idsectorglobal = str;
    }
}
