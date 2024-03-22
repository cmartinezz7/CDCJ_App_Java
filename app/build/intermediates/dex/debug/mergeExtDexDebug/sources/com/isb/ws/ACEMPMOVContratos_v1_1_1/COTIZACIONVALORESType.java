package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COTIZACION_VALORES_Type", propOrder = {"numeroimportevalores", "divisa"})
public class COTIZACIONVALORESType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "NUMERO_IMPORTE_VALORES", required = true)
    protected BigDecimal numeroimportevalores;

    public BigDecimal getNUMEROIMPORTEVALORES() {
        return this.numeroimportevalores;
    }

    public void setNUMEROIMPORTEVALORES(BigDecimal bigDecimal) {
        this.numeroimportevalores = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
