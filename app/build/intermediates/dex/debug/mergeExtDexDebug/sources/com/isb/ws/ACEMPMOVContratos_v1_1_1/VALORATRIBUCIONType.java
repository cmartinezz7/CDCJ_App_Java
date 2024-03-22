package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_ATRIBUCION_Type", propOrder = {"empresa", "tipoatribucion", "codalfanum2"})
public class VALORATRIBUCIONType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_ATRIBUCION", required = true)
    protected String tipoatribucion;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOATRIBUCION() {
        return this.tipoatribucion;
    }

    public void setTIPOATRIBUCION(String str) {
        this.tipoatribucion = str;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
