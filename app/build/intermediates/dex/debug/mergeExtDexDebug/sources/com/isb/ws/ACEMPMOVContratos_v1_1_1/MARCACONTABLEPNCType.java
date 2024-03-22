package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MARCA_CONTABLE_PNC_Type", propOrder = {"normativapnc", "codmarcacontable"})
public class MARCACONTABLEPNCType {
    @XmlElement(name = "COD_MARCA_CONTABLE", required = true)
    protected String codmarcacontable;
    @XmlElement(name = "NORMATIVA_PNC", required = true)
    protected NORMATIVAPNCType normativapnc;

    public NORMATIVAPNCType getNORMATIVAPNC() {
        return this.normativapnc;
    }

    public void setNORMATIVAPNC(NORMATIVAPNCType nORMATIVAPNCType) {
        this.normativapnc = nORMATIVAPNCType;
    }

    public String getCODMARCACONTABLE() {
        return this.codmarcacontable;
    }

    public void setCODMARCACONTABLE(String str) {
        this.codmarcacontable = str;
    }
}
