package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_COMUNICACION_NOF_Type", propOrder = {"sistemacomunicacionnof", "codgrupocomunicnof"})
public class GRUPOCOMUNICACIONNOFType {
    @XmlElement(name = "COD_GRUPO_COMUNIC_NOF", required = true)
    protected String codgrupocomunicnof;
    @XmlElement(name = "SISTEMA_COMUNICACION_NOF", required = true)
    protected String sistemacomunicacionnof;

    public String getSISTEMACOMUNICACIONNOF() {
        return this.sistemacomunicacionnof;
    }

    public void setSISTEMACOMUNICACIONNOF(String str) {
        this.sistemacomunicacionnof = str;
    }

    public String getCODGRUPOCOMUNICNOF() {
        return this.codgrupocomunicnof;
    }

    public void setCODGRUPOCOMUNICNOF(String str) {
        this.codgrupocomunicnof = str;
    }
}
