package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_ALEMAN_Type", propOrder = {"street", "housenumber", "postalcode", "lander", "city", "pdeliverynote"})
public class DOMICILIOALEMANType {
    @XmlElement(name = "CITY", required = true)
    protected String city;
    @XmlElement(name = "HOUSENUMBER", required = true)
    protected String housenumber;
    @XmlElement(name = "LANDER", required = true)
    protected String lander;
    @XmlElement(name = "PDELIVERYNOTE", required = true)
    protected String pdeliverynote;
    @XmlElement(name = "POSTALCODE", required = true)
    protected String postalcode;
    @XmlElement(name = "STREET", required = true)
    protected String street;

    public String getSTREET() {
        return this.street;
    }

    public void setSTREET(String str) {
        this.street = str;
    }

    public String getHOUSENUMBER() {
        return this.housenumber;
    }

    public void setHOUSENUMBER(String str) {
        this.housenumber = str;
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
