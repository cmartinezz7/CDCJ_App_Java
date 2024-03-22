package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_NEGOCIO_CORP_2_Type", propOrder = {"lineanegociocorp1", "idlineanegociocorp2"})
public class LINEANEGOCIOCORP2Type {
    @XmlElement(name = "ID_LINEA_NEGOCIO_CORP_2", required = true)
    protected String idlineanegociocorp2;
    @XmlElement(name = "LINEA_NEGOCIO_CORP_1", required = true)
    protected String lineanegociocorp1;

    public String getLINEANEGOCIOCORP1() {
        return this.lineanegociocorp1;
    }

    public void setLINEANEGOCIOCORP1(String str) {
        this.lineanegociocorp1 = str;
    }

    public String getIDLINEANEGOCIOCORP2() {
        return this.idlineanegociocorp2;
    }

    public void setIDLINEANEGOCIOCORP2(String str) {
        this.idlineanegociocorp2 = str;
    }
}
