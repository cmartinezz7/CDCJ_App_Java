package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_ACUERDO_ACBCO_Type", propOrder = {"empresa", "codacuerdo", "codtipo"})
public class IDACUERDOACBCOType {
    @XmlElement(name = "COD_ACUERDO", required = true)
    protected String codacuerdo;
    @XmlElement(name = "COD_TIPO", required = true)
    protected String codtipo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODACUERDO() {
        return this.codacuerdo;
    }

    public void setCODACUERDO(String str) {
        this.codacuerdo = str;
    }

    public String getCODTIPO() {
        return this.codtipo;
    }

    public void setCODTIPO(String str) {
        this.codtipo = str;
    }
}
