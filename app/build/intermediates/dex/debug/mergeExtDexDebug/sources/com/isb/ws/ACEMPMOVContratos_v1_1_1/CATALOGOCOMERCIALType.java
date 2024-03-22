package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CATALOGO_COMERCIAL_Type", propOrder = {"empresa", "catalogocomercial"})
public class CATALOGOCOMERCIALType {
    @XmlElement(name = "CATALOGO_COMERCIAL", required = true)
    protected String catalogocomercial;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCATALOGOCOMERCIAL() {
        return this.catalogocomercial;
    }

    public void setCATALOGOCOMERCIAL(String str) {
        this.catalogocomercial = str;
    }
}
