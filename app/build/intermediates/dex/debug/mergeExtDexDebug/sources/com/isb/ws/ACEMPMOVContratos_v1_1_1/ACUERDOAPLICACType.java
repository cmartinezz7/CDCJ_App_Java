package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACUERDO_APLIC_AC_Type", propOrder = {"empresa", "tipoacuerdo", "codrolacuerdo", "codaplicac"})
public class ACUERDOAPLICACType {
    @XmlElement(name = "COD_APLIC_AC", required = true)
    protected String codaplicac;
    @XmlElement(name = "COD_ROL_ACUERDO", required = true)
    protected String codrolacuerdo;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_ACUERDO", required = true)
    protected String tipoacuerdo;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOACUERDO() {
        return this.tipoacuerdo;
    }

    public void setTIPOACUERDO(String str) {
        this.tipoacuerdo = str;
    }

    public String getCODROLACUERDO() {
        return this.codrolacuerdo;
    }

    public void setCODROLACUERDO(String str) {
        this.codrolacuerdo = str;
    }

    public String getCODAPLICAC() {
        return this.codaplicac;
    }

    public void setCODAPLICAC(String str) {
        this.codaplicac = str;
    }
}
