package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_PRODUCTO_Type", propOrder = {"empresa", "tipodeproducto"})
public class TIPODEPRODUCTOType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_DE_PRODUCTO", required = true)
    protected String tipodeproducto;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPODEPRODUCTO() {
        return this.tipodeproducto;
    }

    public void setTIPODEPRODUCTO(String str) {
        this.tipodeproducto = str;
    }
}
