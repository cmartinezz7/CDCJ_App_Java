package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_ID_PARAMETRO_Type", propOrder = {"tipoparametro", "codparametro"})
public class BIIDPARAMETROType {
    @XmlElement(name = "COD_PARAMETRO", required = true)
    protected String codparametro;
    @XmlElement(name = "TIPO_PARAMETRO", required = true)
    protected String tipoparametro;

    public String getTIPOPARAMETRO() {
        return this.tipoparametro;
    }

    public void setTIPOPARAMETRO(String str) {
        this.tipoparametro = str;
    }

    public String getCODPARAMETRO() {
        return this.codparametro;
    }

    public void setCODPARAMETRO(String str) {
        this.codparametro = str;
    }
}
