package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DE_PRODUCTO_Type", propOrder = {"tipodeproducto", "subtipodeproducto"})
public class SUBTIPODEPRODUCTOType {
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected String subtipodeproducto;
    @XmlElement(name = "TIPO_DE_PRODUCTO", required = true)
    protected TIPODEPRODUCTOType tipodeproducto;

    public TIPODEPRODUCTOType getTIPODEPRODUCTO() {
        return this.tipodeproducto;
    }

    public void setTIPODEPRODUCTO(TIPODEPRODUCTOType tIPODEPRODUCTOType) {
        this.tipodeproducto = tIPODEPRODUCTOType;
    }

    public String getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(String str) {
        this.subtipodeproducto = str;
    }
}
