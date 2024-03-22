package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UNIDAD_JERARQUICA_Type", propOrder = {"contrato", "codunidadjerarquica"})
public class UNIDADJERARQUICAType {
    @XmlElement(name = "COD_UNIDAD_JERARQUICA", required = true)
    protected String codunidadjerarquica;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public String getCODUNIDADJERARQUICA() {
        return this.codunidadjerarquica;
    }

    public void setCODUNIDADJERARQUICA(String str) {
        this.codunidadjerarquica = str;
    }
}
