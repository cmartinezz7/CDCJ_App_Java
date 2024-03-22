package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOLICITUD_FISCAL_Type", propOrder = {"empresa", "tiposolicitudfiscal", "codigosolicitud"})
public class SOLICITUDFISCALType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_SOLICITUD")
    protected int codigosolicitud;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_SOLICITUD_FISCAL", required = true)
    protected String tiposolicitudfiscal;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOSOLICITUDFISCAL() {
        return this.tiposolicitudfiscal;
    }

    public void setTIPOSOLICITUDFISCAL(String str) {
        this.tiposolicitudfiscal = str;
    }

    public int getCODIGOSOLICITUD() {
        return this.codigosolicitud;
    }

    public void setCODIGOSOLICITUD(int i) {
        this.codigosolicitud = i;
    }
}
