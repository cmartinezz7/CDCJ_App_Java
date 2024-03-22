package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PUESTO_TRABAJO_Type", propOrder = {"empresa", "codpuesto"})
public class PUESTOTRABAJOType {
    @XmlElement(name = "COD_PUESTO", required = true)
    protected String codpuesto;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODPUESTO() {
        return this.codpuesto;
    }

    public void setCODPUESTO(String str) {
        this.codpuesto = str;
    }
}
