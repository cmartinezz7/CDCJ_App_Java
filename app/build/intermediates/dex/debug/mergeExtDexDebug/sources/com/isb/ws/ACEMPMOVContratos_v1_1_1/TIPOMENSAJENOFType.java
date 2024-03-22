package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MENSAJE_NOF_Type", propOrder = {"codtipomensaje", "idtiposolicitud"})
public class TIPOMENSAJENOFType {
    @XmlElement(name = "COD_TIPO_MENSAJE", required = true)
    protected String codtipomensaje;
    @XmlElement(name = "ID_TIPO_SOLICITUD", required = true)
    protected String idtiposolicitud;

    public String getCODTIPOMENSAJE() {
        return this.codtipomensaje;
    }

    public void setCODTIPOMENSAJE(String str) {
        this.codtipomensaje = str;
    }

    public String getIDTIPOSOLICITUD() {
        return this.idtiposolicitud;
    }

    public void setIDTIPOSOLICITUD(String str) {
        this.idtiposolicitud = str;
    }
}
