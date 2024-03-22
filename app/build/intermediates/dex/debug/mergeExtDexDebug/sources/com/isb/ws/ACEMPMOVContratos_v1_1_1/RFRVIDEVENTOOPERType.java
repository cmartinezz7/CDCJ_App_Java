package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RFRV_ID_EVENTO_OPER_Type", propOrder = {"contrato", "numevento"})
public class RFRVIDEVENTOOPERType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_EVENTO")
    protected int numevento;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getNUMEVENTO() {
        return this.numevento;
    }

    public void setNUMEVENTO(int i) {
        this.numevento = i;
    }
}
