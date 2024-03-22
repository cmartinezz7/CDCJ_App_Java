package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OPORTUNIDAD_COPCOM_Type", propOrder = {"empresa", "codoportunidad"})
public class OPORTUNIDADCOPCOMType {
    @XmlElement(name = "COD_OPORTUNIDAD", required = true)
    protected String codoportunidad;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODOPORTUNIDAD() {
        return this.codoportunidad;
    }

    public void setCODOPORTUNIDAD(String str) {
        this.codoportunidad = str;
    }
}
