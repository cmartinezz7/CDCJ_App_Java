package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_BKS_Type", propOrder = {"aplicacionlogica", "nombreoperacionbks"})
public class OPERACIONBKSType {
    @XmlElement(name = "APLICACION_LOGICA", required = true)
    protected String aplicacionlogica;
    @XmlElement(name = "NOMBRE_OPERACION_BKS", required = true)
    protected String nombreoperacionbks;

    public String getAPLICACIONLOGICA() {
        return this.aplicacionlogica;
    }

    public void setAPLICACIONLOGICA(String str) {
        this.aplicacionlogica = str;
    }

    public String getNOMBREOPERACIONBKS() {
        return this.nombreoperacionbks;
    }

    public void setNOMBREOPERACIONBKS(String str) {
        this.nombreoperacionbks = str;
    }
}
