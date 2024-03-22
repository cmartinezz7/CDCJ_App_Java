package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODICIDAD_EEFF_Type", propOrder = {"empresaeeff", "codperiodeeff"})
public class PERIODICIDADEEFFType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODPERIOD_EEFF")
    protected int codperiodeeff;
    @XmlElement(name = "EMPRESA_EEFF", required = true)
    protected String empresaeeff;

    public String getEMPRESAEEFF() {
        return this.empresaeeff;
    }

    public void setEMPRESAEEFF(String str) {
        this.empresaeeff = str;
    }

    public int getCODPERIODEEFF() {
        return this.codperiodeeff;
    }

    public void setCODPERIODEEFF(int i) {
        this.codperiodeeff = i;
    }
}
