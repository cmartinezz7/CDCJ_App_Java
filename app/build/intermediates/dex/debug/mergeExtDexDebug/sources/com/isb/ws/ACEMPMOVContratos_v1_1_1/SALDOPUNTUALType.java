package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SALDO_PUNTUAL_Type", propOrder = {"posiciondecontrato", "importe"})
public class SALDOPUNTUALType {
    @XmlElement(name = "IMPORTE", required = true)
    protected IMPORTEType importe;
    @XmlElement(name = "POSICION_DE_CONTRATO", required = true)
    protected POSICIONDECONTRATOType posiciondecontrato;

    public POSICIONDECONTRATOType getPOSICIONDECONTRATO() {
        return this.posiciondecontrato;
    }

    public void setPOSICIONDECONTRATO(POSICIONDECONTRATOType pOSICIONDECONTRATOType) {
        this.posiciondecontrato = pOSICIONDECONTRATOType;
    }

    public IMPORTEType getIMPORTE() {
        return this.importe;
    }

    public void setIMPORTE(IMPORTEType iMPORTEType) {
        this.importe = iMPORTEType;
    }
}
