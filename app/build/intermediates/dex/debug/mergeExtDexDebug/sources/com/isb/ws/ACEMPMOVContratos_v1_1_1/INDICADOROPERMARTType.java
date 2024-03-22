package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INDICADOR_OPERMART_Type", propOrder = {"idopermart", "codindicador"})
public class INDICADOROPERMARTType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INDICADOR")
    protected int codindicador;
    @XmlElement(name = "ID_OPERMART", required = true)
    protected IDOPERMARTType idopermart;

    public IDOPERMARTType getIDOPERMART() {
        return this.idopermart;
    }

    public void setIDOPERMART(IDOPERMARTType iDOPERMARTType) {
        this.idopermart = iDOPERMARTType;
    }

    public int getCODINDICADOR() {
        return this.codindicador;
    }

    public void setCODINDICADOR(int i) {
        this.codindicador = i;
    }
}
