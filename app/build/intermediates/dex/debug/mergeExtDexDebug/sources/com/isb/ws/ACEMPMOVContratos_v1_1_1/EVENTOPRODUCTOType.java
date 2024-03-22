package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENTO_PRODUCTO_Type", propOrder = {"empresa", "codtipevento"})
public class EVENTOPRODUCTOType {
    @XmlElement(name = "COD_TIP_EVENTO", required = true)
    protected String codtipevento;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODTIPEVENTO() {
        return this.codtipevento;
    }

    public void setCODTIPEVENTO(String str) {
        this.codtipevento = str;
    }
}
