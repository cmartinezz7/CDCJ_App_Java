package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_CUENTA_GEM_Type", propOrder = {"formatoentradagem", "codtipocuenta"})
public class TIPOCUENTAGEMType {
    @XmlElement(name = "COD_TIPO_CUENTA", required = true)
    protected String codtipocuenta;
    @XmlElement(name = "FORMATO_ENTRADA_GEM", required = true)
    protected FORMATOENTRADAGEMType formatoentradagem;

    public FORMATOENTRADAGEMType getFORMATOENTRADAGEM() {
        return this.formatoentradagem;
    }

    public void setFORMATOENTRADAGEM(FORMATOENTRADAGEMType fORMATOENTRADAGEMType) {
        this.formatoentradagem = fORMATOENTRADAGEMType;
    }

    public String getCODTIPOCUENTA() {
        return this.codtipocuenta;
    }

    public void setCODTIPOCUENTA(String str) {
        this.codtipocuenta = str;
    }
}
