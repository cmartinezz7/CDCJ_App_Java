package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PT_NUMERO_CUENTA_CLIENTE_Type", propOrder = {"ptoficina", "ptnumerodecuenta"})
public class PTNUMEROCUENTACLIENTEType {
    @XmlElement(name = "PT_NUMERO_DE_CUENTA", required = true)
    protected String ptnumerodecuenta;
    @XmlElement(name = "PT_OFICINA", required = true)
    protected String ptoficina;

    public String getPTOFICINA() {
        return this.ptoficina;
    }

    public void setPTOFICINA(String str) {
        this.ptoficina = str;
    }

    public String getPTNUMERODECUENTA() {
        return this.ptnumerodecuenta;
    }

    public void setPTNUMERODECUENTA(String str) {
        this.ptnumerodecuenta = str;
    }
}
