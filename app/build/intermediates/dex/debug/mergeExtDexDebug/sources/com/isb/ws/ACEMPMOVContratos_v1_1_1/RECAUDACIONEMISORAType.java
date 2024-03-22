package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECAUDACION_EMISORA_Type", propOrder = {"emisora", "producto", "subtipoderecaudacion"})
public class RECAUDACIONEMISORAType {
    @XmlElement(name = "EMISORA", required = true)
    protected String emisora;
    @XmlElement(name = "PRODUCTO", required = true)
    protected String producto;
    @XmlElement(name = "SUBTIPO_DE_RECAUDACION", required = true)
    protected SUBTIPODERECAUDACIONType subtipoderecaudacion;

    public String getEMISORA() {
        return this.emisora;
    }

    public void setEMISORA(String str) {
        this.emisora = str;
    }

    public String getPRODUCTO() {
        return this.producto;
    }

    public void setPRODUCTO(String str) {
        this.producto = str;
    }

    public SUBTIPODERECAUDACIONType getSUBTIPODERECAUDACION() {
        return this.subtipoderecaudacion;
    }

    public void setSUBTIPODERECAUDACION(SUBTIPODERECAUDACIONType sUBTIPODERECAUDACIONType) {
        this.subtipoderecaudacion = sUBTIPODERECAUDACIONType;
    }
}
