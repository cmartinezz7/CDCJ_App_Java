package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_AGRUPACION_FONDO_Type", propOrder = {"tipoagrupacionfondo", "operacionbancaria"})
public class SUBTIPOAGRUPACIONFONDOType {
    @XmlElement(name = "OPERACION_BANCARIA", required = true)
    protected OPERACIONBANCARIAType operacionbancaria;
    @XmlElement(name = "TIPO_AGRUPACION_FONDO", required = true)
    protected String tipoagrupacionfondo;

    public String getTIPOAGRUPACIONFONDO() {
        return this.tipoagrupacionfondo;
    }

    public void setTIPOAGRUPACIONFONDO(String str) {
        this.tipoagrupacionfondo = str;
    }

    public OPERACIONBANCARIAType getOPERACIONBANCARIA() {
        return this.operacionbancaria;
    }

    public void setOPERACIONBANCARIA(OPERACIONBANCARIAType oPERACIONBANCARIAType) {
        this.operacionbancaria = oPERACIONBANCARIAType;
    }
}
