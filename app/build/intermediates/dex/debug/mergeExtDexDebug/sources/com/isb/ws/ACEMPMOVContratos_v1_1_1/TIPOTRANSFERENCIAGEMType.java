package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_TRANSFERENCIA_GEM_Type", propOrder = {"formatoentradagem", "codtiptransf"})
public class TIPOTRANSFERENCIAGEMType {
    @XmlElement(name = "COD_TIP_TRANSF", required = true)
    protected String codtiptransf;
    @XmlElement(name = "FORMATO_ENTRADA_GEM", required = true)
    protected FORMATOENTRADAGEMType formatoentradagem;

    public FORMATOENTRADAGEMType getFORMATOENTRADAGEM() {
        return this.formatoentradagem;
    }

    public void setFORMATOENTRADAGEM(FORMATOENTRADAGEMType fORMATOENTRADAGEMType) {
        this.formatoentradagem = fORMATOENTRADAGEMType;
    }

    public String getCODTIPTRANSF() {
        return this.codtiptransf;
    }

    public void setCODTIPTRANSF(String str) {
        this.codtiptransf = str;
    }
}
