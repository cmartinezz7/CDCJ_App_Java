package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DE_ELEMENTO_Type", propOrder = {"tipodeelemento", "subtipoelemento"})
public class SUBTIPODEELEMENTOType {
    @XmlElement(name = "SUBTIPO_ELEMENTO", required = true)
    protected String subtipoelemento;
    @XmlElement(name = "TIPO_DE_ELEMENTO", required = true)
    protected TIPODEELEMENTOType tipodeelemento;

    public TIPODEELEMENTOType getTIPODEELEMENTO() {
        return this.tipodeelemento;
    }

    public void setTIPODEELEMENTO(TIPODEELEMENTOType tIPODEELEMENTOType) {
        this.tipodeelemento = tIPODEELEMENTOType;
    }

    public String getSUBTIPOELEMENTO() {
        return this.subtipoelemento;
    }

    public void setSUBTIPOELEMENTO(String str) {
        this.subtipoelemento = str;
    }
}
