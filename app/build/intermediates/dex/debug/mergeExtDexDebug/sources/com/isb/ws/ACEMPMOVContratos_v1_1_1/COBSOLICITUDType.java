package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COB_SOLICITUD_Type", propOrder = {"cobcaso", "codsolicitud"})
public class COBSOLICITUDType {
    @XmlElement(name = "COB_CASO", required = true)
    protected COBCASOType cobcaso;
    @XmlElement(name = "COD_SOLICITUD", required = true)
    protected String codsolicitud;

    public COBCASOType getCOBCASO() {
        return this.cobcaso;
    }

    public void setCOBCASO(COBCASOType cOBCASOType) {
        this.cobcaso = cOBCASOType;
    }

    public String getCODSOLICITUD() {
        return this.codsolicitud;
    }

    public void setCODSOLICITUD(String str) {
        this.codsolicitud = str;
    }
}
