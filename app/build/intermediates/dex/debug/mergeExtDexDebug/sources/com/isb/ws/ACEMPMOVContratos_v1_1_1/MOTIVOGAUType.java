package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOTIVO_GAU_Type", propOrder = {"tipmotivogau", "codmotivointerno"})
public class MOTIVOGAUType {
    @XmlElement(name = "COD_MOTIVO_INTERNO", required = true)
    protected String codmotivointerno;
    @XmlElement(name = "TIP_MOTIVO_GAU", required = true)
    protected TIPMOTIVOGAUType tipmotivogau;

    public TIPMOTIVOGAUType getTIPMOTIVOGAU() {
        return this.tipmotivogau;
    }

    public void setTIPMOTIVOGAU(TIPMOTIVOGAUType tIPMOTIVOGAUType) {
        this.tipmotivogau = tIPMOTIVOGAUType;
    }

    public String getCODMOTIVOINTERNO() {
        return this.codmotivointerno;
    }

    public void setCODMOTIVOINTERNO(String str) {
        this.codmotivointerno = str;
    }
}
