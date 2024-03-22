package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAMO_HORARIO_CUTOFF_GOP_Type", propOrder = {"empresa", "string"})
public class TRAMOHORARIOCUTOFFGOPType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "STRING", required = true)
    protected String string;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getSTRING() {
        return this.string;
    }

    public void setSTRING(String str) {
        this.string = str;
    }
}
