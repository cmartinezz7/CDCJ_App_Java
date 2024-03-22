package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UNIDAD_CONVENIO_Type", propOrder = {"areaconvenio", "codunidadconvenio"})
public class UNIDADCONVENIOType {
    @XmlElement(name = "AREA_CONVENIO", required = true)
    protected AREACONVENIOType areaconvenio;
    @XmlElement(name = "COD_UNIDAD_CONVENIO", required = true)
    protected String codunidadconvenio;

    public AREACONVENIOType getAREACONVENIO() {
        return this.areaconvenio;
    }

    public void setAREACONVENIO(AREACONVENIOType aREACONVENIOType) {
        this.areaconvenio = aREACONVENIOType;
    }

    public String getCODUNIDADCONVENIO() {
        return this.codunidadconvenio;
    }

    public void setCODUNIDADCONVENIO(String str) {
        this.codunidadconvenio = str;
    }
}
