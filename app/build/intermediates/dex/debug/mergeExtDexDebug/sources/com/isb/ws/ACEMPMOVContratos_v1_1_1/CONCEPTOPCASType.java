package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_PCAS_Type", propOrder = {"empresa", "codconceptopcas", "valorconcepto"})
public class CONCEPTOPCASType {
    @XmlElement(name = "COD_CONCEPTO_PCAS", required = true)
    protected String codconceptopcas;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "VALOR_CONCEPTO", required = true)
    protected String valorconcepto;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODCONCEPTOPCAS() {
        return this.codconceptopcas;
    }

    public void setCODCONCEPTOPCAS(String str) {
        this.codconceptopcas = str;
    }

    public String getVALORCONCEPTO() {
        return this.valorconcepto;
    }

    public void setVALORCONCEPTO(String str) {
        this.valorconcepto = str;
    }
}
