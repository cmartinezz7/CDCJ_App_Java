package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CASO_CARC_Type", propOrder = {"centro", "codigocaso", "codigoversion", "codigosolicitud"})
public class CASOCARCType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_CASO", required = true)
    protected String codigocaso;
    @XmlElement(name = "CODIGO_SOLICITUD", required = true)
    protected String codigosolicitud;
    @XmlElement(name = "CODIGO_VERSION", required = true)
    protected String codigoversion;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODIGOCASO() {
        return this.codigocaso;
    }

    public void setCODIGOCASO(String str) {
        this.codigocaso = str;
    }

    public String getCODIGOVERSION() {
        return this.codigoversion;
    }

    public void setCODIGOVERSION(String str) {
        this.codigoversion = str;
    }

    public String getCODIGOSOLICITUD() {
        return this.codigosolicitud;
    }

    public void setCODIGOSOLICITUD(String str) {
        this.codigosolicitud = str;
    }
}
