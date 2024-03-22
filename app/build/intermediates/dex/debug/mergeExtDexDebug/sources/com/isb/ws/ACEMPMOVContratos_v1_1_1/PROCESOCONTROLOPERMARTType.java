package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESO_CONTROL_OPERMART_Type", propOrder = {"bloquefuncionalopermart", "codprocesocontrol"})
public class PROCESOCONTROLOPERMARTType {
    @XmlElement(name = "BLOQUE_FUNCIONAL_OPERMART", required = true)
    protected BLOQUEFUNCIONALOPERMARTType bloquefuncionalopermart;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_PROCESO_CONTROL")
    protected int codprocesocontrol;

    public BLOQUEFUNCIONALOPERMARTType getBLOQUEFUNCIONALOPERMART() {
        return this.bloquefuncionalopermart;
    }

    public void setBLOQUEFUNCIONALOPERMART(BLOQUEFUNCIONALOPERMARTType bLOQUEFUNCIONALOPERMARTType) {
        this.bloquefuncionalopermart = bLOQUEFUNCIONALOPERMARTType;
    }

    public int getCODPROCESOCONTROL() {
        return this.codprocesocontrol;
    }

    public void setCODPROCESOCONTROL(int i) {
        this.codprocesocontrol = i;
    }
}
