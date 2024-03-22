package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOPORTE_RECIBIDO_FACTOR_Type", propOrder = {"empresa", "codsoporte"})
public class SOPORTERECIBIDOFACTORType {
    @XmlElement(name = "COD_SOPORTE", required = true)
    protected String codsoporte;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODSOPORTE() {
        return this.codsoporte;
    }

    public void setCODSOPORTE(String str) {
        this.codsoporte = str;
    }
}
