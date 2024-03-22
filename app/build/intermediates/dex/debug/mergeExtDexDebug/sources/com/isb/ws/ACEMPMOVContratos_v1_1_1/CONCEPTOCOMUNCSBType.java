package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_COMUN_CSB_Type", propOrder = {"codconcepto", "codnormascsb"})
public class CONCEPTOCOMUNCSBType {
    @XmlElement(name = "COD_CONCEPTO", required = true)
    protected String codconcepto;
    @XmlElement(name = "COD_NORMAS_CSB", required = true)
    protected String codnormascsb;

    public String getCODCONCEPTO() {
        return this.codconcepto;
    }

    public void setCODCONCEPTO(String str) {
        this.codconcepto = str;
    }

    public String getCODNORMASCSB() {
        return this.codnormascsb;
    }

    public void setCODNORMASCSB(String str) {
        this.codnormascsb = str;
    }
}
