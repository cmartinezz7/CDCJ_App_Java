package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCION_DEL_AVISO_Type", propOrder = {"cdcircuito", "cdaccion"})
public class ACCIONDELAVISOType {
    @XmlElement(name = "CD_ACCION", required = true)
    protected String cdaccion;
    @XmlElement(name = "CD_CIRCUITO", required = true)
    protected String cdcircuito;

    public String getCDCIRCUITO() {
        return this.cdcircuito;
    }

    public void setCDCIRCUITO(String str) {
        this.cdcircuito = str;
    }

    public String getCDACCION() {
        return this.cdaccion;
    }

    public void setCDACCION(String str) {
        this.cdaccion = str;
    }
}
