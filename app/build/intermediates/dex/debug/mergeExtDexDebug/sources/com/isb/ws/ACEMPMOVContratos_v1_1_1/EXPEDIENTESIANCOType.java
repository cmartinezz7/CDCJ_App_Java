package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXPEDIENTE_SIANCO_Type", propOrder = {"empresa", "tipoagrupacioncanales", "codexpediente"})
public class EXPEDIENTESIANCOType {
    @XmlElement(name = "COD_EXPEDIENTE", required = true)
    protected String codexpediente;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_AGRUPACION_CANALES", required = true)
    protected String tipoagrupacioncanales;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOAGRUPACIONCANALES() {
        return this.tipoagrupacioncanales;
    }

    public void setTIPOAGRUPACIONCANALES(String str) {
        this.tipoagrupacioncanales = str;
    }

    public String getCODEXPEDIENTE() {
        return this.codexpediente;
    }

    public void setCODEXPEDIENTE(String str) {
        this.codexpediente = str;
    }
}
