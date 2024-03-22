package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_PRIVADO_GR_Type", propOrder = {"subtipogr", "idprivada"})
public class ROLPRIVADOGRType {
    @XmlElement(name = "ID_PRIVADA", required = true)
    protected String idprivada;
    @XmlElement(name = "SUBTIPO_GR", required = true)
    protected SUBTIPOGRType subtipogr;

    public SUBTIPOGRType getSUBTIPOGR() {
        return this.subtipogr;
    }

    public void setSUBTIPOGR(SUBTIPOGRType sUBTIPOGRType) {
        this.subtipogr = sUBTIPOGRType;
    }

    public String getIDPRIVADA() {
        return this.idprivada;
    }

    public void setIDPRIVADA(String str) {
        this.idprivada = str;
    }
}
