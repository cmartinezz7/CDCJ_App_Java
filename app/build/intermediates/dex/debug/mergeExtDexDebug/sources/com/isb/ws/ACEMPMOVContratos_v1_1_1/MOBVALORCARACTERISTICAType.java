package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_VALOR_CARACTERISTICA_Type", propOrder = {"caracteristica", "concepto"})
public class MOBVALORCARACTERISTICAType {
    @XmlElement(name = "CARACTERISTICA", required = true)
    protected MOBCARACTERISTICAType caracteristica;
    @XmlElement(name = "CONCEPTO", required = true)
    protected String concepto;

    public MOBCARACTERISTICAType getCARACTERISTICA() {
        return this.caracteristica;
    }

    public void setCARACTERISTICA(MOBCARACTERISTICAType mOBCARACTERISTICAType) {
        this.caracteristica = mOBCARACTERISTICAType;
    }

    public String getCONCEPTO() {
        return this.concepto;
    }

    public void setCONCEPTO(String str) {
        this.concepto = str;
    }
}
