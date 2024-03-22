package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_CAMPO_AVISO_Type", propOrder = {"tipocampoaviso", "subtipocampo"})
public class SUBTIPOCAMPOAVISOType {
    @XmlElement(name = "SUBTIPO_CAMPO", required = true)
    protected String subtipocampo;
    @XmlElement(name = "TIPO_CAMPO_AVISO", required = true)
    protected String tipocampoaviso;

    public String getTIPOCAMPOAVISO() {
        return this.tipocampoaviso;
    }

    public void setTIPOCAMPOAVISO(String str) {
        this.tipocampoaviso = str;
    }

    public String getSUBTIPOCAMPO() {
        return this.subtipocampo;
    }

    public void setSUBTIPOCAMPO(String str) {
        this.subtipocampo = str;
    }
}
