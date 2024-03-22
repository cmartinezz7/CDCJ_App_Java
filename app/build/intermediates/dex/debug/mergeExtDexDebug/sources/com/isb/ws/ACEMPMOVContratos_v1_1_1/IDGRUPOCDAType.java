package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_GRUPO_CDA_Type", propOrder = {"empresa", "codalfanum8"})
public class IDGRUPOCDAType {
    @XmlElement(name = "COD_ALFANUM_8", required = true)
    protected String codalfanum8;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM8() {
        return this.codalfanum8;
    }

    public void setCODALFANUM8(String str) {
        this.codalfanum8 = str;
    }
}
