package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_CASO_PN_Type", propOrder = {"centro", "codigodecaso", "version"})
public class IDCASOPNType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_DE_CASO", required = true)
    protected String codigodecaso;
    @XmlElement(name = "VERSION", required = true)
    protected String version;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODIGODECASO() {
        return this.codigodecaso;
    }

    public void setCODIGODECASO(String str) {
        this.codigodecaso = str;
    }

    public String getVERSION() {
        return this.version;
    }

    public void setVERSION(String str) {
        this.version = str;
    }
}
