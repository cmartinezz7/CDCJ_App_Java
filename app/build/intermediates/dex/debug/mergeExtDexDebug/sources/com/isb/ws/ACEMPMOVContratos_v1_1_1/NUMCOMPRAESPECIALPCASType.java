package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_COMPRA_ESPECIAL_PCAS_Type", propOrder = {"contrato", "numcompraespecial"})
public class NUMCOMPRAESPECIALPCASType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_COMPRA_ESPECIAL")
    protected int numcompraespecial;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getNUMCOMPRAESPECIAL() {
        return this.numcompraespecial;
    }

    public void setNUMCOMPRAESPECIAL(int i) {
        this.numcompraespecial = i;
    }
}
