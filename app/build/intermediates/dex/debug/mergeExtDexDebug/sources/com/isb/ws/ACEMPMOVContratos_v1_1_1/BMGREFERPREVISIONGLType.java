package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_REFER_PREVISION_GL_Type", propOrder = {"empresa", "codigoalfanum25"})
public class BMGREFERPREVISIONGLType {
    @XmlElement(name = "CODIGO_ALFANUM_25", required = true)
    protected String codigoalfanum25;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM25() {
        return this.codigoalfanum25;
    }

    public void setCODIGOALFANUM25(String str) {
        this.codigoalfanum25 = str;
    }
}
