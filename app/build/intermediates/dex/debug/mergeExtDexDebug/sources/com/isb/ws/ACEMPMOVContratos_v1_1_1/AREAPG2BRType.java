package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG2_BR_Type", propOrder = {"chvcanal", "numsuper", "pan"})
public class AREAPG2BRType {
    @XmlElement(name = "CHVCANAL", required = true)
    protected String chvcanal;
    @XmlElement(name = "NUMSUPER", required = true)
    protected String numsuper;
    @XmlElement(name = "PAN", required = true)
    protected String pan;

    public String getCHVCANAL() {
        return this.chvcanal;
    }

    public void setCHVCANAL(String str) {
        this.chvcanal = str;
    }

    public String getNUMSUPER() {
        return this.numsuper;
    }

    public void setNUMSUPER(String str) {
        this.numsuper = str;
    }

    public String getPAN() {
        return this.pan;
    }

    public void setPAN(String str) {
        this.pan = str;
    }
}
