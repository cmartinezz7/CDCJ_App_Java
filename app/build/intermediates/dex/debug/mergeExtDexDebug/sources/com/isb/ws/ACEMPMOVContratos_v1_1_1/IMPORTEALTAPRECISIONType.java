package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTE_ALTA_PRECISION_Type", propOrder = {"numimportealtaprecision", "divisa"})
public class IMPORTEALTAPRECISIONType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUMIMPORTE_ALTA_PRECISION", required = true)
    protected BigDecimal numimportealtaprecision;

    public BigDecimal getNUMIMPORTEALTAPRECISION() {
        return this.numimportealtaprecision;
    }

    public void setNUMIMPORTEALTAPRECISION(BigDecimal bigDecimal) {
        this.numimportealtaprecision = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
