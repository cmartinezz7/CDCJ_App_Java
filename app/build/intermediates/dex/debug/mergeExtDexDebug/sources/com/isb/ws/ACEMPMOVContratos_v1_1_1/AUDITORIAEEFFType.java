package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUDITORIA_EEFF_Type", propOrder = {"empresa", "codigonumerico"})
public class AUDITORIAEEFFType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO")
    protected int codigonumerico;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODIGONUMERICO() {
        return this.codigonumerico;
    }

    public void setCODIGONUMERICO(int i) {
        this.codigonumerico = i;
    }
}
