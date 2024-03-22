package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMUNICACION_COPCOM_Type", propOrder = {"oportunidadcopcom", "codcanalcomercial", "codcomunicacion"})
public class COMUNICACIONCOPCOMType {
    @XmlElement(name = "COD_CANAL_COMERCIAL", required = true)
    protected String codcanalcomercial;
    @XmlElement(name = "COD_COMUNICACION", required = true)
    protected String codcomunicacion;
    @XmlElement(name = "OPORTUNIDAD_COPCOM", required = true)
    protected OPORTUNIDADCOPCOMType oportunidadcopcom;

    public OPORTUNIDADCOPCOMType getOPORTUNIDADCOPCOM() {
        return this.oportunidadcopcom;
    }

    public void setOPORTUNIDADCOPCOM(OPORTUNIDADCOPCOMType oPORTUNIDADCOPCOMType) {
        this.oportunidadcopcom = oPORTUNIDADCOPCOMType;
    }

    public String getCODCANALCOMERCIAL() {
        return this.codcanalcomercial;
    }

    public void setCODCANALCOMERCIAL(String str) {
        this.codcanalcomercial = str;
    }

    public String getCODCOMUNICACION() {
        return this.codcomunicacion;
    }

    public void setCODCOMUNICACION(String str) {
        this.codcomunicacion = str;
    }
}
