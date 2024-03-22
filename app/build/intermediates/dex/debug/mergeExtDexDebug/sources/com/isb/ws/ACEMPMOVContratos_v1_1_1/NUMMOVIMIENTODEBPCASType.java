package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUM_MOVIMIENTO_DEB_PCAS_Type", propOrder = {"contrato", "nummovimientodeb"})
public class NUMMOVIMIENTODEBPCASType {
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOType contrato;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_MOVIMIENTO_DEB")
    protected int nummovimientodeb;

    public CONTRATOType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOType cONTRATOType) {
        this.contrato = cONTRATOType;
    }

    public int getNUMMOVIMIENTODEB() {
        return this.nummovimientodeb;
    }

    public void setNUMMOVIMIENTODEB(int i) {
        this.nummovimientodeb = i;
    }
}
