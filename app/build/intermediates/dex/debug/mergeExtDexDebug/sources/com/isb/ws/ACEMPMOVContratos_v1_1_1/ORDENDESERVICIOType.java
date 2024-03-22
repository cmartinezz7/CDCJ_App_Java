package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORDEN_DE_SERVICIO_Type", propOrder = {"centro", "producto", "numerodeorden"})
public class ORDENDESERVICIOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "NUMERO_DE_ORDEN", required = true)
    protected String numerodeorden;
    @XmlElement(name = "PRODUCTO", required = true)
    protected String producto;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getPRODUCTO() {
        return this.producto;
    }

    public void setPRODUCTO(String str) {
        this.producto = str;
    }

    public String getNUMERODEORDEN() {
        return this.numerodeorden;
    }

    public void setNUMERODEORDEN(String str) {
        this.numerodeorden = str;
    }
}
