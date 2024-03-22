package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_PARAMETRO_Type", propOrder = {"codsubaplicacion", "tipparametro"})
public class TIPOPARAMETROType {
    @XmlElement(name = "COD_SUBAPLICACION", required = true)
    protected String codsubaplicacion;
    @XmlElement(name = "TIP_PARAMETRO", required = true)
    protected String tipparametro;

    public String getCODSUBAPLICACION() {
        return this.codsubaplicacion;
    }

    public void setCODSUBAPLICACION(String str) {
        this.codsubaplicacion = str;
    }

    public String getTIPPARAMETRO() {
        return this.tipparametro;
    }

    public void setTIPPARAMETRO(String str) {
        this.tipparametro = str;
    }
}
