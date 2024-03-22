package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_BANCO_ESPANA_Type", propOrder = {"empresa", "serie", "numerodecheque"})
public class CHEQUEBANCOESPANAType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUMERO_DE_CHEQUE", required = true)
    protected String numerodecheque;
    @XmlElement(name = "SERIE", required = true)
    protected String serie;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSERIE() {
        return this.serie;
    }

    public void setSERIE(String str) {
        this.serie = str;
    }

    public String getNUMERODECHEQUE() {
        return this.numerodecheque;
    }

    public void setNUMERODECHEQUE(String str) {
        this.numerodecheque = str;
    }
}
