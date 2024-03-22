package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BIEN_Type", propOrder = {"empresa", "modalidad", "codigobien"})
public class BIENType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_BIEN")
    protected int codigobien;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "MODALIDAD", required = true)
    protected String modalidad;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getMODALIDAD() {
        return this.modalidad;
    }

    public void setMODALIDAD(String str) {
        this.modalidad = str;
    }

    public int getCODIGOBIEN() {
        return this.codigobien;
    }

    public void setCODIGOBIEN(int i) {
        this.codigobien = i;
    }
}
