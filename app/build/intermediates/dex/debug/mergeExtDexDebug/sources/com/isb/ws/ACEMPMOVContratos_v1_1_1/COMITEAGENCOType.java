package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMITE_AGENCO_Type", propOrder = {"empresa", "codigonumerico10"})
public class COMITEAGENCOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO_10")
    protected long codigonumerico10;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODIGONUMERICO10() {
        return this.codigonumerico10;
    }

    public void setCODIGONUMERICO10(long j) {
        this.codigonumerico10 = j;
    }
}
