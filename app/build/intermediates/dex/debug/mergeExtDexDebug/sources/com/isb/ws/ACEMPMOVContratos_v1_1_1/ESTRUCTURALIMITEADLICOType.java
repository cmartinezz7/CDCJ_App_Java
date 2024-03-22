package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTRUCTURA_LIMITE_ADLICO_Type", propOrder = {"subtipodeproducto", "codestructura"})
public class ESTRUCTURALIMITEADLICOType {
    @XmlElement(name = "COD_ESTRUCTURA", required = true)
    protected String codestructura;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getCODESTRUCTURA() {
        return this.codestructura;
    }

    public void setCODESTRUCTURA(String str) {
        this.codestructura = str;
    }
}
