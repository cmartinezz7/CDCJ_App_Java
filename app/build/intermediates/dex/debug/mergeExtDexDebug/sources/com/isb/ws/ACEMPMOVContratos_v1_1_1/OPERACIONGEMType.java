package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_GEM_Type", propOrder = {"formatoentradagem", "codoperacion"})
public class OPERACIONGEMType {
    @XmlElement(name = "COD_OPERACION", required = true)
    protected String codoperacion;
    @XmlElement(name = "FORMATO_ENTRADA_GEM", required = true)
    protected FORMATOENTRADAGEMType formatoentradagem;

    public FORMATOENTRADAGEMType getFORMATOENTRADAGEM() {
        return this.formatoentradagem;
    }

    public void setFORMATOENTRADAGEM(FORMATOENTRADAGEMType fORMATOENTRADAGEMType) {
        this.formatoentradagem = fORMATOENTRADAGEMType;
    }

    public String getCODOPERACION() {
        return this.codoperacion;
    }

    public void setCODOPERACION(String str) {
        this.codoperacion = str;
    }
}
