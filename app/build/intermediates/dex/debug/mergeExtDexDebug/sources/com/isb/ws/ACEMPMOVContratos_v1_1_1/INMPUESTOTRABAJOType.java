package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_PUESTO_TRABAJO_Type", propOrder = {"inmzona", "codpuesto"})
public class INMPUESTOTRABAJOType {
    @XmlElement(name = "COD_PUESTO", required = true)
    protected String codpuesto;
    @XmlElement(name = "INM_ZONA", required = true)
    protected INMZONAType inmzona;

    public INMZONAType getINMZONA() {
        return this.inmzona;
    }

    public void setINMZONA(INMZONAType iNMZONAType) {
        this.inmzona = iNMZONAType;
    }

    public String getCODPUESTO() {
        return this.codpuesto;
    }

    public void setCODPUESTO(String str) {
        this.codpuesto = str;
    }
}
