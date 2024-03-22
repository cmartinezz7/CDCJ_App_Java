package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REF_EXTERNA_OV_Type", propOrder = {"tipooverrideov", "refexterna"})
public class REFEXTERNAOVType {
    @XmlElement(name = "REF_EXTERNA", required = true)
    protected String refexterna;
    @XmlElement(name = "TIPO_OVERRIDE_OV", required = true)
    protected String tipooverrideov;

    public String getTIPOOVERRIDEOV() {
        return this.tipooverrideov;
    }

    public void setTIPOOVERRIDEOV(String str) {
        this.tipooverrideov = str;
    }

    public String getREFEXTERNA() {
        return this.refexterna;
    }

    public void setREFEXTERNA(String str) {
        this.refexterna = str;
    }
}
