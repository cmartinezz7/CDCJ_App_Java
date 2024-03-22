package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_EXTERNO_Type", propOrder = {"centro", "numerocuenta"})
public class CONTRATOEXTERNOType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "NUMERO_CUENTA", required = true)
    protected String numerocuenta;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getNUMEROCUENTA() {
        return this.numerocuenta;
    }

    public void setNUMEROCUENTA(String str) {
        this.numerocuenta = str;
    }
}
