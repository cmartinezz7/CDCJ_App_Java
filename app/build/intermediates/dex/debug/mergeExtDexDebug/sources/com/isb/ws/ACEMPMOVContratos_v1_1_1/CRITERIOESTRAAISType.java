package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRITERIO_ESTRA_AIS_Type", propOrder = {"empresa", "seccriterioestra"})
public class CRITERIOESTRAAISType {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SEC_CRITERIO_ESTRA")
    protected int seccriterioestra;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getSECCRITERIOESTRA() {
        return this.seccriterioestra;
    }

    public void setSECCRITERIOESTRA(int i) {
        this.seccriterioestra = i;
    }
}
