package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GDR_ID_INFORME_Type", propOrder = {"empresa", "codinforme"})
public class GDRIDINFORMEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_INFORME")
    protected long codinforme;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public long getCODINFORME() {
        return this.codinforme;
    }

    public void setCODINFORME(long j) {
        this.codinforme = j;
    }
}
