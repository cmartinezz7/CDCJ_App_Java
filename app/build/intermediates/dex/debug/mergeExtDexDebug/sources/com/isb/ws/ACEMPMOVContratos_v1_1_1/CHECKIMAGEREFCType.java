package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHECK_IMAGE_REF_C_Type", propOrder = {"checkimagereff", "checkimagerefr"})
public class CHECKIMAGEREFCType {
    @XmlElement(name = "CHECK_IMAGE_REF_F", required = true)
    protected String checkimagereff;
    @XmlElement(name = "CHECK_IMAGE_REF_R", required = true)
    protected String checkimagerefr;

    public String getCHECKIMAGEREFF() {
        return this.checkimagereff;
    }

    public void setCHECKIMAGEREFF(String str) {
        this.checkimagereff = str;
    }

    public String getCHECKIMAGEREFR() {
        return this.checkimagerefr;
    }

    public void setCHECKIMAGEREFR(String str) {
        this.checkimagerefr = str;
    }
}
