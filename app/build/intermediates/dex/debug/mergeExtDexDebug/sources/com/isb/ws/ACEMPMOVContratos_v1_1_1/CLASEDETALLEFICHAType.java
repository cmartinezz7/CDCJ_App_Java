package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLASE_DETALLE_FICHA_Type", propOrder = {"subtipodetalleficha", "clasedetalleficha"})
public class CLASEDETALLEFICHAType {
    @XmlElement(name = "CLASE_DETALLE_FICHA", required = true)
    protected String clasedetalleficha;
    @XmlElement(name = "SUBTIPO_DETALLE_FICHA", required = true)
    protected SUBTIPODETALLEFICHAType subtipodetalleficha;

    public SUBTIPODETALLEFICHAType getSUBTIPODETALLEFICHA() {
        return this.subtipodetalleficha;
    }

    public void setSUBTIPODETALLEFICHA(SUBTIPODETALLEFICHAType sUBTIPODETALLEFICHAType) {
        this.subtipodetalleficha = sUBTIPODETALLEFICHAType;
    }

    public String getCLASEDETALLEFICHA() {
        return this.clasedetalleficha;
    }

    public void setCLASEDETALLEFICHA(String str) {
        this.clasedetalleficha = str;
    }
}
