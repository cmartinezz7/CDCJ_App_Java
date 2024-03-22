package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIT_CONCEPTO_CONTRATO_Type", propOrder = {"tipomovimiento", "situacionconceptocontr"})
public class SITCONCEPTOCONTRATOType {
    @XmlElement(name = "SITUACION_CONCEPTO_CONTR_", required = true)
    protected String situacionconceptocontr;
    @XmlElement(name = "TIPO_MOVIMIENTO", required = true)
    protected String tipomovimiento;

    public String getTIPOMOVIMIENTO() {
        return this.tipomovimiento;
    }

    public void setTIPOMOVIMIENTO(String str) {
        this.tipomovimiento = str;
    }

    public String getSITUACIONCONCEPTOCONTR() {
        return this.situacionconceptocontr;
    }

    public void setSITUACIONCONCEPTOCONTR(String str) {
        this.situacionconceptocontr = str;
    }
}
