package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MODALIDAD_GRUPO_FMIS_Type", propOrder = {"empresafmis", "codmodalidadgrupofmis"})
public class MODALIDADGRUPOFMISType {
    @XmlElement(name = "COD_MODALIDAD_GRUPO_FMIS", required = true)
    protected String codmodalidadgrupofmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODMODALIDADGRUPOFMIS() {
        return this.codmodalidadgrupofmis;
    }

    public void setCODMODALIDADGRUPOFMIS(String str) {
        this.codmodalidadgrupofmis = str;
    }
}
