package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDENTIF_PRIVADO_GR_Type", propOrder = {"tipidprivada", "idprivada"})
public class IDENTIFPRIVADOGRType {
    @XmlElement(name = "ID_PRIVADA", required = true)
    protected String idprivada;
    @XmlElement(name = "TIP_ID_PRIVADA", required = true)
    protected String tipidprivada;

    public String getTIPIDPRIVADA() {
        return this.tipidprivada;
    }

    public void setTIPIDPRIVADA(String str) {
        this.tipidprivada = str;
    }

    public String getIDPRIVADA() {
        return this.idprivada;
    }

    public void setIDPRIVADA(String str) {
        this.idprivada = str;
    }
}
