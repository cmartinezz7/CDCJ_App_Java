package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_COMUNICACION_SCC_Type", propOrder = {"empresa", "codnum9"})
public class TIPODECOMUNICACIONSCCType {
    @XmlElement(name = "COD_NUM_9", required = true)
    protected String codnum9;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODNUM9() {
        return this.codnum9;
    }

    public void setCODNUM9(String str) {
        this.codnum9 = str;
    }
}
