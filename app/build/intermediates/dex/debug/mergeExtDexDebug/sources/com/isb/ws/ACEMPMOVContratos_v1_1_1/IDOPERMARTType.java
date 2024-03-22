package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_OPERMART_Type", propOrder = {"codinstancia", "empresa", "codigodesubaplicacion"})
public class IDOPERMARTType {
    @XmlElement(name = "CODIGO_DE_SUBAPLICACION", required = true)
    protected String codigodesubaplicacion;
    @XmlElement(name = "COD_INSTANCIA", required = true)
    protected String codinstancia;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getCODINSTANCIA() {
        return this.codinstancia;
    }

    public void setCODINSTANCIA(String str) {
        this.codinstancia = str;
    }

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGODESUBAPLICACION() {
        return this.codigodesubaplicacion;
    }

    public void setCODIGODESUBAPLICACION(String str) {
        this.codigodesubaplicacion = str;
    }
}
