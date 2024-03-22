package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DE_EVENTO_Type", propOrder = {"tipodeevento", "codsubtipodeevento"})
public class SUBTIPODEEVENTOType {
    @XmlElement(name = "COD_SUBTIPO_DE_EVENTO", required = true)
    protected String codsubtipodeevento;
    @XmlElement(name = "TIPO_DE_EVENTO", required = true)
    protected TIPODEEVENTOType tipodeevento;

    public TIPODEEVENTOType getTIPODEEVENTO() {
        return this.tipodeevento;
    }

    public void setTIPODEEVENTO(TIPODEEVENTOType tIPODEEVENTOType) {
        this.tipodeevento = tIPODEEVENTOType;
    }

    public String getCODSUBTIPODEEVENTO() {
        return this.codsubtipodeevento;
    }

    public void setCODSUBTIPODEEVENTO(String str) {
        this.codsubtipodeevento = str;
    }
}
