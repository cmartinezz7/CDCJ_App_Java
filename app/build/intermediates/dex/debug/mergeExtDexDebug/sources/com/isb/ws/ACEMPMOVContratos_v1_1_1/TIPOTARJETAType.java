package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_TARJETA_Type", propOrder = {"marcatarjeta", "indtipotarjeta"})
public class TIPOTARJETAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "IND_TIPO_TARJETA")
    protected int indtipotarjeta;
    @XmlElement(name = "MARCA_TARJETA", required = true)
    protected MARCATARJETAType marcatarjeta;

    public MARCATARJETAType getMARCATARJETA() {
        return this.marcatarjeta;
    }

    public void setMARCATARJETA(MARCATARJETAType mARCATARJETAType) {
        this.marcatarjeta = mARCATARJETAType;
    }

    public int getINDTIPOTARJETA() {
        return this.indtipotarjeta;
    }

    public void setINDTIPOTARJETA(int i) {
        this.indtipotarjeta = i;
    }
}
