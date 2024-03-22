package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ALIANZA_MEDIADOR_Type", propOrder = {"empresa", "codigonumerico7"})
public class ALIANZAMEDIADORType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO_7")
    protected int codigonumerico7;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODIGONUMERICO7() {
        return this.codigonumerico7;
    }

    public void setCODIGONUMERICO7(int i) {
        this.codigonumerico7 = i;
    }
}
