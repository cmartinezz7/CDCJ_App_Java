package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODO_BIS_CYS_Type", propOrder = {"anio", "codigomes"})
public class PERIODOBISCYSType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ANIO")
    protected int anio;
    @XmlElement(name = "CODIGO_MES", required = true)
    protected String codigomes;

    public int getANIO() {
        return this.anio;
    }

    public void setANIO(int i) {
        this.anio = i;
    }

    public String getCODIGOMES() {
        return this.codigomes;
    }

    public void setCODIGOMES(String str) {
        this.codigomes = str;
    }
}
