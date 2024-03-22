package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_TIPO_BUSQUEDA_Type", propOrder = {"bitipobien", "codtipobusqueda"})
public class BITIPOBUSQUEDAType {
    @XmlElement(name = "BI_TIPO_BIEN", required = true)
    protected String bitipobien;
    @XmlElement(name = "COD_TIPO_BUSQUEDA", required = true)
    protected String codtipobusqueda;

    public String getBITIPOBIEN() {
        return this.bitipobien;
    }

    public void setBITIPOBIEN(String str) {
        this.bitipobien = str;
    }

    public String getCODTIPOBUSQUEDA() {
        return this.codtipobusqueda;
    }

    public void setCODTIPOBUSQUEDA(String str) {
        this.codtipobusqueda = str;
    }
}
