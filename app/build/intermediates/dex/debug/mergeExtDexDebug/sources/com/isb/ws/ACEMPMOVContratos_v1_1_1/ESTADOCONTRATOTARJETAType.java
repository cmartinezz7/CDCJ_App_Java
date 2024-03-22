package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_CONTRATO_TARJETA_Type", propOrder = {"empresa", "codestadocontratotjta"})
public class ESTADOCONTRATOTARJETAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_ESTADO_CONTRATO_TJTA")
    protected int codestadocontratotjta;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODESTADOCONTRATOTJTA() {
        return this.codestadocontratotjta;
    }

    public void setCODESTADOCONTRATOTJTA(int i) {
        this.codestadocontratotjta = i;
    }
}
