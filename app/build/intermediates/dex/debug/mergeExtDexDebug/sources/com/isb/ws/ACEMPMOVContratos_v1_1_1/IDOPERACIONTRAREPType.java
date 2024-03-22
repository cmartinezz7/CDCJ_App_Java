package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_OPERACION_TRAREP_Type", propOrder = {"empresa", "codoperacion"})
public class IDOPERACIONTRAREPType {
    @XmlElement(name = "COD_OPERACION", required = true)
    protected String codoperacion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODOPERACION() {
        return this.codoperacion;
    }

    public void setCODOPERACION(String str) {
        this.codoperacion = str;
    }
}
