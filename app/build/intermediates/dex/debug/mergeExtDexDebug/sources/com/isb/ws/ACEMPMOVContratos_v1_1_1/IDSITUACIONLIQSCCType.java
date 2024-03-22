package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SITUACION_LIQ_SCC_Type", propOrder = {"empresa", "codalfanum5"})
public class IDSITUACIONLIQSCCType {
    @XmlElement(name = "COD_ALFANUM_5", required = true)
    protected String codalfanum5;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFANUM5() {
        return this.codalfanum5;
    }

    public void setCODALFANUM5(String str) {
        this.codalfanum5 = str;
    }
}
