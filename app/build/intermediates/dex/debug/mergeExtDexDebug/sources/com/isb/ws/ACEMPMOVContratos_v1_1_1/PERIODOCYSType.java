package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODO_CYS_Type", propOrder = {"anyo", "codigomes"})
public class PERIODOCYSType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ANYO")
    protected int anyo;
    @XmlElement(name = "CODIGO_MES", required = true)
    protected String codigomes;

    public int getANYO() {
        return this.anyo;
    }

    public void setANYO(int i) {
        this.anyo = i;
    }

    public String getCODIGOMES() {
        return this.codigomes;
    }

    public void setCODIGOMES(String str) {
        this.codigomes = str;
    }
}
