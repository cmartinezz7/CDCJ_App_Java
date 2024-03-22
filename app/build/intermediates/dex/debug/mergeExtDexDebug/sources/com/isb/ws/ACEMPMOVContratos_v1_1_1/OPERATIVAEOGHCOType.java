package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERATIVA_EOGHCO_Type", propOrder = {"bloquefuncionaleoghco", "codoperativa"})
public class OPERATIVAEOGHCOType {
    @XmlElement(name = "BLOQUE_FUNCIONAL_EOGHCO", required = true)
    protected BLOQUEFUNCIONALEOGHCOType bloquefuncionaleoghco;
    @XmlElement(name = "COD_OPERATIVA", required = true)
    protected String codoperativa;

    public BLOQUEFUNCIONALEOGHCOType getBLOQUEFUNCIONALEOGHCO() {
        return this.bloquefuncionaleoghco;
    }

    public void setBLOQUEFUNCIONALEOGHCO(BLOQUEFUNCIONALEOGHCOType bLOQUEFUNCIONALEOGHCOType) {
        this.bloquefuncionaleoghco = bLOQUEFUNCIONALEOGHCOType;
    }

    public String getCODOPERATIVA() {
        return this.codoperativa;
    }

    public void setCODOPERATIVA(String str) {
        this.codoperativa = str;
    }
}
