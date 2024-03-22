package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CARACTERISTICA_CONTABLE_Type", propOrder = {"tipocaracteristcontable", "codcaracteristica"})
public class CARACTERISTICACONTABLEType {
    @XmlElement(name = "COD_CARACTERISTICA", required = true)
    protected String codcaracteristica;
    @XmlElement(name = "TIPO_CARACTERIST_CONTABLE", required = true)
    protected String tipocaracteristcontable;

    public String getTIPOCARACTERISTCONTABLE() {
        return this.tipocaracteristcontable;
    }

    public void setTIPOCARACTERISTCONTABLE(String str) {
        this.tipocaracteristcontable = str;
    }

    public String getCODCARACTERISTICA() {
        return this.codcaracteristica;
    }

    public void setCODCARACTERISTICA(String str) {
        this.codcaracteristica = str;
    }
}
