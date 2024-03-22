package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "METRICA_FMIS_Type", propOrder = {"empresafmis", "codmetricafmis"})
public class METRICAFMISType {
    @XmlElement(name = "COD_METRICA_FMIS", required = true)
    protected String codmetricafmis;
    @XmlElement(name = "EMPRESA_FMIS", required = true)
    protected String empresafmis;

    public String getEMPRESAFMIS() {
        return this.empresafmis;
    }

    public void setEMPRESAFMIS(String str) {
        this.empresafmis = str;
    }

    public String getCODMETRICAFMIS() {
        return this.codmetricafmis;
    }

    public void setCODMETRICAFMIS(String str) {
        this.codmetricafmis = str;
    }
}
