package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RTES_NIVEL_SUJ_INTERNO_Type", propOrder = {"grupoempresa", "nivelinterno"})
public class RTESNIVELSUJINTERNOType {
    @XmlElement(name = "GRUPO_EMPRESA", required = true)
    protected String grupoempresa;
    @XmlElement(name = "NIVEL_INTERNO", required = true)
    protected String nivelinterno;

    public String getGRUPOEMPRESA() {
        return this.grupoempresa;
    }

    public void setGRUPOEMPRESA(String str) {
        this.grupoempresa = str;
    }

    public String getNIVELINTERNO() {
        return this.nivelinterno;
    }

    public void setNIVELINTERNO(String str) {
        this.nivelinterno = str;
    }
}
