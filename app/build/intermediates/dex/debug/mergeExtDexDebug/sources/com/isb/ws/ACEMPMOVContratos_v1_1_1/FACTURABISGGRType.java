package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FACTURA_BIS_GGR_Type", propOrder = {"empresa", "numfactura", "anio"})
public class FACTURABISGGRType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ANIO")
    protected int anio;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUM_FACTURA", required = true)
    protected String numfactura;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getNUMFACTURA() {
        return this.numfactura;
    }

    public void setNUMFACTURA(String str) {
        this.numfactura = str;
    }

    public int getANIO() {
        return this.anio;
    }

    public void setANIO(int i) {
        this.anio = i;
    }
}
