package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_LOCAL_Type", propOrder = {"tipocontratolocal", "detallecontratolocal"})
public class CONTRATOLOCALType {
    @XmlElement(name = "DETALLE_CONTRATO_LOCAL", required = true)
    protected String detallecontratolocal;
    @XmlElement(name = "TIPO_CONTRATO_LOCAL", required = true)
    protected String tipocontratolocal;

    public String getTIPOCONTRATOLOCAL() {
        return this.tipocontratolocal;
    }

    public void setTIPOCONTRATOLOCAL(String str) {
        this.tipocontratolocal = str;
    }

    public String getDETALLECONTRATOLOCAL() {
        return this.detallecontratolocal;
    }

    public void setDETALLECONTRATOLOCAL(String str) {
        this.detallecontratolocal = str;
    }
}
