package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LLAMADA_GLP_Type", propOrder = {"codigodellamada", "centro"})
public class LLAMADAGLPType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_DE_LLAMADA", required = true)
    protected String codigodellamada;

    public String getCODIGODELLAMADA() {
        return this.codigodellamada;
    }

    public void setCODIGODELLAMADA(String str) {
        this.codigodellamada = str;
    }

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }
}
