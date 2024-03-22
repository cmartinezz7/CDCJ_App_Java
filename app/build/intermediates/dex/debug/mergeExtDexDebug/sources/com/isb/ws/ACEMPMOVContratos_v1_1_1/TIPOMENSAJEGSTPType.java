package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MENSAJE_GSTP_Type", propOrder = {"sistemagstp", "mensaje"})
public class TIPOMENSAJEGSTPType {
    @XmlElement(name = "MENSAJE", required = true)
    protected String mensaje;
    @XmlElement(name = "SISTEMA_GSTP", required = true)
    protected String sistemagstp;

    public String getSISTEMAGSTP() {
        return this.sistemagstp;
    }

    public void setSISTEMAGSTP(String str) {
        this.sistemagstp = str;
    }

    public String getMENSAJE() {
        return this.mensaje;
    }

    public void setMENSAJE(String str) {
        this.mensaje = str;
    }
}
