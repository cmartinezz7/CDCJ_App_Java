package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INSTALACION_OBM_Type", propOrder = {"empresa", "codinstalacion"})
public class INSTALACIONOBMType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INSTALACION")
    protected int codinstalacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODINSTALACION() {
        return this.codinstalacion;
    }

    public void setCODINSTALACION(int i) {
        this.codinstalacion = i;
    }
}
