package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIMULACION_TPV_Type", propOrder = {"centro", "codigosimulacion"})
public class SIMULACIONTPVType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "CODIGO_SIMULACION", required = true)
    protected String codigosimulacion;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getCODIGOSIMULACION() {
        return this.codigosimulacion;
    }

    public void setCODIGOSIMULACION(String str) {
        this.codigosimulacion = str;
    }
}
