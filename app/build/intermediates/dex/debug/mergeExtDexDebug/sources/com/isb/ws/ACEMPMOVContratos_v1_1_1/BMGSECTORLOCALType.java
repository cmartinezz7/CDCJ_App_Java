package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_SECTOR_LOCAL_Type", propOrder = {"empresa", "bmgtiposector", "idsectorglobal"})
public class BMGSECTORLOCALType {
    @XmlElement(name = "BMG_TIPO_SECTOR", required = true)
    protected String bmgtiposector;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ID_SECTOR_GLOBAL", required = true)
    protected String idsectorglobal;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

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
