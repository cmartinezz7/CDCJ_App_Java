package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_TIPO_SCORE_BIL_Type", propOrder = {"empresa", "codigoalfanum3"})
public class IDTIPOSCOREBILType {
    @XmlElement(name = "CODIGO_ALFANUM_3", required = true)
    protected String codigoalfanum3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOALFANUM3() {
        return this.codigoalfanum3;
    }

    public void setCODIGOALFANUM3(String str) {
        this.codigoalfanum3 = str;
    }
}
