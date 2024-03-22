package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FECHA_REFERENCIA_FACTOR_Type", propOrder = {"empresa", "tipfechafactor", "tipfechareffactor"})
public class FECHAREFERENCIAFACTORType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIP_FECHA_FACTOR", required = true)
    protected String tipfechafactor;
    @XmlElement(name = "TIP_FECHA_REF_FACTOR", required = true)
    protected String tipfechareffactor;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPFECHAFACTOR() {
        return this.tipfechafactor;
    }

    public void setTIPFECHAFACTOR(String str) {
        this.tipfechafactor = str;
    }

    public String getTIPFECHAREFFACTOR() {
        return this.tipfechareffactor;
    }

    public void setTIPFECHAREFFACTOR(String str) {
        this.tipfechareffactor = str;
    }
}
