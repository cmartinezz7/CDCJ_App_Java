package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ACCION_MASIVA_DP_Type", propOrder = {"empresa", "codaccionmasiva"})
public class IDACCIONMASIVADPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ACCION_MASIVA")
    protected int codaccionmasiva;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODACCIONMASIVA() {
        return this.codaccionmasiva;
    }

    public void setCODACCIONMASIVA(int i) {
        this.codaccionmasiva = i;
    }
}
