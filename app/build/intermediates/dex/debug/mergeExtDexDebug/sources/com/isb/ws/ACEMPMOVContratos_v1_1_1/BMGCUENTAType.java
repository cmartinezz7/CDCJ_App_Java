package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_CUENTA_Type", propOrder = {"codigobic", "bmgnumerocuenta"})
public class BMGCUENTAType {
    @XmlElement(name = "BMG_NUMERO_CUENTA", required = true)
    protected String bmgnumerocuenta;
    @XmlElement(name = "CODIGO_BIC", required = true)
    protected CODIGOBICType codigobic;

    public CODIGOBICType getCODIGOBIC() {
        return this.codigobic;
    }

    public void setCODIGOBIC(CODIGOBICType cODIGOBICType) {
        this.codigobic = cODIGOBICType;
    }

    public String getBMGNUMEROCUENTA() {
        return this.bmgnumerocuenta;
    }

    public void setBMGNUMEROCUENTA(String str) {
        this.bmgnumerocuenta = str;
    }
}
