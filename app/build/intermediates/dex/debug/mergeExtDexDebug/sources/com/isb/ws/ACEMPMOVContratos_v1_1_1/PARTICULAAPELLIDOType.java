package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARTICULA_APELLIDO_Type", propOrder = {"particula", "apellido"})
public class PARTICULAAPELLIDOType {
    @XmlElement(name = "APELLIDO", required = true)
    protected String apellido;
    @XmlElement(name = "PARTICULA", required = true)
    protected String particula;

    public String getPARTICULA() {
        return this.particula;
    }

    public void setPARTICULA(String str) {
        this.particula = str;
    }

    public String getAPELLIDO() {
        return this.apellido;
    }

    public void setAPELLIDO(String str) {
        this.apellido = str;
    }
}
