package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CIRCUITO_GAP_Type", propOrder = {"codigocircuito", "empresa"})
public class CIRCUITOGAPType {
    @XmlElement(name = "CODIGO_CIRCUITO", required = true)
    protected String codigocircuito;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getCODIGOCIRCUITO() {
        return this.codigocircuito;
    }

    public void setCODIGOCIRCUITO(String str) {
        this.codigocircuito = str;
    }

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }
}
