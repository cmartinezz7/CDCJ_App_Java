package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_ACTUANTE_Type", propOrder = {"empresa", "codtipodeactuante"})
public class TIPODEACTUANTEType {
    @XmlElement(name = "COD_TIPO_DE_ACTUANTE", required = true)
    protected String codtipodeactuante;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODTIPODEACTUANTE() {
        return this.codtipodeactuante;
    }

    public void setCODTIPODEACTUANTE(String str) {
        this.codtipodeactuante = str;
    }
}
