package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VENDEDOR_CTTO_PRESCRIPTOR_Type", propOrder = {"contrato", "numerodevendedor"})
public class VENDEDORCTTOPRESCRIPTORType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_DE_VENDEDOR")
    protected int numerodevendedor;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getNUMERODEVENDEDOR() {
        return this.numerodevendedor;
    }

    public void setNUMERODEVENDEDOR(int i) {
        this.numerodevendedor = i;
    }
}
