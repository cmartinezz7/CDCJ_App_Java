package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CARGO_GRPRGR_Type", propOrder = {"empresa", "codcargo"})
public class CARGOGRPRGRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_CARGO")
    protected long codcargo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODCARGO() {
        return this.codcargo;
    }

    public void setCODCARGO(long j) {
        this.codcargo = j;
    }
}
