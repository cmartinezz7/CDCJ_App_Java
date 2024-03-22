package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMATO_EXTRACTO_PCAS_Type", propOrder = {"empresa", "codformato"})
public class FORMATOEXTRACTOPCASType {
    @XmlElement(name = "COD_FORMATO", required = true)
    protected String codformato;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODFORMATO() {
        return this.codformato;
    }

    public void setCODFORMATO(String str) {
        this.codformato = str;
    }
}
