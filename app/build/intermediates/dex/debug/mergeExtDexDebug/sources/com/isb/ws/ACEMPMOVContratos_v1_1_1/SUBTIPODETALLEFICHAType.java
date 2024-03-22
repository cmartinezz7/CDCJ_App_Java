package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DETALLE_FICHA_Type", propOrder = {"tipodetalleficha", "subtipodetalleficha"})
public class SUBTIPODETALLEFICHAType {
    @XmlElement(name = "SUBTIPO_DETALLE_FICHA", required = true)
    protected String subtipodetalleficha;
    @XmlElement(name = "TIPO_DETALLE_FICHA", required = true)
    protected String tipodetalleficha;

    public String getTIPODETALLEFICHA() {
        return this.tipodetalleficha;
    }

    public void setTIPODETALLEFICHA(String str) {
        this.tipodetalleficha = str;
    }

    public String getSUBTIPODETALLEFICHA() {
        return this.subtipodetalleficha;
    }

    public void setSUBTIPODETALLEFICHA(String str) {
        this.subtipodetalleficha = str;
    }
}
