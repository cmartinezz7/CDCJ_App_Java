package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOCUM_PERSONA_CORPORATIVO_Type", propOrder = {"tipodocumpersonacorp", "codigodocumpersonacorp"})
public class DOCUMPERSONACORPORATIVOType {
    @XmlElement(name = "CODIGO_DOCUM_PERSONA_CORP", required = true)
    protected String codigodocumpersonacorp;
    @XmlElement(name = "TIPO_DOCUM_PERSONA_CORP", required = true)
    protected String tipodocumpersonacorp;

    public String getTIPODOCUMPERSONACORP() {
        return this.tipodocumpersonacorp;
    }

    public void setTIPODOCUMPERSONACORP(String str) {
        this.tipodocumpersonacorp = str;
    }

    public String getCODIGODOCUMPERSONACORP() {
        return this.codigodocumpersonacorp;
    }

    public void setCODIGODOCUMPERSONACORP(String str) {
        this.codigodocumpersonacorp = str;
    }
}
