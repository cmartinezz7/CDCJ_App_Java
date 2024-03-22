package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_INSTRUMENTACION_Type", propOrder = {"empresa", "codtipoinstrumentacion"})
public class TIPOINSTRUMENTACIONType {
    @XmlElement(name = "COD_TIPO_INSTRUMENTACION", required = true)
    protected String codtipoinstrumentacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODTIPOINSTRUMENTACION() {
        return this.codtipoinstrumentacion;
    }

    public void setCODTIPOINSTRUMENTACION(String str) {
        this.codtipoinstrumentacion = str;
    }
}
