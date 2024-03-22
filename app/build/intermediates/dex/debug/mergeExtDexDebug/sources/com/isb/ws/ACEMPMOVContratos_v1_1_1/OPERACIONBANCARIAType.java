package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPERACION_BANCARIA_Type", propOrder = {"operacionbasica", "operacionbancaria"})
public class OPERACIONBANCARIAType {
    @XmlElement(name = "OPERACION_BANCARIA", required = true)
    protected String operacionbancaria;
    @XmlElement(name = "OPERACION_BASICA", required = true)
    protected String operacionbasica;

    public String getOPERACIONBASICA() {
        return this.operacionbasica;
    }

    public void setOPERACIONBASICA(String str) {
        this.operacionbasica = str;
    }

    public String getOPERACIONBANCARIA() {
        return this.operacionbancaria;
    }

    public void setOPERACIONBANCARIA(String str) {
        this.operacionbancaria = str;
    }
}
