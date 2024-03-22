package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXPEDIENTE_FEVE_Type", propOrder = {"empresa", "codexpedfev"})
public class EXPEDIENTEFEVEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_EXPED_FEV")
    protected int codexpedfev;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODEXPEDFEV() {
        return this.codexpedfev;
    }

    public void setCODEXPEDFEV(int i) {
        this.codexpedfev = i;
    }
}
