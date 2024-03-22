package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MENSEG_ASUNTO_Type", propOrder = {"empresa", "canal", "codasunto"})
public class MENSEGASUNTOType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "COD_ASUNTO", required = true)
    protected String codasunto;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

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

    public String getCODASUNTO() {
        return this.codasunto;
    }

    public void setCODASUNTO(String str) {
        this.codasunto = str;
    }
}
