package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATRIBUTO_TIPO_GESTOR_Type", propOrder = {"empresa", "codatributotipogestor"})
public class ATRIBUTOTIPOGESTORType {
    @XmlElement(name = "COD_ATRIBUTO_TIPO_GESTOR", required = true)
    protected String codatributotipogestor;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODATRIBUTOTIPOGESTOR() {
        return this.codatributotipogestor;
    }

    public void setCODATRIBUTOTIPOGESTOR(String str) {
        this.codatributotipogestor = str;
    }
}
