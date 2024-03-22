package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCION_LIMITE_MISPAG_Type", propOrder = {"empresa", "canaldeentrada", "accion2"})
public class ACCIONLIMITEMISPAGType {
    @XmlElement(name = "ACCION2", required = true)
    protected String accion2;
    @XmlElement(name = "CANAL_DE_ENTRADA", required = true)
    protected String canaldeentrada;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANALDEENTRADA() {
        return this.canaldeentrada;
    }

    public void setCANALDEENTRADA(String str) {
        this.canaldeentrada = str;
    }

    public String getACCION2() {
        return this.accion2;
    }

    public void setACCION2(String str) {
        this.accion2 = str;
    }
}
