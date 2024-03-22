package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BI_BIEN_LOCAL_Type", propOrder = {"empresa", "bitipobusqueda", "codlocalbien"})
public class BIBIENLOCALType {
    @XmlElement(name = "BI_TIPO_BUSQUEDA", required = true)
    protected BITIPOBUSQUEDAType bitipobusqueda;
    @XmlElement(name = "COD_LOCAL_BIEN", required = true)
    protected String codlocalbien;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public BITIPOBUSQUEDAType getBITIPOBUSQUEDA() {
        return this.bitipobusqueda;
    }

    public void setBITIPOBUSQUEDA(BITIPOBUSQUEDAType bITIPOBUSQUEDAType) {
        this.bitipobusqueda = bITIPOBUSQUEDAType;
    }

    public String getCODLOCALBIEN() {
        return this.codlocalbien;
    }

    public void setCODLOCALBIEN(String str) {
        this.codlocalbien = str;
    }
}
