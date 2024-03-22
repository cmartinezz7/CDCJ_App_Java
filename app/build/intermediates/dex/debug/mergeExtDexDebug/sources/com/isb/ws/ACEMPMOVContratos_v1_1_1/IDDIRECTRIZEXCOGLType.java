package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_DIRECTRIZ_EXCOGL_Type", propOrder = {"empresa", "coddirectriz"})
public class IDDIRECTRIZEXCOGLType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_DIRECTRIZ")
    protected int coddirectriz;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public int getCODDIRECTRIZ() {
        return this.coddirectriz;
    }

    public void setCODDIRECTRIZ(int i) {
        this.coddirectriz = i;
    }
}
