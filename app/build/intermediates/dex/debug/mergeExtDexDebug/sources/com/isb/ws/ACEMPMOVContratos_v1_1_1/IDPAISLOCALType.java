package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_PAIS_LOCAL_Type", propOrder = {"pais", "dgtiporg", "codicao"})
public class IDPAISLOCALType {
    @XmlElement(name = "CODICAO", required = true)
    protected String codicao;
    @XmlElement(name = "DGTIPORG", required = true)
    protected String dgtiporg;
    @XmlElement(name = "PAIS", required = true)
    protected String pais;

    public String getPAIS() {
        return this.pais;
    }

    public void setPAIS(String str) {
        this.pais = str;
    }

    public String getDGTIPORG() {
        return this.dgtiporg;
    }

    public void setDGTIPORG(String str) {
        this.dgtiporg = str;
    }

    public String getCODICAO() {
        return this.codicao;
    }

    public void setCODICAO(String str) {
        this.codicao = str;
    }
}
