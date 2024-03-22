package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRATAMIENTO_PNC_Type", propOrder = {"normativapnc", "codtratamientopnc"})
public class TRATAMIENTOPNCType {
    @XmlElement(name = "COD_TRATAMIENTO_PNC", required = true)
    protected String codtratamientopnc;
    @XmlElement(name = "NORMATIVA_PNC", required = true)
    protected NORMATIVAPNCType normativapnc;

    public NORMATIVAPNCType getNORMATIVAPNC() {
        return this.normativapnc;
    }

    public void setNORMATIVAPNC(NORMATIVAPNCType nORMATIVAPNCType) {
        this.normativapnc = nORMATIVAPNCType;
    }

    public String getCODTRATAMIENTOPNC() {
        return this.codtratamientopnc;
    }

    public void setCODTRATAMIENTOPNC(String str) {
        this.codtratamientopnc = str;
    }
}
