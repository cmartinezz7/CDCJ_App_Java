package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_AP_CORR_Type", propOrder = {"apartadodecorreos", "localidad", "codigopostal"})
public class DOMICILIOPRESENTAPCORRType {
    @XmlElement(name = "APARTADO_DE_CORREOS", required = true)
    protected String apartadodecorreos;
    @XmlElement(name = "CODIGO_POSTAL", required = true)
    protected String codigopostal;
    @XmlElement(name = "LOCALIDAD", required = true)
    protected String localidad;

    public String getAPARTADODECORREOS() {
        return this.apartadodecorreos;
    }

    public void setAPARTADODECORREOS(String str) {
        this.apartadodecorreos = str;
    }

    public String getLOCALIDAD() {
        return this.localidad;
    }

    public void setLOCALIDAD(String str) {
        this.localidad = str;
    }

    public String getCODIGOPOSTAL() {
        return this.codigopostal;
    }

    public void setCODIGOPOSTAL(String str) {
        this.codigopostal = str;
    }
}
