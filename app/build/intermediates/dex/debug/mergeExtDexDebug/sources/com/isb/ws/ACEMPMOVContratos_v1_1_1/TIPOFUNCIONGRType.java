package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FUNCION_GR_Type", propOrder = {"empresa", "codalfajusti4"})
public class TIPOFUNCIONGRType {
    @XmlElement(name = "COD_ALFAJUSTI_4", required = true)
    protected String codalfajusti4;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODALFAJUSTI4() {
        return this.codalfajusti4;
    }

    public void setCODALFAJUSTI4(String str) {
        this.codalfajusti4 = str;
    }
}
