package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_ELEMENTO_Type", propOrder = {"tipoficha", "tipoelemento"})
public class TIPODEELEMENTOType {
    @XmlElement(name = "TIPO_ELEMENTO", required = true)
    protected String tipoelemento;
    @XmlElement(name = "TIPO_FICHA", required = true)
    protected String tipoficha;

    public String getTIPOFICHA() {
        return this.tipoficha;
    }

    public void setTIPOFICHA(String str) {
        this.tipoficha = str;
    }

    public String getTIPOELEMENTO() {
        return this.tipoelemento;
    }

    public void setTIPOELEMENTO(String str) {
        this.tipoelemento = str;
    }
}
