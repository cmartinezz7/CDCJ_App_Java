package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MAESTRA_ATRIBUTO_Type", propOrder = {"atributo", "secuencialcorto"})
public class MAESTRAATRIBUTOType {
    @XmlElement(name = "ATRIBUTO", required = true)
    protected String atributo;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIAL_CORTO")
    protected int secuencialcorto;

    public String getATRIBUTO() {
        return this.atributo;
    }

    public void setATRIBUTO(String str) {
        this.atributo = str;
    }

    public int getSECUENCIALCORTO() {
        return this.secuencialcorto;
    }

    public void setSECUENCIALCORTO(int i) {
        this.secuencialcorto = i;
    }
}
