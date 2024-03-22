package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MODALIDAD_PAGO_TARJETA_Type", propOrder = {"formapagotarjeta", "codmodalidadpago"})
public class MODALIDADPAGOTARJETAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_MODALIDAD_PAGO")
    protected int codmodalidadpago;
    @XmlElement(name = "FORMA_PAGO_TARJETA", required = true)
    protected String formapagotarjeta;

    public String getFORMAPAGOTARJETA() {
        return this.formapagotarjeta;
    }

    public void setFORMAPAGOTARJETA(String str) {
        this.formapagotarjeta = str;
    }

    public int getCODMODALIDADPAGO() {
        return this.codmodalidadpago;
    }

    public void setCODMODALIDADPAGO(int i) {
        this.codmodalidadpago = i;
    }
}
