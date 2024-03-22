package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_FMIS_Type", propOrder = {"empresafmis", "codigolineafmis"})
public class LINEAFMISType {
    @XmlElement(name = "CODIGO_LINEA_FMIS", required = true)
    protected String codigolineafmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODIGOLINEAFMIS() {
        return this.codigolineafmis;
    }

    public void setCODIGOLINEAFMIS(String str) {
        this.codigolineafmis = str;
    }
}
