package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DESGLOSE_DIVISA_Type", propOrder = {"divisa", "indicadortipodivisa", "valordivisa"})
public class DESGLOSEDIVISAType {
    @XmlElement(name = "DIVISA", required = true)
    protected String divisa;
    @XmlElement(name = "INDICADOR_TIPO_DIVISA", required = true)
    protected String indicadortipodivisa;
    @XmlElement(name = "VALOR_DIVISA", required = true)
    protected BigDecimal valordivisa;

    public String getDIVISA() {
        return this.divisa;
    }

    public void setDIVISA(String str) {
        this.divisa = str;
    }

    public String getINDICADORTIPODIVISA() {
        return this.indicadortipodivisa;
    }

    public void setINDICADORTIPODIVISA(String str) {
        this.indicadortipodivisa = str;
    }

    public BigDecimal getVALORDIVISA() {
        return this.valordivisa;
    }

    public void setVALORDIVISA(BigDecimal bigDecimal) {
        this.valordivisa = bigDecimal;
    }
}
