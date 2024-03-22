package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_REPRESENTANTE_APOD_Type", propOrder = {"empresa", "codgruporepresentante"})
public class GRUPOREPRESENTANTEAPODType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_GRUPO_REPRESENTANTE")
    protected int codgruporepresentante;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODGRUPOREPRESENTANTE() {
        return this.codgruporepresentante;
    }

    public void setCODGRUPOREPRESENTANTE(int i) {
        this.codgruporepresentante = i;
    }
}
