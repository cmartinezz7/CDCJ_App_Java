package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_RELACION_NOF_Type", propOrder = {"grupocomunicacionnof", "codrelacion"})
public class TIPORELACIONNOFType {
    @XmlElement(name = "COD_RELACION", required = true)
    protected String codrelacion;
    @XmlElement(name = "GRUPO_COMUNICACION_NOF", required = true)
    protected GRUPOCOMUNICACIONNOFType grupocomunicacionnof;

    public GRUPOCOMUNICACIONNOFType getGRUPOCOMUNICACIONNOF() {
        return this.grupocomunicacionnof;
    }

    public void setGRUPOCOMUNICACIONNOF(GRUPOCOMUNICACIONNOFType gRUPOCOMUNICACIONNOFType) {
        this.grupocomunicacionnof = gRUPOCOMUNICACIONNOFType;
    }

    public String getCODRELACION() {
        return this.codrelacion;
    }

    public void setCODRELACION(String str) {
        this.codrelacion = str;
    }
}
