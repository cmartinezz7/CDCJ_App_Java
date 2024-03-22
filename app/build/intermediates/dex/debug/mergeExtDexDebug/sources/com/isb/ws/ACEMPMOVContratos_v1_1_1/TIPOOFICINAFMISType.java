package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_OFICINA_FMIS_Type", propOrder = {"empresafmis", "codigotipooficinafmis"})
public class TIPOOFICINAFMISType {
    @XmlElement(name = "CODIGO_TIPO_OFICINA_FMIS", required = true)
    protected String codigotipooficinafmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODIGOTIPOOFICINAFMIS() {
        return this.codigotipooficinafmis;
    }

    public void setCODIGOTIPOOFICINAFMIS(String str) {
        this.codigotipooficinafmis = str;
    }
}
