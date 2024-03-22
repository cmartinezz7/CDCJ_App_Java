package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RAMAL_COMPTO_BR_Type", propOrder = {"ramal1", "ramal2", "ramal3", "ramal4"})
public class RAMALCOMPTOBRType {
    @XmlElement(name = "RAMAL_1", required = true)
    protected String ramal1;
    @XmlElement(name = "RAMAL_2", required = true)
    protected String ramal2;
    @XmlElement(name = "RAMAL_3", required = true)
    protected String ramal3;
    @XmlElement(name = "RAMAL_4", required = true)
    protected String ramal4;

    public String getRAMAL1() {
        return this.ramal1;
    }

    public void setRAMAL1(String str) {
        this.ramal1 = str;
    }

    public String getRAMAL2() {
        return this.ramal2;
    }

    public void setRAMAL2(String str) {
        this.ramal2 = str;
    }

    public String getRAMAL3() {
        return this.ramal3;
    }

    public void setRAMAL3(String str) {
        this.ramal3 = str;
    }

    public String getRAMAL4() {
        return this.ramal4;
    }

    public void setRAMAL4(String str) {
        this.ramal4 = str;
    }
}
