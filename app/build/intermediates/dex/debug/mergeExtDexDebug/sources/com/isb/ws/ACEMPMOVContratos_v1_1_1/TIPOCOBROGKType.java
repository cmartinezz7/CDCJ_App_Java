package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_COBRO_GK_Type", propOrder = {"empresa", "codtipocobro"})
public class TIPOCOBROGKType {
    @XmlElement(name = "COD_TIPO_COBRO", required = true)
    protected String codtipocobro;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODTIPOCOBRO() {
        return this.codtipocobro;
    }

    public void setCODTIPOCOBRO(String str) {
        this.codtipocobro = str;
    }
}
