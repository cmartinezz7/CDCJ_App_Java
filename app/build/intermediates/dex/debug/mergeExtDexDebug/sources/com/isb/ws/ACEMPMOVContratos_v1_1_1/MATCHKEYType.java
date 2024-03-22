package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MATCHKEY_Type", propOrder = {"country", "town", "matchkpaf"})
public class MATCHKEYType {
    @XmlElement(name = "COUNTRY", required = true)
    protected String country;
    @XmlElement(name = "MATCHKPAF", required = true)
    protected String matchkpaf;
    @XmlElement(name = "TOWN", required = true)
    protected String town;

    public String getCOUNTRY() {
        return this.country;
    }

    public void setCOUNTRY(String str) {
        this.country = str;
    }

    public String getTOWN() {
        return this.town;
    }

    public void setTOWN(String str) {
        this.town = str;
    }

    public String getMATCHKPAF() {
        return this.matchkpaf;
    }

    public void setMATCHKPAF(String str) {
        this.matchkpaf = str;
    }
}
