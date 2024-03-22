package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_CONTRATO_UK_Type", propOrder = {"sortcodecontrato", "surcode1", "surcode2"})
public class LOCALIZADORCONTRATOUKType {
    @XmlElement(name = "SORTCODE_CONTRATO", required = true)
    protected LOCALIZADORType sortcodecontrato;
    @XmlElement(name = "SURCODE_1", required = true)
    protected String surcode1;
    @XmlElement(name = "SURCODE_2", required = true)
    protected String surcode2;

    public LOCALIZADORType getSORTCODECONTRATO() {
        return this.sortcodecontrato;
    }

    public void setSORTCODECONTRATO(LOCALIZADORType lOCALIZADORType) {
        this.sortcodecontrato = lOCALIZADORType;
    }

    public String getSURCODE1() {
        return this.surcode1;
    }

    public void setSURCODE1(String str) {
        this.surcode1 = str;
    }

    public String getSURCODE2() {
        return this.surcode2;
    }

    public void setSURCODE2(String str) {
        this.surcode2 = str;
    }
}
