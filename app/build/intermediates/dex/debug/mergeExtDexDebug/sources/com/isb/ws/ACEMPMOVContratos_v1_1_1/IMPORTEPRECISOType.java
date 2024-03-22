package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTE_PRECISO_Type", propOrder = {"numeroimportepreciso", "divisa"})
public class IMPORTEPRECISOType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUMERO_IMPORTE_PRECISO", required = true)
    protected BigDecimal numeroimportepreciso;

    public BigDecimal getNUMEROIMPORTEPRECISO() {
        return this.numeroimportepreciso;
    }

    public void setNUMEROIMPORTEPRECISO(BigDecimal bigDecimal) {
        this.numeroimportepreciso = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
