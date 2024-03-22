package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADMINISTRADOR_TIPO_GESTOR_Type", propOrder = {"empresa", "tipodegestor", "codadmintipogestor"})
public class ADMINISTRADORTIPOGESTORType {
    @XmlElement(name = "COD_ADMIN_TIPO_GESTOR", required = true)
    protected String codadmintipogestor;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_DE_GESTOR", required = true)
    protected String tipodegestor;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPODEGESTOR() {
        return this.tipodegestor;
    }

    public void setTIPODEGESTOR(String str) {
        this.tipodegestor = str;
    }

    public String getCODADMINTIPOGESTOR() {
        return this.codadmintipogestor;
    }

    public void setCODADMINTIPOGESTOR(String str) {
        this.codadmintipogestor = str;
    }
}
