package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CALIFICADOR_LOCAL_ROP_Type", propOrder = {"empresa", "tipocalificadorrop", "codigoalfanum8"})
public class CALIFICADORLOCALROPType {
    @XmlElement(name = "CODIGO_ALFANUM_8", required = true)
    protected String codigoalfanum8;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "TIPO_CALIFICADOR_ROP", required = true)
    protected String tipocalificadorrop;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getTIPOCALIFICADORROP() {
        return this.tipocalificadorrop;
    }

    public void setTIPOCALIFICADORROP(String str) {
        this.tipocalificadorrop = str;
    }

    public String getCODIGOALFANUM8() {
        return this.codigoalfanum8;
    }

    public void setCODIGOALFANUM8(String str) {
        this.codigoalfanum8 = str;
    }
}
