package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_MENSAJE_NOF_Type", propOrder = {"grupocomunicacionnof", "codmensajenof"})
public class IDMENSAJENOFType {
    @XmlElement(name = "COD_MENSAJE_NOF", required = true)
    protected String codmensajenof;
    @XmlElement(name = "GRUPO_COMUNICACION_NOF", required = true)
    protected GRUPOCOMUNICACIONNOFType grupocomunicacionnof;

    public GRUPOCOMUNICACIONNOFType getGRUPOCOMUNICACIONNOF() {
        return this.grupocomunicacionnof;
    }

    public void setGRUPOCOMUNICACIONNOF(GRUPOCOMUNICACIONNOFType gRUPOCOMUNICACIONNOFType) {
        this.grupocomunicacionnof = gRUPOCOMUNICACIONNOFType;
    }

    public String getCODMENSAJENOF() {
        return this.codmensajenof;
    }

    public void setCODMENSAJENOF(String str) {
        this.codmensajenof = str;
    }
}
