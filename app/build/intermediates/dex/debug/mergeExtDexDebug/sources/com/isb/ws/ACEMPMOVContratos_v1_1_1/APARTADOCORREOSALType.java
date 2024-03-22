package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APARTADO_CORREOS_AL_Type", propOrder = {"pobnumber", "postalcode", "lander", "city", "pdeliverynote"})
public class APARTADOCORREOSALType {
    @XmlElement(name = "CITY", required = true)
    protected String city;
    @XmlElement(name = "LANDER", required = true)
    protected String lander;
    @XmlElement(name = "PDELIVERYNOTE", required = true)
    protected String pdeliverynote;
    @XmlElement(name = "POBNUMBER", required = true)
    protected String pobnumber;
    @XmlElement(name = "POSTALCODE", required = true)
    protected String postalcode;

    public String getPOBNUMBER() {
        return this.pobnumber;
    }

    public void setPOBNUMBER(String str) {
        this.pobnumber = str;
    }

    public String getPOSTALCODE() {
        return this.postalcode;
    }

    public void setPOSTALCODE(String str) {
        this.postalcode = str;
    }

    public String getLANDER() {
        return this.lander;
    }

    public void setLANDER(String str) {
        this.lander = str;
    }

    public String getCITY() {
        return this.city;
    }

    public void setCITY(String str) {
        this.city = str;
    }

    public String getPDELIVERYNOTE() {
        return this.pdeliverynote;
    }

    public void setPDELIVERYNOTE(String str) {
        this.pdeliverynote = str;
    }
}
