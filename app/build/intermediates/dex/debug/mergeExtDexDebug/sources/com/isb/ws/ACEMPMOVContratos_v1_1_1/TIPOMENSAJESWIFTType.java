package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MENSAJE_SWIFT_Type", propOrder = {"tipomensaje", "categoriamensaje", "numeromensaje"})
public class TIPOMENSAJESWIFTType {
    @XmlElement(name = "CATEGORIA_MENSAJE", required = true)
    protected String categoriamensaje;
    @XmlElement(name = "NUMERO_MENSAJE", required = true)
    protected String numeromensaje;
    @XmlElement(name = "TIPO_MENSAJE", required = true)
    protected String tipomensaje;

    public String getTIPOMENSAJE() {
        return this.tipomensaje;
    }

    public void setTIPOMENSAJE(String str) {
        this.tipomensaje = str;
    }

    public String getCATEGORIAMENSAJE() {
        return this.categoriamensaje;
    }

    public void setCATEGORIAMENSAJE(String str) {
        this.categoriamensaje = str;
    }

    public String getNUMEROMENSAJE() {
        return this.numeromensaje;
    }

    public void setNUMEROMENSAJE(String str) {
        this.numeromensaje = str;
    }
}
