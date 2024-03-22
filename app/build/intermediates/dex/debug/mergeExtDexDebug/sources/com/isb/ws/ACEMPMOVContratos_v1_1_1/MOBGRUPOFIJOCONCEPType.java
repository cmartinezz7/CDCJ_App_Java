package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_GRUPO_FIJO_CONCEP_Type", propOrder = {"tipooperacion", "claseoperacion"})
public class MOBGRUPOFIJOCONCEPType {
    @XmlElement(name = "CLASE_OPERACION", required = true)
    protected String claseoperacion;
    @XmlElement(name = "TIPO_OPERACION", required = true)
    protected String tipooperacion;

    public String getTIPOOPERACION() {
        return this.tipooperacion;
    }

    public void setTIPOOPERACION(String str) {
        this.tipooperacion = str;
    }

    public String getCLASEOPERACION() {
        return this.claseoperacion;
    }

    public void setCLASEOPERACION(String str) {
        this.claseoperacion = str;
    }
}
