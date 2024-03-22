package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_LOTE_LAN_Type", propOrder = {"formatolan", "codtipolotelan"})
public class TIPOLOTELANType {
    @XmlElement(name = "COD_TIPO_LOTE_LAN", required = true)
    protected String codtipolotelan;
    @XmlElement(name = "FORMATO_LAN", required = true)
    protected FORMATOLANType formatolan;

    public FORMATOLANType getFORMATOLAN() {
        return this.formatolan;
    }

    public void setFORMATOLAN(FORMATOLANType fORMATOLANType) {
        this.formatolan = fORMATOLANType;
    }

    public String getCODTIPOLOTELAN() {
        return this.codtipolotelan;
    }

    public void setCODTIPOLOTELAN(String str) {
        this.codtipolotelan = str;
    }
}
