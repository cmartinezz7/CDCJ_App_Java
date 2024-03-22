package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_PAQUETE_ONCE_Type", propOrder = {"centro", "codpaquete"})
public class CODIGOPAQUETEONCEType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "COD_PAQUETE", required = true)
    protected String codpaquete;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODPAQUETE() {
        return this.codpaquete;
    }

    public void setCODPAQUETE(String str) {
        this.codpaquete = str;
    }
}
