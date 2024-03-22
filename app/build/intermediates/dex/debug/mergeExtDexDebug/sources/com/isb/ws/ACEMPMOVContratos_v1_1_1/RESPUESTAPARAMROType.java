package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESPUESTA_PARAM_RO_Type", propOrder = {"codigoalfanum", "secuencialcorto"})
public class RESPUESTAPARAMROType {
    @XmlElement(name = "CODIGO_ALFANUM", required = true)
    protected String codigoalfanum;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIAL_CORTO")
    protected int secuencialcorto;

    public String getCODIGOALFANUM() {
        return this.codigoalfanum;
    }

    public void setCODIGOALFANUM(String str) {
        this.codigoalfanum = str;
    }

    public int getSECUENCIALCORTO() {
        return this.secuencialcorto;
    }

    public void setSECUENCIALCORTO(int i) {
        this.secuencialcorto = i;
    }
}
