package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_GENERAL_Type", propOrder = {"tipocontratogeneral", "detallecontratogeneral"})
public class CONTRATOGENERALType {
    @XmlElement(name = "DETALLE_CONTRATO_GENERAL", required = true)
    protected String detallecontratogeneral;
    @XmlElement(name = "TIPO_CONTRATO_GENERAL", required = true)
    protected String tipocontratogeneral;

    public String getTIPOCONTRATOGENERAL() {
        return this.tipocontratogeneral;
    }

    public void setTIPOCONTRATOGENERAL(String str) {
        this.tipocontratogeneral = str;
    }

    public String getDETALLECONTRATOGENERAL() {
        return this.detallecontratogeneral;
    }

    public void setDETALLECONTRATOGENERAL(String str) {
        this.detallecontratogeneral = str;
    }
}
