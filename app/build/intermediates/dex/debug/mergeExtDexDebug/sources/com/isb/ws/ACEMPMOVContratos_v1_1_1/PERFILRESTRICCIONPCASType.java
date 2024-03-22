package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERFIL_RESTRICCION_PCAS_Type", propOrder = {"empresa", "codperfilrestriccion"})
public class PERFILRESTRICCIONPCASType {
    @XmlElement(name = "COD_PERFIL_RESTRICCION", required = true)
    protected String codperfilrestriccion;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODPERFILRESTRICCION() {
        return this.codperfilrestriccion;
    }

    public void setCODPERFILRESTRICCION(String str) {
        this.codperfilrestriccion = str;
    }
}
