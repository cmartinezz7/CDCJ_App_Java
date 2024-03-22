package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUXILIAR_CONTABLE_Type", propOrder = {"centro", "producto", "concepto", "importe"})
public class AUXILIARCONTABLEType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTRODECONTRATOType centro;
    @XmlElement(name = "CONCEPTO", required = true)
    protected String concepto;
    @XmlElement(name = "IMPORTE", required = true)
    protected IMPORTEType importe;
    @XmlElement(name = "PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType producto;

    public CENTRODECONTRATOType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTRODECONTRATOType cENTRODECONTRATOType) {
        this.centro = cENTRODECONTRATOType;
    }

    public SUBTIPODEPRODUCTOType getPRODUCTO() {
        return this.producto;
    }

    public void setPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.producto = sUBTIPODEPRODUCTOType;
    }

    public String getCONCEPTO() {
        return this.concepto;
    }

    public void setCONCEPTO(String str) {
        this.concepto = str;
    }

    public IMPORTEType getIMPORTE() {
        return this.importe;
    }

    public void setIMPORTE(IMPORTEType iMPORTEType) {
        this.importe = iMPORTEType;
    }
}
