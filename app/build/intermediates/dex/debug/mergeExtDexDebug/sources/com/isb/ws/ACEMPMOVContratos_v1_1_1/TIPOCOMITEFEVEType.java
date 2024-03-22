package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_COMITE_FEVE_Type", propOrder = {"tiporevisionfeve", "codcomitefeve"})
public class TIPOCOMITEFEVEType {
    @XmlElement(name = "COD_COMITE_FEVE", required = true)
    protected String codcomitefeve;
    @XmlElement(name = "TIPO_REVISION_FEVE", required = true)
    protected TIPOREVISIONFEVEType tiporevisionfeve;

    public TIPOREVISIONFEVEType getTIPOREVISIONFEVE() {
        return this.tiporevisionfeve;
    }

    public void setTIPOREVISIONFEVE(TIPOREVISIONFEVEType tIPOREVISIONFEVEType) {
        this.tiporevisionfeve = tIPOREVISIONFEVEType;
    }

    public String getCODCOMITEFEVE() {
        return this.codcomitefeve;
    }

    public void setCODCOMITEFEVE(String str) {
        this.codcomitefeve = str;
    }
}
