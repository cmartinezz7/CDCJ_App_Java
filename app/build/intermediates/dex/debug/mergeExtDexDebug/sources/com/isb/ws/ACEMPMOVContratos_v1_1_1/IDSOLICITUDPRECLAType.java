package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SOLICITUD_PRECLA_Type", propOrder = {"centro", "codcaso", "version", "codsolicitud"})
public class IDSOLICITUDPRECLAType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "COD_CASO", required = true)
    protected String codcaso;
    @XmlElement(name = "COD_SOLICITUD", required = true)
    protected String codsolicitud;
    @XmlElement(name = "VERSION", required = true)
    protected String version;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODCASO() {
        return this.codcaso;
    }

    public void setCODCASO(String str) {
        this.codcaso = str;
    }

    public String getVERSION() {
        return this.version;
    }

    public void setVERSION(String str) {
        this.version = str;
    }

    public String getCODSOLICITUD() {
        return this.codsolicitud;
    }

    public void setCODSOLICITUD(String str) {
        this.codsolicitud = str;
    }
}
