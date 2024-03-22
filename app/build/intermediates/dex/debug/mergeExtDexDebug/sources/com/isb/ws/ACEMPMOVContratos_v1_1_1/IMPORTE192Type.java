package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTE_19_2_Type", propOrder = {"numimporte192", "divisa"})
public class IMPORTE192Type {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUM_IMPORTE_19_2", required = true)
    protected BigDecimal numimporte192;

    public BigDecimal getNUMIMPORTE192() {
        return this.numimporte192;
    }

    public void setNUMIMPORTE192(BigDecimal bigDecimal) {
        this.numimporte192 = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
