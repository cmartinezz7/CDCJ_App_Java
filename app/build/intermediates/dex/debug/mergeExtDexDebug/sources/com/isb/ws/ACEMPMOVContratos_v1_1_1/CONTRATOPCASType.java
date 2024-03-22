package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PCAS_Type", propOrder = {"centro", "cuentatja"})
public class CONTRATOPCASType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CUENTA_TJA", required = true)
    protected String cuentatja;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCUENTATJA() {
        return this.cuentatja;
    }

    public void setCUENTATJA(String str) {
        this.cuentatja = str;
    }
}
