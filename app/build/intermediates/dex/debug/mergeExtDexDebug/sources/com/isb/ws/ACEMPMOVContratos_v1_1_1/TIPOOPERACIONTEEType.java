package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_OPERACION_TEE_Type", propOrder = {"tipotransacciontee", "operacionbetee"})
public class TIPOOPERACIONTEEType {
    @XmlElement(name = "OPERACION_BE_TEE", required = true)
    protected String operacionbetee;
    @XmlElement(name = "TIPO_TRANSACCION_TEE", required = true)
    protected String tipotransacciontee;

    public String getTIPOTRANSACCIONTEE() {
        return this.tipotransacciontee;
    }

    public void setTIPOTRANSACCIONTEE(String str) {
        this.tipotransacciontee = str;
    }

    public String getOPERACIONBETEE() {
        return this.operacionbetee;
    }

    public void setOPERACIONBETEE(String str) {
        this.operacionbetee = str;
    }
}
