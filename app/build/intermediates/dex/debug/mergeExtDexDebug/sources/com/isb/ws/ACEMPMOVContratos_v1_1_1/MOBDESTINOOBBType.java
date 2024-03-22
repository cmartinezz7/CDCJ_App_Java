package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_DESTINO_OBB_Type", propOrder = {"entorno", "empresa", "plataforma"})
public class MOBDESTINOOBBType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ENTORNO", required = true)
    protected String entorno;
    @XmlElement(name = "PLATAFORMA", required = true)
    protected String plataforma;

    public String getENTORNO() {
        return this.entorno;
    }

    public void setENTORNO(String str) {
        this.entorno = str;
    }

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getPLATAFORMA() {
        return this.plataforma;
    }

    public void setPLATAFORMA(String str) {
        this.plataforma = str;
    }
}
