package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EMISOR_GESTOR_EMISORES_Type", propOrder = {"empresa", "tipoacuerdo", "codrolacuerdo", "tipogestoremisoresiso", "gestoremisoresiso"})
public class EMISORGESTOREMISORESType {
    @XmlElement(name = "COD_ROL_ACUERDO", required = true)
    protected String codrolacuerdo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "GESTOR_EMISORES_ISO", required = true)
    protected String gestoremisoresiso;
    @XmlElement(name = "TIPO_ACUERDO", required = true)
    protected String tipoacuerdo;
    @XmlElement(name = "TIPO_GESTOR_EMISORES_ISO", required = true)
    protected String tipogestoremisoresiso;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOACUERDO() {
        return this.tipoacuerdo;
    }

    public void setTIPOACUERDO(String str) {
        this.tipoacuerdo = str;
    }

    public String getCODROLACUERDO() {
        return this.codrolacuerdo;
    }

    public void setCODROLACUERDO(String str) {
        this.codrolacuerdo = str;
    }

    public String getTIPOGESTOREMISORESISO() {
        return this.tipogestoremisoresiso;
    }

    public void setTIPOGESTOREMISORESISO(String str) {
        this.tipogestoremisoresiso = str;
    }

    public String getGESTOREMISORESISO() {
        return this.gestoremisoresiso;
    }

    public void setGESTOREMISORESISO(String str) {
        this.gestoremisoresiso = str;
    }
}
