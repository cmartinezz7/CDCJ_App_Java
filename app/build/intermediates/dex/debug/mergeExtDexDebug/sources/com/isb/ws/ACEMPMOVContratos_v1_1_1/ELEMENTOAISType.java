package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ELEMENTO_AIS_Type", propOrder = {"empresa", "tipoelementoais", "idelementoais"})
public class ELEMENTOAISType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_ELEMENTO_AIS")
    protected int idelementoais;
    @XmlElement(name = "TIPO_ELEMENTO_AIS", required = true)
    protected String tipoelementoais;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOELEMENTOAIS() {
        return this.tipoelementoais;
    }

    public void setTIPOELEMENTOAIS(String str) {
        this.tipoelementoais = str;
    }

    public int getIDELEMENTOAIS() {
        return this.idelementoais;
    }

    public void setIDELEMENTOAIS(int i) {
        this.idelementoais = i;
    }
}
