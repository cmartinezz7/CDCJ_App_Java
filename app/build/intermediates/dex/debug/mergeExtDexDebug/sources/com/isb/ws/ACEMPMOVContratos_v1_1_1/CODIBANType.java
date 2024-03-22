package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIBAN_Type", propOrder = {"pais", "digitodecontrol", "codbban"})
public class CODIBANType {
    @XmlElement(name = "CODBBAN", required = true)
    protected String codbban;
    @XmlElement(name = "DIGITO_DE_CONTROL", required = true)
    protected String digitodecontrol;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

    public String getDIGITODECONTROL() {
        return this.digitodecontrol;
    }

    public void setDIGITODECONTROL(String str) {
        this.digitodecontrol = str;
    }

    public String getCODBBAN() {
        return this.codbban;
    }

    public void setCODBBAN(String str) {
        this.codbban = str;
    }
}
