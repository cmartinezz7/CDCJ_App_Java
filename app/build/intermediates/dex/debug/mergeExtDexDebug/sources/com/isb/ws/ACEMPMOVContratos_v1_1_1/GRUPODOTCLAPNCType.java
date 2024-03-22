package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_DOT_CLA_PNC_Type", propOrder = {"tratamientopnc", "codgrupo"})
public class GRUPODOTCLAPNCType {
    @XmlElement(name = "COD_GRUPO", required = true)
    protected String codgrupo;
    @XmlElement(name = "TRATAMIENTO_PNC", required = true)
    protected TRATAMIENTOPNCType tratamientopnc;

    public TRATAMIENTOPNCType getTRATAMIENTOPNC() {
        return this.tratamientopnc;
    }

    public void setTRATAMIENTOPNC(TRATAMIENTOPNCType tRATAMIENTOPNCType) {
        this.tratamientopnc = tRATAMIENTOPNCType;
    }

    public String getCODGRUPO() {
        return this.codgrupo;
    }

    public void setCODGRUPO(String str) {
        this.codgrupo = str;
    }
}
