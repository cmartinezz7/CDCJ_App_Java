package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BLOQUEO_CONTRATO_TARJETA_Type", propOrder = {"empresa", "codbloqueocontratotjta"})
public class BLOQUEOCONTRATOTARJETAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_BLOQUEO_CONTRATO_TJTA")
    protected int codbloqueocontratotjta;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODBLOQUEOCONTRATOTJTA() {
        return this.codbloqueocontratotjta;
    }

    public void setCODBLOQUEOCONTRATOTJTA(int i) {
        this.codbloqueocontratotjta = i;
    }
}
