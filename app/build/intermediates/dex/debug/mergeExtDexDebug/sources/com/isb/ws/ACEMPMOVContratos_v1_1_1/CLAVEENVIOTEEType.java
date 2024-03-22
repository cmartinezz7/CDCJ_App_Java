package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLAVE_ENVIO_TEE_Type", propOrder = {"pspdeclarante", "periododeclaracion"})
public class CLAVEENVIOTEEType {
    @XmlElement(name = "PERIODO_DECLARACION", required = true)
    protected String periododeclaracion;
    @XmlElement(name = "PSP_DECLARANTE", required = true)
    protected String pspdeclarante;

    public String getPSPDECLARANTE() {
        return this.pspdeclarante;
    }

    public void setPSPDECLARANTE(String str) {
        this.pspdeclarante = str;
    }

    public String getPERIODODECLARACION() {
        return this.periododeclaracion;
    }

    public void setPERIODODECLARACION(String str) {
        this.periododeclaracion = str;
    }
}
