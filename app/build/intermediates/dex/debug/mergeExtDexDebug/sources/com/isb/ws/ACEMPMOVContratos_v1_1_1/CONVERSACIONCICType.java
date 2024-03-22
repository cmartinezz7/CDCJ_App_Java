package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONVERSACION_CIC_Type", propOrder = {"interaccioncic", "nrodeconversacion"})
public class CONVERSACIONCICType {
    @XmlElement(name = "INTERACCION_CIC", required = true)
    protected INTERACCIONCICType interaccioncic;
    @XmlElement(name = "NRO_DE_CONVERSACION", required = true)
    protected String nrodeconversacion;

    public INTERACCIONCICType getINTERACCIONCIC() {
        return this.interaccioncic;
    }

    public void setINTERACCIONCIC(INTERACCIONCICType iNTERACCIONCICType) {
        this.interaccioncic = iNTERACCIONCICType;
    }

    public String getNRODECONVERSACION() {
        return this.nrodeconversacion;
    }

    public void setNRODECONVERSACION(String str) {
        this.nrodeconversacion = str;
    }
}
