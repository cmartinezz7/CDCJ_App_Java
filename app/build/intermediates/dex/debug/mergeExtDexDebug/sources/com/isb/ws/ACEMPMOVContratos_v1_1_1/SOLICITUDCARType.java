package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOLICITUD_CAR_Type", propOrder = {"centro", "codigosolicitudcar"})
public class SOLICITUDCARType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_SOLICITUD_CAR", required = true)
    protected String codigosolicitudcar;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODIGOSOLICITUDCAR() {
        return this.codigosolicitudcar;
    }

    public void setCODIGOSOLICITUDCAR(String str) {
        this.codigosolicitudcar = str;
    }
}
