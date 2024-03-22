package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GRUPO_SERVICIOS_CANAL_CSC_Type", propOrder = {"critagrserviccanalcsc", "codgruposervicio"})
public class GRUPOSERVICIOSCANALCSCType {
    @XmlElement(name = "COD_GRUPO_SERVICIO", required = true)
    protected String codgruposervicio;
    @XmlElement(name = "CRIT_AGR_SERVIC_CANAL_CSC", required = true)
    protected CRITAGRSERVICCANALCSCType critagrserviccanalcsc;

    public CRITAGRSERVICCANALCSCType getCRITAGRSERVICCANALCSC() {
        return this.critagrserviccanalcsc;
    }

    public void setCRITAGRSERVICCANALCSC(CRITAGRSERVICCANALCSCType cRITAGRSERVICCANALCSCType) {
        this.critagrserviccanalcsc = cRITAGRSERVICCANALCSCType;
    }

    public String getCODGRUPOSERVICIO() {
        return this.codgruposervicio;
    }

    public void setCODGRUPOSERVICIO(String str) {
        this.codgruposervicio = str;
    }
}
