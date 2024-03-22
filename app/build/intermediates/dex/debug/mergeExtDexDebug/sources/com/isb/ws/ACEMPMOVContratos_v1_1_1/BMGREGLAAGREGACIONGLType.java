package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_REGLA_AGREGACION_GL_Type", propOrder = {"empresa", "codigoalfanum18"})
public class BMGREGLAAGREGACIONGLType {
    @XmlElement(name = "CODIGO_ALFANUM_18", required = true)
    protected String codigoalfanum18;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM18() {
        return this.codigoalfanum18;
    }

    public void setCODIGOALFANUM18(String str) {
        this.codigoalfanum18 = str;
    }
}
