package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAREA_APPNMC_Type", propOrder = {"procesodenegocio", "canal", "codtareanmc"})
public class TAREAAPPNMCType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "COD_TAREA_NMC", required = true)
    protected String codtareanmc;
    @XmlElement(name = "PROCESO_DE_NEGOCIO", required = true)
    protected PROCESODENEGOCIOType procesodenegocio;

    public PROCESODENEGOCIOType getPROCESODENEGOCIO() {
        return this.procesodenegocio;
    }

    public void setPROCESODENEGOCIO(PROCESODENEGOCIOType pROCESODENEGOCIOType) {
        this.procesodenegocio = pROCESODENEGOCIOType;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getCODTAREANMC() {
        return this.codtareanmc;
    }

    public void setCODTAREANMC(String str) {
        this.codtareanmc = str;
    }
}
