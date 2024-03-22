package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTE_15_15_Type", propOrder = {"numimporte1515", "divisa"})
public class IMPORTE1515Type {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUM_IMPORTE_15_15", required = true)
    protected BigDecimal numimporte1515;

    public BigDecimal getNUMIMPORTE1515() {
        return this.numimporte1515;
    }

    public void setNUMIMPORTE1515(BigDecimal bigDecimal) {
        this.numimporte1515 = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
