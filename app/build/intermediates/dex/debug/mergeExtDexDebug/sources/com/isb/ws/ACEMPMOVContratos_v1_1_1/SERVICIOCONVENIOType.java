package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SERVICIO_CONVENIO_Type", propOrder = {"unidadconvenio", "codservicioconvenio"})
public class SERVICIOCONVENIOType {
    @XmlElement(name = "COD_SERVICIO_CONVENIO", required = true)
    protected String codservicioconvenio;
    @XmlElement(name = "UNIDAD_CONVENIO", required = true)
    protected UNIDADCONVENIOType unidadconvenio;

    public UNIDADCONVENIOType getUNIDADCONVENIO() {
        return this.unidadconvenio;
    }

    public void setUNIDADCONVENIO(UNIDADCONVENIOType uNIDADCONVENIOType) {
        this.unidadconvenio = uNIDADCONVENIOType;
    }

    public String getCODSERVICIOCONVENIO() {
        return this.codservicioconvenio;
    }

    public void setCODSERVICIOCONVENIO(String str) {
        this.codservicioconvenio = str;
    }
}
