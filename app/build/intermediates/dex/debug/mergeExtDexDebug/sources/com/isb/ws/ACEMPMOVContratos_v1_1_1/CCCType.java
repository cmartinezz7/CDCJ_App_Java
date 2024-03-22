package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CCC_Type", propOrder = {"oficina", "digitodecontrol", "numerodecuenta"})
public class CCCType {
    @XmlElement(name = "DIGITO_DE_CONTROL", required = true)
    protected String digitodecontrol;
    @XmlElement(name = "NUMERO_DE_CUENTA", required = true)
    protected String numerodecuenta;
    @XmlElement(name = "OFICINA", required = true)
    protected OFICINABANCARIAType oficina;

    public OFICINABANCARIAType getOFICINA() {
        return this.oficina;
    }

    public void setOFICINA(OFICINABANCARIAType oFICINABANCARIAType) {
        this.oficina = oFICINABANCARIAType;
    }

    public String getDIGITODECONTROL() {
        return this.digitodecontrol;
    }

    public void setDIGITODECONTROL(String str) {
        this.digitodecontrol = str;
    }

    public String getNUMERODECUENTA() {
        return this.numerodecuenta;
    }

    public void setNUMERODECUENTA(String str) {
        this.numerodecuenta = str;
    }
}
