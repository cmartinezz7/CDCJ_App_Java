package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROPUESTA_DE_RIESGO_Type", propOrder = {"centro", "ano", "numerodepropuesta"})
public class PROPUESTADERIESGOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ANO")
    protected int ano;
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_PROPUESTA")
    protected int numerodepropuesta;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public int getANO() {
        return this.ano;
    }

    public void setANO(int i) {
        this.ano = i;
    }

    public int getNUMERODEPROPUESTA() {
        return this.numerodepropuesta;
    }

    public void setNUMERODEPROPUESTA(int i) {
        this.numerodepropuesta = i;
    }
}
