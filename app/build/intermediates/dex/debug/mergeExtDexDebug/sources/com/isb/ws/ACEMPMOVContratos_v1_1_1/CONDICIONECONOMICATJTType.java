package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONDICION_ECONOMICA_TJT_Type", propOrder = {"subtipodeproducto", "indvertiente", "conprod"})
public class CONDICIONECONOMICATJTType {
    @XmlElement(name = "CONPROD", required = true)
    protected String conprod;
    @XmlElement(name = "IND_VERTIENTE", required = true)
    protected String indvertiente;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getINDVERTIENTE() {
        return this.indvertiente;
    }

    public void setINDVERTIENTE(String str) {
        this.indvertiente = str;
    }

    public String getCONPROD() {
        return this.conprod;
    }

    public void setCONPROD(String str) {
        this.conprod = str;
    }
}
