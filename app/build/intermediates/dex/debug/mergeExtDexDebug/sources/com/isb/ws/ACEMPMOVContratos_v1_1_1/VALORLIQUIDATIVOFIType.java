package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_LIQUIDATIVO_FI_Type", propOrder = {"valorliquidativo", "divisa"})
public class VALORLIQUIDATIVOFIType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "VALOR_LIQUIDATIVO", required = true)
    protected BigDecimal valorliquidativo;

    public BigDecimal getVALORLIQUIDATIVO() {
        return this.valorliquidativo;
    }

    public void setVALORLIQUIDATIVO(BigDecimal bigDecimal) {
        this.valorliquidativo = bigDecimal;
    }

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }
}
