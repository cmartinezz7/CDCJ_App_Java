package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOTIVO_INCIDENCIA_PMAS_Type", propOrder = {"tipodeincidenciapmas", "motivodeincidencia"})
public class MOTIVOINCIDENCIAPMASType {
    @XmlElement(name = "MOTIVO_DE_INCIDENCIA", required = true)
    protected String motivodeincidencia;
    @XmlElement(name = "TIPO_DE_INCIDENCIA_PMAS", required = true)
    protected String tipodeincidenciapmas;

    public String getTIPODEINCIDENCIAPMAS() {
        return this.tipodeincidenciapmas;
    }

    public void setTIPODEINCIDENCIAPMAS(String str) {
        this.tipodeincidenciapmas = str;
    }

    public String getMOTIVODEINCIDENCIA() {
        return this.motivodeincidencia;
    }

    public void setMOTIVODEINCIDENCIA(String str) {
        this.motivodeincidencia = str;
    }
}
