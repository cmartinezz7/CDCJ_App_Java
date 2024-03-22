package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMPT_BASICOS_2_BR_Type", propOrder = {"pecanven", "pecancap", "pepaiori", "pecodcam"})
public class COMPTBASICOS2BRType {
    @XmlElement(name = "PECANCAP", required = true)
    protected String pecancap;
    @XmlElement(name = "PECANVEN", required = true)
    protected String pecanven;
    @XmlElement(name = "PECODCAM", required = true)
    protected String pecodcam;
    @XmlElement(name = "PEPAIORI", required = true)
    protected String pepaiori;

    public String getPECANVEN() {
        return this.pecanven;
    }

    public void setPECANVEN(String str) {
        this.pecanven = str;
    }

    public String getPECANCAP() {
        return this.pecancap;
    }

    public void setPECANCAP(String str) {
        this.pecancap = str;
    }

    public String getPEPAIORI() {
        return this.pepaiori;
    }

    public void setPEPAIORI(String str) {
        this.pepaiori = str;
    }

    public String getPECODCAM() {
        return this.pecodcam;
    }

    public void setPECODCAM(String str) {
        this.pecodcam = str;
    }
}
