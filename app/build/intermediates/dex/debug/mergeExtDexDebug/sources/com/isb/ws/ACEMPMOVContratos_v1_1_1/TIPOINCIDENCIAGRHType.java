package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_INCIDENCIA_GRH_Type", propOrder = {"empresa", "codtipincidencia"})
public class TIPOINCIDENCIAGRHType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_TIP_INCIDENCIA")
    protected long codtipincidencia;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODTIPINCIDENCIA() {
        return this.codtipincidencia;
    }

    public void setCODTIPINCIDENCIA(long j) {
        this.codtipincidencia = j;
    }
}
