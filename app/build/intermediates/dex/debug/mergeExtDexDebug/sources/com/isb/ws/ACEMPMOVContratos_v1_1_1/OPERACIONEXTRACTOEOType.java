package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_EXTRACTO_EO_Type", propOrder = {"aplicacioninformatica", "codoperacionextracto"})
public class OPERACIONEXTRACTOEOType {
    @XmlElement(name = "APLICACION_INFORMATICA", required = true)
    protected String aplicacioninformatica;
    @XmlElement(name = "COD_OPERACION_EXTRACTO", required = true)
    protected String codoperacionextracto;

    public String getAPLICACIONINFORMATICA() {
        return this.aplicacioninformatica;
    }

    public void setAPLICACIONINFORMATICA(String str) {
        this.aplicacioninformatica = str;
    }

    public String getCODOPERACIONEXTRACTO() {
        return this.codoperacionextracto;
    }

    public void setCODOPERACIONEXTRACTO(String str) {
        this.codoperacionextracto = str;
    }
}
