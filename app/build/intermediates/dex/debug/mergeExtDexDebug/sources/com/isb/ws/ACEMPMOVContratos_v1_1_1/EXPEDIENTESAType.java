package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXPEDIENTE_SA_Type", propOrder = {"empresa", "componente2", "componente3"})
public class EXPEDIENTESAType {
    @XmlElement(name = "COMPONENTE_2", required = true)
    protected String componente2;
    @XmlElement(name = "COMPONENTE_3", required = true)
    protected String componente3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCOMPONENTE2() {
        return this.componente2;
    }

    public void setCOMPONENTE2(String str) {
        this.componente2 = str;
    }

    public String getCOMPONENTE3() {
        return this.componente3;
    }

    public void setCOMPONENTE3(String str) {
        this.componente3 = str;
    }
}
