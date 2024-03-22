package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PROCESO_PCAS_Type", propOrder = {"empresa", "codproceso"})
public class PROCESOPCASType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_PROCESO")
    protected int codproceso;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODPROCESO() {
        return this.codproceso;
    }

    public void setCODPROCESO(int i) {
        this.codproceso = i;
    }
}
