package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_POSTAL_USA_Type", propOrder = {"codpostal", "detallecp"})
public class CODIGOPOSTALUSAType {
    @XmlElement(name = "COD_POSTAL", required = true)
    protected String codpostal;
    @XmlElement(name = "DETALLE_CP", required = true)
    protected String detallecp;

    public String getCODPOSTAL() {
        return this.codpostal;
    }

    public void setCODPOSTAL(String str) {
        this.codpostal = str;
    }

    public String getDETALLECP() {
        return this.detallecp;
    }

    public void setDETALLECP(String str) {
        this.detallecp = str;
    }
}
