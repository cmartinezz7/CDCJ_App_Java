package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLASE_DE_TRASPASO_Type", propOrder = {"tipotraspaso", "codclasetraspaso"})
public class CLASEDETRASPASOType {
    @XmlElement(name = "COD_CLASE_TRASPASO", required = true)
    protected String codclasetraspaso;
    @XmlElement(name = "TIPO_TRASPASO", required = true)
    protected String tipotraspaso;

    public String getTIPOTRASPASO() {
        return this.tipotraspaso;
    }

    public void setTIPOTRASPASO(String str) {
        this.tipotraspaso = str;
    }

    public String getCODCLASETRASPASO() {
        return this.codclasetraspaso;
    }

    public void setCODCLASETRASPASO(String str) {
        this.codclasetraspaso = str;
    }
}
