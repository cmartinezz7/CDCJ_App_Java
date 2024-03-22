package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RANGO_CARDINAL_GK_Type", propOrder = {"criteriovariablegk", "codrangocardinal"})
public class RANGOCARDINALGKType {
    @XmlElement(name = "COD_RANGO_CARDINAL", required = true)
    protected String codrangocardinal;
    @XmlElement(name = "CRITERIO_VARIABLE_GK", required = true)
    protected CRITERIOVARIABLEGKType criteriovariablegk;

    public CRITERIOVARIABLEGKType getCRITERIOVARIABLEGK() {
        return this.criteriovariablegk;
    }

    public void setCRITERIOVARIABLEGK(CRITERIOVARIABLEGKType cRITERIOVARIABLEGKType) {
        this.criteriovariablegk = cRITERIOVARIABLEGKType;
    }

    public String getCODRANGOCARDINAL() {
        return this.codrangocardinal;
    }

    public void setCODRANGOCARDINAL(String str) {
        this.codrangocardinal = str;
    }
}
