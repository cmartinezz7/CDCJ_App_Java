package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_GRUPO_CAS_Type", propOrder = {"codgrupocas", "tipgrupocas"})
public class IDGRUPOCASType {
    @XmlElement(name = "COD_GRUPO_CAS", required = true)
    protected String codgrupocas;
    @XmlElement(name = "TIP_GRUPO_CAS", required = true)
    protected String tipgrupocas;

    public String getCODGRUPOCAS() {
        return this.codgrupocas;
    }

    public void setCODGRUPOCAS(String str) {
        this.codgrupocas = str;
    }

    public String getTIPGRUPOCAS() {
        return this.tipgrupocas;
    }

    public void setTIPGRUPOCAS(String str) {
        this.tipgrupocas = str;
    }
}
