package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_ROL_GR_Type", propOrder = {"empresa", "codalfajusti3"})
public class TIPOROLGRType {
    @XmlElement(name = "COD_ALFAJUSTI_3", required = true)
    protected String codalfajusti3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFAJUSTI3() {
        return this.codalfajusti3;
    }

    public void setCODALFAJUSTI3(String str) {
        this.codalfajusti3 = str;
    }
}
