package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOTIVO_ESTADO_EVIDENCIA_Type", propOrder = {"empresa", "codigoriesgo"})
public class MOTIVOESTADOEVIDENCIAType {
    @XmlElement(name = "CODIGO_RIESGO", required = true)
    protected String codigoriesgo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGORIESGO() {
        return this.codigoriesgo;
    }

    public void setCODIGORIESGO(String str) {
        this.codigoriesgo = str;
    }
}
