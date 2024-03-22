package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLASE_DE_BIEN_Type", propOrder = {"tipobien", "clasebien"})
public class CLASEDEBIENType {
    @XmlElement(name = "CLASE_BIEN", required = true)
    protected String clasebien;
    @XmlElement(name = "TIPO_BIEN", required = true)
    protected String tipobien;

    public String getTIPOBIEN() {
        return this.tipobien;
    }

    public void setTIPOBIEN(String str) {
        this.tipobien = str;
    }

    public String getCLASEBIEN() {
        return this.clasebien;
    }

    public void setCLASEBIEN(String str) {
        this.clasebien = str;
    }
}
