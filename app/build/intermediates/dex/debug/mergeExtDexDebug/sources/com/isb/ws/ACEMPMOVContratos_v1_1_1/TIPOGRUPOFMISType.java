package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_GRUPO_FMIS_Type", propOrder = {"empresafmis", "codtipogrupofmis"})
public class TIPOGRUPOFMISType {
    @XmlElement(name = "COD_TIPO_GRUPO_FMIS", required = true)
    protected String codtipogrupofmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODTIPOGRUPOFMIS() {
        return this.codtipogrupofmis;
    }

    public void setCODTIPOGRUPOFMIS(String str) {
        this.codtipogrupofmis = str;
    }
}
