package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTE_Type", propOrder = {"importe", "divisa"})
public class IMPORTEType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "IMPORTE", required = true)
    protected BigDecimal importe;

    public BigDecimal getIMPORTE() {
        return this.importe;
    }

    public void setIMPORTE(BigDecimal bigDecimal) {
        this.importe = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
