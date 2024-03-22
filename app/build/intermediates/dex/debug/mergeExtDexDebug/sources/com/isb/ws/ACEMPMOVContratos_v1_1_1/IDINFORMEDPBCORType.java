package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_INFORME_DPBCOR_Type", propOrder = {"empresa", "canal", "tipoinforme"})
public class IDINFORMEDPBCORType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_INFORME", required = true)
    protected String tipoinforme;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getTIPOINFORME() {
        return this.tipoinforme;
    }

    public void setTIPOINFORME(String str) {
        this.tipoinforme = str;
    }
}
