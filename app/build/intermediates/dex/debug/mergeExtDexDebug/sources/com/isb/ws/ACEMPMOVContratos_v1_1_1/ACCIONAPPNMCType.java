package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCION_APPNMC_Type", propOrder = {"tareaappnmc", "codaccionnmc"})
public class ACCIONAPPNMCType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ACCION_NMC")
    protected int codaccionnmc;
    @XmlElement(name = "TAREA_APPNMC", required = true)
    protected TAREAAPPNMCType tareaappnmc;

    public TAREAAPPNMCType getTAREAAPPNMC() {
        return this.tareaappnmc;
    }

    public void setTAREAAPPNMC(TAREAAPPNMCType tAREAAPPNMCType) {
        this.tareaappnmc = tAREAAPPNMCType;
    }

    public int getCODACCIONNMC() {
        return this.codaccionnmc;
    }

    public void setCODACCIONNMC(int i) {
        this.codaccionnmc = i;
    }
}
