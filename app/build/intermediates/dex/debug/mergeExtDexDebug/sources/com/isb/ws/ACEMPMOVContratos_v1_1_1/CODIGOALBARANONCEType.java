package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_ALBARAN_ONCE_Type", propOrder = {"centro", "codalbaran"})
public class CODIGOALBARANONCEType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "COD_ALBARAN", required = true)
    protected String codalbaran;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODALBARAN() {
        return this.codalbaran;
    }

    public void setCODALBARAN(String str) {
        this.codalbaran = str;
    }
}
