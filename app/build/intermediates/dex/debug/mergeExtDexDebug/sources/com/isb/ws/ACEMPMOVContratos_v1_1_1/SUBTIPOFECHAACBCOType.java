package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_FECHA_ACBCO_Type", propOrder = {"tipofechaacbco", "codsubtipofecha"})
public class SUBTIPOFECHAACBCOType {
    @XmlElement(name = "COD_SUBTIPO_FECHA", required = true)
    protected String codsubtipofecha;
    @XmlElement(name = "TIPO_FECHA_ACBCO", required = true)
    protected String tipofechaacbco;

    public String getTIPOFECHAACBCO() {
        return this.tipofechaacbco;
    }

    public void setTIPOFECHAACBCO(String str) {
        this.tipofechaacbco = str;
    }

    public String getCODSUBTIPOFECHA() {
        return this.codsubtipofecha;
    }

    public void setCODSUBTIPOFECHA(String str) {
        this.codsubtipofecha = str;
    }
}
