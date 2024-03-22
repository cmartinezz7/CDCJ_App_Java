package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CHEQUE_DIVISA_Type", propOrder = {"empresa", "numerochequedivisa"})
public class CHEQUEDIVISAType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUMERO_CHEQUE_DIVISA", required = true)
    protected String numerochequedivisa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getNUMEROCHEQUEDIVISA() {
        return this.numerochequedivisa;
    }

    public void setNUMEROCHEQUEDIVISA(String str) {
        this.numerochequedivisa = str;
    }
}
