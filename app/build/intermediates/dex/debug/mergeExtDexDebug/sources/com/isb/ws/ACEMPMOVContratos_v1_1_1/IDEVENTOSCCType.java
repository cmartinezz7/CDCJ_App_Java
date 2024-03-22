package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_EVENTO_SCC_Type", propOrder = {"empresa", "codevento"})
public class IDEVENTOSCCType {
    @XmlElement(name = "COD_EVENTO", required = true)
    protected String codevento;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODEVENTO() {
        return this.codevento;
    }

    public void setCODEVENTO(String str) {
        this.codevento = str;
    }
}
