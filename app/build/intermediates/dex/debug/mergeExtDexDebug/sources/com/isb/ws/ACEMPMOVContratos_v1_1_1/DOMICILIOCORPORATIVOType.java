package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_CORPORATIVO_Type", propOrder = {"formatodomicilio", "detalledomicilio"})
public class DOMICILIOCORPORATIVOType {
    @XmlElement(name = "DETALLE_DOMICILIO", required = true)
    protected String detalledomicilio;
    @XmlElement(name = "FORMATO_DOMICILIO", required = true)
    protected String formatodomicilio;

    public String getFORMATODOMICILIO() {
        return this.formatodomicilio;
    }

    public void setFORMATODOMICILIO(String str) {
        this.formatodomicilio = str;
    }

    public String getDETALLEDOMICILIO() {
        return this.detalledomicilio;
    }

    public void setDETALLEDOMICILIO(String str) {
        this.detalledomicilio = str;
    }
}
