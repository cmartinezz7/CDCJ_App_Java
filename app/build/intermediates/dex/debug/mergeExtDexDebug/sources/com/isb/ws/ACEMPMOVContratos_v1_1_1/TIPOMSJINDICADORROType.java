package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MSJ_INDICADOR_RO_Type", propOrder = {"ambitointernoro", "codtipomsjindicadorro"})
public class TIPOMSJINDICADORROType {
    @XmlElement(name = "AMBITO_INTERNO_RO", required = true)
    protected String ambitointernoro;
    @XmlElement(name = "COD_TIPO_MSJ_INDICADOR_RO", required = true)
    protected String codtipomsjindicadorro;

    public String getAMBITOINTERNORO() {
        return this.ambitointernoro;
    }

    public void setAMBITOINTERNORO(String str) {
        this.ambitointernoro = str;
    }

    public String getCODTIPOMSJINDICADORRO() {
        return this.codtipomsjindicadorro;
    }

    public void setCODTIPOMSJINDICADORRO(String str) {
        this.codtipomsjindicadorro = str;
    }
}
