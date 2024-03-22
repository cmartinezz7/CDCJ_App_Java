package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TALONARIO_AUTOCHEQ_CHISSW_Type", propOrder = {"centro", "numtaloncomb"})
public class TALONARIOAUTOCHEQCHISSWType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_TALON_COMB")
    protected int numtaloncomb;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public int getNUMTALONCOMB() {
        return this.numtaloncomb;
    }

    public void setNUMTALONCOMB(int i) {
        this.numtaloncomb = i;
    }
}
