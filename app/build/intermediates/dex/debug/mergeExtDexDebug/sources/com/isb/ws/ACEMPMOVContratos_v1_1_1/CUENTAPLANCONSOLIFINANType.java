package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CUENTA_PLAN_CONSOLI_FINAN_Type", propOrder = {"plancuenta", "codalfanum30"})
public class CUENTAPLANCONSOLIFINANType {
    @XmlElement(name = "COD_ALFANUM_30", required = true)
    protected String codalfanum30;
    @XmlElement(name = "PLAN_CUENTA", required = true)
    protected PLANCUENTACONSOLIFINANType plancuenta;

    public PLANCUENTACONSOLIFINANType getPLANCUENTA() {
        return this.plancuenta;
    }

    public void setPLANCUENTA(PLANCUENTACONSOLIFINANType pLANCUENTACONSOLIFINANType) {
        this.plancuenta = pLANCUENTACONSOLIFINANType;
    }

    public String getCODALFANUM30() {
        return this.codalfanum30;
    }

    public void setCODALFANUM30(String str) {
        this.codalfanum30 = str;
    }
}
