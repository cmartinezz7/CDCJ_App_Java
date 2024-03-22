package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INDICADOR_AMBITO_Type", propOrder = {"ambitointernoro", "indicadorro"})
public class INDICADORAMBITOType {
    @XmlElement(name = "AMBITO_INTERNO_RO", required = true)
    protected String ambitointernoro;
    @XmlElement(name = "INDICADOR_RO", required = true)
    protected String indicadorro;

    public String getAMBITOINTERNORO() {
        return this.ambitointernoro;
    }

    public void setAMBITOINTERNORO(String str) {
        this.ambitointernoro = str;
    }

    public String getINDICADORRO() {
        return this.indicadorro;
    }

    public void setINDICADORRO(String str) {
        this.indicadorro = str;
    }
}
