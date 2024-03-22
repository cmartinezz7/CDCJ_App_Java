package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTROL_ROP_Type", propOrder = {"empresa", "modulorop", "tipocontrolrop", "codalfanum3"})
public class CONTROLROPType {
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "MODULO_ROP", required = true)
    protected String modulorop;
    @XmlElement(name = "TIPO_CONTROL_ROP", required = true)
    protected String tipocontrolrop;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getMODULOROP() {
        return this.modulorop;
    }

    public void setMODULOROP(String str) {
        this.modulorop = str;
    }

    public String getTIPOCONTROLROP() {
        return this.tipocontrolrop;
    }

    public void setTIPOCONTROLROP(String str) {
        this.tipocontrolrop = str;
    }

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }
}
