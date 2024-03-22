package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXCEPCION_COTIZACIO_EDIST_Type", propOrder = {"cotizacionedist", "tipoexcepcionedist"})
public class EXCEPCIONCOTIZACIOEDISTType {
    @XmlElement(name = "COTIZACION_EDIST", required = true)
    protected COTIZACIONEDISTType cotizacionedist;
    @XmlElement(name = "TIPO_EXCEPCION_EDIST", required = true)
    protected String tipoexcepcionedist;

    public COTIZACIONEDISTType getCOTIZACIONEDIST() {
        return this.cotizacionedist;
    }

    public void setCOTIZACIONEDIST(COTIZACIONEDISTType cOTIZACIONEDISTType) {
        this.cotizacionedist = cOTIZACIONEDISTType;
    }

    public String getTIPOEXCEPCIONEDIST() {
        return this.tipoexcepcionedist;
    }

    public void setTIPOEXCEPCIONEDIST(String str) {
        this.tipoexcepcionedist = str;
    }
}
