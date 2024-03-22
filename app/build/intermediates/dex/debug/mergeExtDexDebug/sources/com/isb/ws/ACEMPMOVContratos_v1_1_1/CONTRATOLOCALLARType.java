package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_LOCAL_LAR_Type", propOrder = {"tipocontrato", "cuenta40"})
public class CONTRATOLOCALLARType {
    @XmlElement(name = "CUENTA_40", required = true)
    protected String cuenta40;
    @XmlElement(name = "TIPO_CONTRATO", required = true)
    protected String tipocontrato;

    public String getTIPOCONTRATO() {
        return this.tipocontrato;
    }

    public void setTIPOCONTRATO(String str) {
        this.tipocontrato = str;
    }

    public String getCUENTA40() {
        return this.cuenta40;
    }

    public void setCUENTA40(String str) {
        this.cuenta40 = str;
    }
}
