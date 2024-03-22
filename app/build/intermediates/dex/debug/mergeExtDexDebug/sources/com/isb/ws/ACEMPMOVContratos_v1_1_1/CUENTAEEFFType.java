package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUENTA_EEFF_Type", propOrder = {"plancontableeeff", "codcuenta"})
public class CUENTAEEFFType {
    @XmlElement(name = "COD_CUENTA", required = true)
    protected String codcuenta;
    @XmlElement(name = "PLAN_CONTABLE_EEFF", required = true)
    protected PLANCONTABLEEEFFType plancontableeeff;

    public PLANCONTABLEEEFFType getPLANCONTABLEEEFF() {
        return this.plancontableeeff;
    }

    public void setPLANCONTABLEEEFF(PLANCONTABLEEEFFType pLANCONTABLEEEFFType) {
        this.plancontableeeff = pLANCONTABLEEEFFType;
    }

    public String getCODCUENTA() {
        return this.codcuenta;
    }

    public void setCODCUENTA(String str) {
        this.codcuenta = str;
    }
}
