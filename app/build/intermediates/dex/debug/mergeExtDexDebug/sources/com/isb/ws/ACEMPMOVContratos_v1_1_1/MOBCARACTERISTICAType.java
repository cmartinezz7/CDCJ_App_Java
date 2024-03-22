package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_CARACTERISTICA_Type", propOrder = {"tipocaract", "caracteristica"})
public class MOBCARACTERISTICAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CARACTERISTICA")
    protected int caracteristica;
    @XmlElement(name = "TIPO_CARACT", required = true)
    protected String tipocaract;

    public String getTIPOCARACT() {
        return this.tipocaract;
    }

    public void setTIPOCARACT(String str) {
        this.tipocaract = str;
    }

    public int getCARACTERISTICA() {
        return this.caracteristica;
    }

    public void setCARACTERISTICA(int i) {
        this.caracteristica = i;
    }
}
