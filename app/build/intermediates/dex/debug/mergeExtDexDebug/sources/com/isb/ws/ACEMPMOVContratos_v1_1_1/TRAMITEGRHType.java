package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAMITE_GRH_Type", propOrder = {"empresa", "codtramite"})
public class TRAMITEGRHType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_TRAMITE")
    protected long codtramite;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODTRAMITE() {
        return this.codtramite;
    }

    public void setCODTRAMITE(long j) {
        this.codtramite = j;
    }
}
